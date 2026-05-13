package org.gerardo.taller.services;

import org.gerardo.taller.models.Modelo;

import java.util.List;

public interface ModeloService {
    Modelo registrarModelo(String nombre, Integer marcaId) throws Exception;
    List<Modelo> listarTodos();
}
