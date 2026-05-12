package org.gerardo.taller.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import org.gerardo.taller.models.Modelo;

@ApplicationScoped
public class ModeloRepositoryImpl extends AbstractRepository<Modelo> implements ModeloRepository{

    public ModeloRepositoryImpl(){
        super(Modelo.class);
    }
}
