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
    @PostMapping
    public ResponseEntity<?> createProduct(@Validated({CreateValidationGroup.class, Default.class}) @RequestBody ProductDTO productDTO) {
        // ... 业务逻辑
        return ResponseEntity.ok("Product created");
    }

    // 更新产品时，只校验 UpdateValidationGroup 和 Default 分组
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @Validated({UpdateValidationGroup.class, Default.class}) @RequestBody ProductDTO productDTO) {
        productDTO.setId(id); // 通常会从路径获取 ID
        // ... 业务逻辑
        return ResponseEntity.ok("Product updated");
    }
}