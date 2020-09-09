package com.spring.notesapplication.dto;

import com.spring.notesapplication.model.Status;
import lombok.Data;

@Data
public class NotesDto {
    private String heading;
    private String description;
    private Status Status;
}
