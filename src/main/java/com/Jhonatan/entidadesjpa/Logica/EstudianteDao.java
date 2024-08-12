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

    public void modificarEstudiante(Estudiante estudiante) {
        //llamamos al conexion
        EntityManager em = null;
        try {
            em = Conexion.createEntityManager();
            //buscamos el estudiante
            Estudiante e = em.find(Estudiante.class, estudiante.getIdEstudiante());
            em.getTransaction().begin();

            //si contiene el objeto 
            if (!em.contains(e)) {
                System.out.println("no se encontro dicho estudiante ");
            } else {
                //actualizamos
                em.merge(estudiante);
                System.out.println("estudiante modificado");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error al modificar " + e.getMessage());
        } finally {
            //cerramos la conexion
            if (em != null) {
                em.close();
            }
        }
    }

}
