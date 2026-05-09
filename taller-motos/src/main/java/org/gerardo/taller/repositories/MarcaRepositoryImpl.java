package org.gerardo.taller.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import org.gerardo.taller.models.Marca;

@ApplicationScoped
public class MarcaRepositoryImpl extends AbstractRepository<Marca> implements MarcaRepository{

    // Le decimos a la clase abstracta padre que nosotros trabajamos con la tabla "Marca"
    public MarcaRepositoryImpl() {
        super(Marca.class);
    }

    // Implementamos solo lo que es exclusivo de Marca
    @Override
    public Marca buscarPorNombre(String nombre) {
        try {
            return em.createQuery("SELECT m FROM Marca m WHERE m.nombre = :nombre", Marca.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Si no encuentra la marca, retorna null
        }
    }
}
