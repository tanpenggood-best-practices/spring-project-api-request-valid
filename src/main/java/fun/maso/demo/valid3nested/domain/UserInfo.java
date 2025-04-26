
package fun.maso.demo.valid3nested.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserInfo {

    @NotBlank(message = "收货人姓名不能为空")
    private String recipientName;

    @NotBlank(message = "收货地址不能为空")
    private String address;

    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "收货人手机号格式不正确")
    private String phone;

}