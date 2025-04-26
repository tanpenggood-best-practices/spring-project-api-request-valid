package fun.maso.demo.valid5custom.controller;

import fun.maso.demo.valid1base.domain.UserDTO;
import fun.maso.demo.valid5custom.domain.SimpleUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/valid5custom/users")
public class SimpleUserController {

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Validated @RequestBody SimpleUserDTO simpleUserDTO) {
        // 校验通过，执行业务逻辑
        // ...
        return ResponseEntity.ok("User created successfully");
    }
}