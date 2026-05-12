package org.gerardo.taller.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import org.gerardo.taller.models.DetalleOrden;

@ApplicationScoped
public class DetalleOrdenRepositoryImpl extends AbstractRepository<DetalleOrden> implements DetalleOrdenRepository {

    public DetalleOrdenRepositoryImpl(){
        super(DetalleOrden.class);
    }
}
