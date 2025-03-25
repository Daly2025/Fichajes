package com.formacom;

import java.time.LocalDateTime;

public class Registro {
    private Alumno alumno;
    private LocalDateTime fecha;
    private String modo;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }


    public Registro(Alumno alumno, String modo) {
        this.alumno = alumno;
        this.modo = modo;
        fecha=LocalDateTime.now();

    }
}

