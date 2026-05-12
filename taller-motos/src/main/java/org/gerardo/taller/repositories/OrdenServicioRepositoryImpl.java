package org.gerardo.taller.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import org.gerardo.taller.models.OrdenServicio;
@ApplicationScoped
public class OrdenServicioRepositoryImpl extends AbstractRepository<OrdenServicio> implements OrdenServicioRepository {

    public OrdenServicioRepositoryImpl(){
        super(OrdenServicio.class);
    }
}
