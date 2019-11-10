package com.example.notesapp.repository;

import com.example.notesapp.models.Notes;
import com.example.notesapp.models.User;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class NotesRespository {
    public static List<Notes> note = new ArrayList<>();
    static{
        note.add(new Notes("Actuacion", "Actuacion de mi hija"));
        note.add(new Notes("Baila", "Baile de mi hija"));
        note.add(new Notes("Karaoke", "Karaoke con amigos"));
    }
    public static void create(String title,String descripcion){
        Notes note = new Notes(title,descripcion);
        SugarRecord.save(note);
    }
}
