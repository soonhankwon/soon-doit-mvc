package soon.soondoitmvc.dto;

import lombok.Getter;

@Getter
public class LoginReqDto {

    private String name;

    private String password;

    public LoginReqDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
