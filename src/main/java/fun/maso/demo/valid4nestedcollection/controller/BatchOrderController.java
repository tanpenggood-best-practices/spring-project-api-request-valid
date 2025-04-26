package fun.maso.demo.valid4nestedcollection.controller;

import fun.maso.demo.valid4nestedcollection.domain.BatchOrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/valid4nestedcollection/batch-orders")
public class BatchOrderController {

    @PostMapping
    public ResponseEntity<?> createBatchOrder(@Validated @RequestBody BatchOrderDTO batchOrderDTO) {
        // 如果 batchOrderDTO 或其 orderItems 列表中的任何一个 OrderItemDTO 校验失败，
        // 会抛出 MethodArgumentNotValidException
        // ... 业务逻辑
        return ResponseEntity.ok("Batch order created");
    }
}