package fun.maso.demo.valid3nested.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDTO {

    @NotBlank(message = "订单号不能为空")
    private String orderNumber;

    @NotNull(message = "用户信息不能为空")
    @Valid // 必须添加 @Valid 来触发嵌套校验
    private UserInfo nestedUserInfo;

}