package org.gerardo.taller.repositories;

import org.gerardo.taller.models.Marca;

public interface MarcaRepository extends CrudRepository<Marca>{
    Marca buscarPorNombre(String nombre);
}
