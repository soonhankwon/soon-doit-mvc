package soon.soondoitmvc.domain;

import lombok.NoArgsConstructor;
import soon.soondoitmvc.dto.SignupReqDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private LocalDateTime created_at;

    private LocalDateTime modified_at;

    public User(SignupReqDto dto) {
        this.name = dto.getName();
        this.password = dto.getPassword();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }

    public boolean isPasswordValid(String password) {
        return this.password.equals(password);
    }
}
