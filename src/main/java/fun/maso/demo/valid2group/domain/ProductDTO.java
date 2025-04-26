package fun.maso.demo.valid2group.domain;

import fun.maso.demo.valid2group.validation.CreateValidationGroup;
import fun.maso.demo.valid2group.validation.UpdateValidationGroup;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default; // 默认分组
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    // ID 在更新时必须有，在创建时不能有 (或者由系统生成，不需校验)
    @NotNull(message = "更新时ID不能为空", groups = UpdateValidationGroup.class)
    private Long id;

    // 名称在创建和更新时都必须有
    @NotBlank(message = "产品名称不能为空", groups = {CreateValidationGroup.class, UpdateValidationGroup.class})
    private String name;

    // 描述只在创建时必须有
    @NotBlank(message = "创建时产品描述不能为空", groups = CreateValidationGroup.class)
    private String description;

    // 价格在所有场景下都校验 (不指定 group 或指定 Default.class)
    @NotNull(message = "价格不能为空") // 等同于 groups = Default.class
    @DecimalMin(value = "0.01", message = "价格必须大于0.01")
    private BigDecimal price;

}