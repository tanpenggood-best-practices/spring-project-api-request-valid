package fun.maso.demo.valid6customcrossfield.domain;

import fun.maso.demo.valid6customcrossfield.annotation.PasswordMatches;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatches // 应用在类级别
public class RegistrationDTO {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 8, max = 32, message = "密码位数必须在{min}到{max}位之间")
    private String password;

    @NotBlank
    private String confirmPassword;

}