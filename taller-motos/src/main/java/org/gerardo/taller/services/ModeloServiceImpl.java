package org.gerardo.taller.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.gerardo.taller.models.Marca;
import org.gerardo.taller.models.Modelo;
import org.gerardo.taller.repositories.MarcaRepository;
import org.gerardo.taller.repositories.ModeloRepository;

import java.util.List;

@ApplicationScoped
public class ModeloServiceImpl implements ModeloService{

    @Inject
    private ModeloRepository modeloRepository;

    @Inject
    private MarcaRepository marcaRepository; // Orquestamos con Marca

    @Override
    public Modelo registrarModelo(String nombre, Integer marcaId) throws Exception {

        // Regla: Validar la existencia de la Marca
        Marca marcaAsociada = marcaRepository.buscarPorId(marcaId);
        if (marcaAsociada == null) {
            throw new Exception("Error: No se puede registrar el modelo porque la marca con ID " + marcaId + " no existe.");
        }

        Modelo nuevoModelo = new Modelo();
        nuevoModelo.setNombre(nombre);
        nuevoModelo.setMarca(marcaAsociada);

        modeloRepository.guardar(nuevoModelo);
        return nuevoModelo;
    }

    @Override
    public List<Modelo> listarTodos() {
        return modeloRepository.listarTodos();
    }

}
