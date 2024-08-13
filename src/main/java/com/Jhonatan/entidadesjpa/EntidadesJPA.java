package com.Jhonatan.entidadesjpa;

import com.Jhonatan.entidadesjpa.Logica.Estudiante;
import com.Jhonatan.entidadesjpa.Logica.EstudianteDao;

public class EntidadesJPA {

    public static void main(String[] args) {
        listaEstudiantes();
    }

    public static void modificarEstudiante() {
        EstudianteDao estudianteDao = new EstudianteDao();
        Estudiante e2 = new Estudiante(1, "Aron");
        estudianteDao.modificarEstudiante(e2);
    }

    public static void insertarEstudiante() {
        EstudianteDao estudianteDao = new EstudianteDao();
        Estudiante e1 = new Estudiante();
        e1.setNombre("Juan");

        estudianteDao.insertarEstudiante(e1);
    }

    public static void eliminarEstudiante() {
        EstudianteDao estudianteDao = new EstudianteDao();
        Estudiante e3 = new Estudiante();
        e3.setIdEstudiante(2);
        estudianteDao.eliminarEstudiante(e3);
    }

    public static void listaEstudiantes() {
        EstudianteDao de = new EstudianteDao();
        de.listarEstudiantes();
    }
}
