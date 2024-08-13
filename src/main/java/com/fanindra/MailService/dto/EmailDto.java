package com.fanindra.MailService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmailDto {
    private Integer id;
    private String subject;
    private String body;
    private List<String> to;
}
