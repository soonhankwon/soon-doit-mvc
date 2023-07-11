package soon.soondoitmvc.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class SignupReqDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    public SignupReqDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
