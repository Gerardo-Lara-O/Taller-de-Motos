package org.gerardo.taller.services;

import org.gerardo.taller.models.Marca;

import java.util.List;

public interface MarcaService {
    Marca registrarMarca(String nombre) throws Exception;
    Marca buscarPorId(Integer id);
    List<Marca> listarTodas();
}
