package soon.soondoitmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionUpdateReqDto {

    private String deadLine;
    private String content;
    private String status;
}
