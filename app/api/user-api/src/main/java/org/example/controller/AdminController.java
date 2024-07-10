package org.example.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.controller.dto.request.AdminLoginApiRequest;
import org.example.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(
        @Valid @RequestBody AdminLoginApiRequest adminLoginApiRequest
    ) {
        adminService.signup(adminLoginApiRequest.toServiceRequest());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

}
