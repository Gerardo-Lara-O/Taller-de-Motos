package org.gerardo.taller.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import org.gerardo.taller.models.ItemCatalogo;

@ApplicationScoped
public class ItemCatalogoRepositoryImpl extends AbstractRepository<ItemCatalogo> implements ItemCatalogoRepository {

    public ItemCatalogoRepositoryImpl(){
        super(ItemCatalogo.class);
    }
}
