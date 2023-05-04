package in.ashokit.bind;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RegistrationForm {
    
	private String fname;
	private String lname;
	private String email;
	private String pwd;
}
