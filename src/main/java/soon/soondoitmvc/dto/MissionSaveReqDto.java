package soon.soondoitmvc.dto;

import lombok.Getter;

@Getter
public class MissionSaveReqDto {
    private final String content;
    private final String deadLine;

    public MissionSaveReqDto(String content, String deadLine) {
        this.content = content;
        this.deadLine = deadLine;
    }
}
