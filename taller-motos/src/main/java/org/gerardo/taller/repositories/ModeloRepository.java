package org.gerardo.taller.repositories;

import org.gerardo.taller.models.Modelo;

public interface ModeloRepository extends CrudRepository<Modelo>{
    // Si en el futuro necesitas buscar todos los modelos de una Marca específica,
    // el método iría aquí. Por ahora, el CRUD básico es suficiente.
}
