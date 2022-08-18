package developer.mz.SpringBootSecurityJWT.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 4735266196076048961L;
	
	private String username;
	private String password;
}