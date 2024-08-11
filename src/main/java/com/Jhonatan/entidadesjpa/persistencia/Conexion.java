package com.Jhonatan.entidadesjpa.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {

    private static EntityManagerFactory emf = null;

    public static EntityManager createEntityManager() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("entidadesJPAPU");
                System.out.println("conectado");
            }
        } catch (Exception e) {
            System.out.println("error al conectar " + e.getMessage());
        }
        return emf.createEntityManager();
    }
}
