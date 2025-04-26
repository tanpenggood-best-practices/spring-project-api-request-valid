package fun.maso.demo.valid4nestedcollection.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class BatchOrderDTO {

    @NotBlank(message = "批次号不能为空")
    private String batchId;

    @NotEmpty(message = "订单列表不能为空")
    @Size(min = 1, message = "至少包含一个订单")
    private List<@Valid OrderItemDTO> orderItems; // 在集合的泛型参数前加 @Valid，或者直接在字段上加 @Valid 都可以

    // 或者更常见的写法，在字段上加 @Valid
    // @NotEmpty(message = "订单列表不能为空")
    // @Size(min = 1, message = "至少包含一个订单")
    // @Valid // 应用于集合字段，会校验集合中的每个元素
    // private List<OrderItemDTO> orderItems;

}