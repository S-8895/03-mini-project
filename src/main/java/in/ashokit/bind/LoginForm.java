package in.ashokit.bind;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class LoginForm {
	 private String email;
	 private String pwd;
}
