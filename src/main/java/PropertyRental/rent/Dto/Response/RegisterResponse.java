package PropertyRental.rent.Dto.Response;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RegisterResponse {

	private final Long id;
    private final String fullName;
    private final String email;
    private final String phone;
    
//    public RegisterResponse(Long id, String fullName, String email, String phone) {
//    	this.id = id;
//    	this.fullName = fullName;
//    	this.email = email;
//    	this.phone = phone;
//    }
}
