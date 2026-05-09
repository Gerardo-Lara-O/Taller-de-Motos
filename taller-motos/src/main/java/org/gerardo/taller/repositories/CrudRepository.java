package org.gerardo.taller.repositories;

import java.util.List;

public interface CrudRepository<T> {
    void guardar(T entidad);
    T buscarPorId(Integer id);
    List<T> listarTodos();
    void eliminar(Integer id);
}
