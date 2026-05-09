package org.gerardo.taller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gerardo.taller.models.Cliente;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Iniciando Hibernate...");

        // 1. Construir la fábrica (Operación pesada)
        // "tallerMotosPU" debe coincidir con el name en persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tallerMotosPU");

        // 2. Obtener el gestor de entidades (Operación ligera)
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciamos la transacción manualmente
            em.getTransaction().begin();

            // Creamos nuestro objeto Java
            Cliente cliente = new Cliente("Gerardo", "Lara", "gerardo@email.com", "5512345678");

            // Le decimos a JPA que persista el objeto (lo convierte a un INSERT de SQL)
            em.persist(cliente);

            // Confirmamos la transacción
            em.getTransaction().commit();

            System.out.println("¡Éxito! Cliente guardado con el ID asignado por BD: " + cliente.getId());

        } catch (Exception e) {
            // Si algo falla, hacemos rollback para no dejar datos corruptos
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Cerramos los recursos
            em.close();
            emf.close();
        }
    }
}
