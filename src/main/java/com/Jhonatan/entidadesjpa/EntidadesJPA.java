package com.Jhonatan.entidadesjpa;

import com.Jhonatan.entidadesjpa.Logica.Estudiante;
import com.Jhonatan.entidadesjpa.Logica.EstudianteDao;

public class EntidadesJPA {

    public static void main(String[] args) {
        EstudianteDao estudianteDao = new EstudianteDao();
        Estudiante e1 = new Estudiante();
        e1.setNombre("Jhonatan");
    

        estudianteDao.insertarEstudiante(e1);
    }
}
