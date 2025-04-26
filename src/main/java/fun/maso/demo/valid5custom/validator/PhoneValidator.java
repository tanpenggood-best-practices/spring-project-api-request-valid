package fun.maso.demo.valid5custom.validator;

import fun.maso.demo.valid5custom.annotation.ValidPhone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    // 可以从注解获取自定义属性，如果定义了的话
    // private String region;

    private static final Pattern CN_PHONE_PATTERN = Pattern.compile("^1[3-9]\\d{9}$");

    @Override
    public void initialize(ValidPhone constraintAnnotation) {
        // 在这里可以获取注解的属性值
        // this.region = constraintAnnotation.region();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            // 对于非 @NotNull/@NotBlank 的字段，允许 null 或空字符串通过，
            // 让 @NotNull/@NotBlank 来处理空值校验。
            // 如果自定义注解本身要求非空，则在这里返回 false。
            return true;
        }

        // 实际校验逻辑
        // if ("CN".equals(region)) { ... }
        return CN_PHONE_PATTERN.matcher(value).matches();

        // 如果需要禁用默认的错误消息，并使用自定义消息模板：
        // context.disableDefaultConstraintViolation();
        // context.buildConstraintViolationWithTemplate("自定义错误消息 {invalidValue}")
        //        .addPropertyNode("fieldName") // 可以指定错误关联的字段（如果注解用在类级别）
        //        .addConstraintViolation();
        // return false;
    }
}