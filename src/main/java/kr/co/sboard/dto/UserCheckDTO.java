package kr.co.sboard.dto;

import lombok.*;

@Data
@Builder
public class UserCheckDTO {
    private String type;
    private String value;
}
