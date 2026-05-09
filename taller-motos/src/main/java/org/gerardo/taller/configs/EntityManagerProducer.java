package org.gerardo.taller.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import org.gerardo.taller.utils.JpaUtil;

@ApplicationScoped
public class EntityManagerProducer {

    @Produces
    @RequestScoped // crea el EntityM nuevo por cada peticion web
    public EntityManager produceEntityManager(){
        return JpaUtil.getEntityManager();
    }

    // CDI llamará a este método automáticamente cuando termine la petición web para cerrar la conexión
    public void closeEntityManager(@Disposes EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
