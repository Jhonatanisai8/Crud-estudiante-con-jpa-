package com.Jhonatan.entidadesjpa.Logica;

import com.Jhonatan.entidadesjpa.persistencia.Conexion;
import javax.persistence.EntityManager;

public class EstudianteDao {

    public void insertarEstudiante(Estudiante estudiante) {
        //llamamos al conexion
        EntityManager em = null;
        try {
            em = Conexion.createEntityManager();
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
            System.out.println("estudiante inseertardo");
        } catch (Exception e) {
            System.out.println("error al insertar " + e.getMessage());
        } finally {
            //cerramos la conexion
            if (em != null) {
                em.close();
            }
        }
    }
    
}
