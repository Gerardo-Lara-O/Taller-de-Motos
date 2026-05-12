package org.gerardo.taller.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import org.gerardo.taller.models.Cliente;

@ApplicationScoped
public class ClienteRepositoryImpl extends AbstractRepository<Cliente> implements ClienteRepository{

    public ClienteRepositoryImpl(){
        super(Cliente.class);
    }


    @Override
    public Cliente buscarPorEmail(String email) {
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", Cliente.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
