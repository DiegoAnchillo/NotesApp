package com.example.notesapp.models;

import com.orm.dsl.Table;

@Table
public class Notes {
    private String title;
    private String descripcion;

    public Notes() {
    }

    public Notes(String title, String descripcion) {
        this.title = title;
        this.descripcion = descripcion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "title='" + title + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
