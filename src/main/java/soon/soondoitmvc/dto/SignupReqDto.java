package soon.soondoitmvc.dto;

import lombok.Getter;

@Getter
public class SignupReqDto {

    private String name;
    private String password;

    public SignupReqDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
