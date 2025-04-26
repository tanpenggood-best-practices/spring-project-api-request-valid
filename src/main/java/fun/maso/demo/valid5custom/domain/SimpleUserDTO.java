package fun.maso.demo.valid5custom.domain;

import fun.maso.demo.valid5custom.annotation.ValidPhone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SimpleUserDTO {

    @NotBlank(message = "用户名不能为空") // 字符串：非null且去除头尾空格后不为空
    @Size(min = 2, max = 20, message = "用户名长度必须在 {min} 到 {max} 之间")
    private String username;

    @ValidPhone // 使用自定义注解
    private String phoneNumber;

}