package org.gerardo.taller;

import jakarta.persistence.EntityManager;
import org.gerardo.taller.models.Cliente;
import org.gerardo.taller.utils.JpaUtil;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Iniciando Hibernate...");

        // Solo pedimos el EntityManager, JpaUtil se encarga del Singleton por detrás
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            // Vamos a registrar un segundo cliente de prueba
            Cliente amiga = new Cliente("Vane", "García", "vane@email.com", "5587654321");
            em.persist(amiga);

            em.getTransaction().commit();
            System.out.println("¡Segundo cliente guardado exitosamente con ID: " + amiga.getId());

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            // Solo apagamos el Factory al final de la ejecución total del programa
            JpaUtil.close();
        }
    }
}
