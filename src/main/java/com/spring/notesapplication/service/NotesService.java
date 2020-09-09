package com.spring.notesapplication.service;

import com.spring.notesapplication.model.Notes;
import com.spring.notesapplication.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NotesService {

    @Autowired
    NotesRepository notesRepository;

    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    public Notes addNotes(Notes notes) {
        Notes notes1 = null;
        if(Objects.nonNull(notes)) {
            notes1 = notesRepository.save(notes);
        }
        return  notes1;
    }
}
