package dto;

import lombok.Data;

@Data
public class ChatDto {
    private Integer channelId;
    private Integer writeId;
    private String chat;
}
