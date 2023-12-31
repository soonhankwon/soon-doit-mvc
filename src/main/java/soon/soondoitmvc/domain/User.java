package soon.soondoitmvc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import soon.soondoitmvc.dto.SignupReqDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@ToString
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    public User(SignupReqDto dto) {
        this.name = dto.getName();
        this.password = dto.getPassword();
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }
}