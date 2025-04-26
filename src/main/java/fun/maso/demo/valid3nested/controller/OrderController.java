package fun.maso.demo.valid3nested.controller;

import fun.maso.demo.valid3nested.domain.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/valid3nested/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity<?> createOrder(@Validated @RequestBody OrderDTO orderDTO) {
        // 如果 orderDTO 或 nestedUserInfo 校验失败，会抛出 MethodArgumentNotValidException
        // ... 业务逻辑
        return ResponseEntity.ok("Order created");
    }
}