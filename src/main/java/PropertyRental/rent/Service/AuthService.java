package PropertyRental.rent.Service;


import org.springframework.security.crypto.password.PasswordEncoder;

import PropertyRental.rent.Dto.Request.RegisterRequest;
import PropertyRental.rent.Dto.Response.RegisterResponse;
import PropertyRental.rent.Entity.User;
import PropertyRental.rent.Repository.UserRepository;
import PropertyRental.rent.Security.JwtService;
import PropertyRental.rent.Service.impl.AuthServiceimpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthService implements AuthServiceimpl {

    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public RegisterResponse register(RegisterRequest request) {

        // Check if email or fullname already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByFullName(request.getFullname())) {
            throw new RuntimeException("Full name already exists");
        }

        // Create new user
        User user = new User();
        user.setFullName(request.getFullname());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
       return new RegisterResponse(
    		   user.getId(),
    		   user.getEmail(),
    		   user.getFullName(),
    		   user.getPhone()
    		   );
    }
}
