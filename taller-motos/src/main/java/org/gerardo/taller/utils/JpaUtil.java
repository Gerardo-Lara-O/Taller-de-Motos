package org.gerardo.taller.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    // Usamos el singleton
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        try{
            return Persistence.createEntityManagerFactory("tallerMotosPU");
        } catch (Throwable ex) {
            System.err.println("Fallo critico al inicializar el EntityManager Factory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Factory Metho publico para que los Repositories usen el EntityManager
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    // Metodo para apagar la fabrica cuando se detenga el servido
    public static void close(){
        if (emf != null && emf.isOpen()){
            emf.close();
        }
    }
}
