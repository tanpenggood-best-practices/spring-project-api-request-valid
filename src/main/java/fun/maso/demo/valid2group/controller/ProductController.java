package fun.maso.demo.valid2group.controller;

import fun.maso.demo.valid2group.domain.ProductDTO;
import fun.maso.demo.valid2group.validation.CreateValidationGroup;
import fun.maso.demo.valid2group.validation.UpdateValidationGroup;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/valid2group/products")
public class ProductController {

    // 创建产品时，只校验 CreateValidationGroup 和 Default 分组
    @PostMapping("/v1")
    public ResponseEntity<?> createProductV1(@Validated({CreateValidationGroup.class, Default.class}) @RequestBody ProductDTO productDTO) {
        // ... 业务逻辑
        return ResponseEntity.ok("Product v1 created");
    }

    // 创建产品时，只指定 CreateValidationGroup 注解，则不会对 Default 分组的字段行校验
    @PostMapping("/v2")
    public ResponseEntity<?> createProductV2(@Validated({CreateValidationGroup.class}) @RequestBody ProductDTO productDTO) {
        // ... 业务逻辑
        return ResponseEntity.ok("Product v2 created");
    }

    // 更新产品时，只校验 UpdateValidationGroup 和 Default 分组
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @Validated({UpdateValidationGroup.class, Default.class}) @RequestBody ProductDTO productDTO) {
        productDTO.setId(id); // 通常会从路径获取 ID
        // ... 业务逻辑
        return ResponseEntity.ok("Product updated");
    }
}