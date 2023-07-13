package soon.soondoitmvc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import soon.soondoitmvc.dto.MissionUpdateReqDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deadLine;

    private String content;

    private String status;

    private LocalDateTime created_at;

    @ManyToOne
    private User user;

    public Mission(String deadLine, String content) {
        this.deadLine = deadLine;
        this.content = content;
        this.status = "NOT YET";
        this.created_at = LocalDateTime.now();
    }

    public void update(MissionUpdateReqDto dto) {
        this.deadLine = dto.getDeadLine();
        this.content = dto.getContent();
        this.status = dto.getStatus();
    }
}
