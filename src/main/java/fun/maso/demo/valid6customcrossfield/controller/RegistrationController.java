package fun.maso.demo.valid6customcrossfield.controller;

import fun.maso.demo.valid5custom.domain.SimpleUserDTO;
import fun.maso.demo.valid6customcrossfield.domain.RegistrationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/valid6customcrossfield/users")
public class RegistrationController {

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@Validated @RequestBody RegistrationDTO registrationDTO) {
        // 校验通过，执行业务逻辑
        // ...
        return ResponseEntity.ok("User registration successfully");
    }
}