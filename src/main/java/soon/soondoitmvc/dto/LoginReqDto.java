package soon.soondoitmvc.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class LoginReqDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    public LoginReqDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
