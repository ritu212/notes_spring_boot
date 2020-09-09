package com.spring.notesapplication.controller;

import com.spring.notesapplication.dto.NotesDto;
import com.spring.notesapplication.model.Notes;
import com.spring.notesapplication.service.NotesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class NotesController {

    @Autowired
    NotesService notesService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("getAllNotes")
    public List<Notes> getAllNotes() {
     return notesService.getAllNotes();
    }

    @PostMapping("addNotes")
    public ResponseEntity<?> addNotes(@RequestBody NotesDto notesDto) {
       Notes notes = modelMapper.map(notesDto, Notes.class);
       notes = notesService.addNotes(notes);
       if(Objects.nonNull(notes)) {
           return new ResponseEntity<>(notes, HttpStatus.OK);
       }
       else
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
