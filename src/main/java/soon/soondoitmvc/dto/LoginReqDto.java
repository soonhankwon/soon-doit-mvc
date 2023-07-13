package soon.soondoitmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public final class LoginReqDto {

    @NotEmpty
    private final String name;

    @NotEmpty
    private final String password;
}
