package fun.maso.demo.valid5custom.annotation;

import fun.maso.demo.valid5custom.validator.PhoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class) // 指定校验器
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhone {

    String message() default "无效的手机号码格式"; // 默认错误消息

    Class<?>[] groups() default {}; // 默认分组

    Class<? extends Payload>[] payload() default {}; // Payload

    // 可以添加自定义属性
    // String region() default "CN";
}