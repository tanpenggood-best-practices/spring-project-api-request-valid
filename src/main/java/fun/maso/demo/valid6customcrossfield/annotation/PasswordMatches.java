package fun.maso.demo.valid6customcrossfield.annotation;

import fun.maso.demo.valid6customcrossfield.validator.PasswordMatchesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE }) // 应用在类上
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "密码和确认密码不匹配";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String passwordFieldName() default "password"; // 新增属性：密码字段名
    String confirmPasswordFieldName() default "confirmPassword"; // 新增属性：确认密码字段名
}