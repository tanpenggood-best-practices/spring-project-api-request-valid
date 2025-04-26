package fun.maso.demo.valid6customcrossfield.validator;

import fun.maso.demo.valid6customcrossfield.annotation.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl; // Spring BeanUtils

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> { // 处理 Object 类型

    private String passwordFieldName;
    private String confirmPasswordFieldName;
    private String message;

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        this.passwordFieldName = constraintAnnotation.passwordFieldName();
        this.confirmPasswordFieldName = constraintAnnotation.confirmPasswordFieldName();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 使用 Spring 的 BeanWrapper 或 Apache Commons BeanUtils 获取字段值
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(value);
        Object passwordValue = beanWrapper.getPropertyValue(passwordFieldName);
        Object confirmPasswordValue = beanWrapper.getPropertyValue(confirmPasswordFieldName);

        boolean matched = (passwordValue == null && confirmPasswordValue == null) ||
                          (passwordValue != null && passwordValue.equals(confirmPasswordValue));

        if (!matched) {
            // 如果校验失败，最好将错误信息关联到具体的字段上（例如确认密码字段）
            context.disableDefaultConstraintViolation(); // 禁用默认错误消息（应用在类上）
            context.buildConstraintViolationWithTemplate(message)
                   .addPropertyNode(confirmPasswordFieldName) // 将错误关联到 confirmPassword 字段
                   .addConstraintViolation();
        }

        return matched;
    }
}