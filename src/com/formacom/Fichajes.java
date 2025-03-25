package com.formacom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fichajes implements IFichajes {
    private List<Alumno> listaAlumnos;
    private String modo;
    private List<Registro> registros;

    public Fichajes() {
        listaAlumnos=new ArrayList<>();
        registros=new ArrayList<>();
        modo="Entrada";
    }

    @Override
    public Boolean login(String user, String pass) {
        if(user.equals("admin") && pass.equals("1234")){
            return true;
        }
        return false;
    }

    @Override
    public String alta_alumno(String dni, String nombre) {
        Alumno alumno = new Alumno(dni, nombre);
        if (listaAlumnos.contains(alumno)) {
            return "El alumno ya existe con ese DNI";
        }
        listaAlumnos.add(alumno);
        return "Alumno añadido correctamente";
    }

    @Override
    public String cambiar_modo(String modo) {
        this.modo=modo;
        return this.modo;
    }

    @Override
    public List<Registro> informe_por_dia(LocalDate dia) {
        List<Registro> informe=new ArrayList<>();
        for (Registro registro : registros) {
            if(registro.getFecha().toLocalDate().equals(dia)){
                informe.add(registro);
            }
        }
        return informe;
    }

    @Override
    public List<Registro> informe_por_alumno(String dni) {
        List<Registro>informe=new ArrayList<>();
        for (Registro registro:registros){
            if (registro.getAlumno().getDni().equals(dni)){
                informe.add(registro);
            }
        }
        return informe;
    }

    @Override
    public String fichar(String dni) {
        return "";
    }
}