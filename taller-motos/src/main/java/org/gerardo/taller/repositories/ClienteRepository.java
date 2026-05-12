package org.gerardo.taller.repositories;

import org.gerardo.taller.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente>{
    Cliente buscarPorEmail(String email); // Metodo exclusivo
}
