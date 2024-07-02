package org.example.health;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "서버 상태 체크")
public class HealthController {

    @GetMapping("/health")
    @Operation(summary = "서버 상태 체크")
    public String health() {
        return "OK";
    }
}
