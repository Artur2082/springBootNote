package com.hillel.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.sql.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {
    private int id;
    private String name;
    private String content;
    private Date createdAt;
}
