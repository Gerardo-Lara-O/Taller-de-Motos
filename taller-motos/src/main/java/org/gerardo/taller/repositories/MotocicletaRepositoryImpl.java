package org.gerardo.taller.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import org.gerardo.taller.models.Motocicleta;


@ApplicationScoped
public class MotocicletaRepositoryImpl extends AbstractRepository<Motocicleta> implements MotocicletaRepository{

    public MotocicletaRepositoryImpl(){
        super(Motocicleta.class);
    }

}
