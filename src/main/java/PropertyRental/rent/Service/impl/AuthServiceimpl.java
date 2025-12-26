package PropertyRental.rent.Service.impl;

import PropertyRental.rent.Dto.Request.RegisterRequest;
import PropertyRental.rent.Dto.Response.RegisterResponse;

public interface AuthServiceimpl {
	
	RegisterResponse register(RegisterRequest request);

}
