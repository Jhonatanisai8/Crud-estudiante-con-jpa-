package com.Jhonatan.entidadesjpa.Logica;

import com.Jhonatan.entidadesjpa.persistencia.Conexion;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;

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

            if (e == null) {
                System.out.println("no se encontro dicho estudiante.");
                return;
            }
            //si contiene el objeto 
            if (em.contains(e)) {
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

    public void eliminarEstudiante(Estudiante estudiante) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = Conexion.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Buscar la entidad en la base de datos
            Estudiante e = em.find(Estudiante.class, estudiante.getIdEstudiante());
            if (e != null) {
                em.remove(e);
                System.out.println("Estudiante eliminado");
            } else {
                System.out.println("Estudiante no encontrado");
            }

            // Confirmar la transacción
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                // Revertir la transacción en caso de error
                tx.rollback();
            }
            System.out.println("Error al eliminar estudiante => " + e.getMessage());
        } finally {
            // Asegurarnos de cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

}
