package PropertyRental.rent.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import PropertyRental.rent.Dto.Request.RegisterRequest;
import PropertyRental.rent.Dto.Response.RegisterResponse;
import PropertyRental.rent.Repository.UserRepository;
import PropertyRental.rent.Security.JwtService;
import PropertyRental.rent.Service.impl.AuthServiceimpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthController {
	

    private final AuthServiceimpl authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @Validated @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

}
