package com.Jhonatan.entidadesjpa;

import com.Jhonatan.entidadesjpa.Logica.Estudiante;
import com.Jhonatan.entidadesjpa.Logica.EstudianteDao;

public class EntidadesJPA {

    public static void main(String[] args) {
        modificarEstudiante();
    }

    public static void modificarEstudiante() {
        EstudianteDao estudianteDao = new EstudianteDao();
        Estudiante e2 = new Estudiante(4, "Juana");
        estudianteDao.modificarEstudiante(e2);
    }

    public static void insertarEstudiante() {
        EstudianteDao estudianteDao = new EstudianteDao();
        Estudiante e1 = new Estudiante();
        e1.setNombre("Juan");

        estudianteDao.insertarEstudiante(e1);

    }
}
