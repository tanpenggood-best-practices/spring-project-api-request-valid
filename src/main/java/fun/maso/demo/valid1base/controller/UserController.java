package fun.maso.demo.valid1base.controller;

import fun.maso.demo.valid1base.domain.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/valid1base/users")
public class UserController {

    // 方式一：使用 @Validated，并注入 BindingResult 获取校验结果 (推荐)
    // BindingResult 必须紧跟在 @Validated 参数后面
    @PostMapping("/create1")
    public ResponseEntity<?> createUser1(@Validated @RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 手动处理校验错误，例如返回错误信息列表
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        // 校验通过，执行业务逻辑
        // ...
        return ResponseEntity.ok("User created successfully");
    }

    // 方式二：不注入 BindingResult，让 Spring 抛出 MethodArgumentNotValidException (更常用)
    // 需要配置全局异常处理器来捕获此异常并返回统一格式的错误响应
    @PostMapping("/create2")
    public ResponseEntity<?> createUser2(@Validated @RequestBody UserDTO userDTO) {
        // 校验通过，执行业务逻辑
        // ...
        return ResponseEntity.ok("User created successfully");
    }
}