package org.gerardo.taller;

import jakarta.persistence.EntityManager;
import org.gerardo.taller.models.Cliente;
import org.gerardo.taller.utils.JpaUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            // Creamos nuestro objeto Java
            Cliente cliente = new Cliente("Gerardo", "Lara", "gerardoo@email.com", "5512345678");

            // Le decimos a JPA que persista el objeto (lo convierte a un INSERT de SQL)
            em.persist(cliente);

            em.getTransaction().commit();


        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();

            JpaUtil.close();
        }
    }
}
