package org.gerardo.taller.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.gerardo.taller.models.Marca;
import org.gerardo.taller.repositories.MarcaRepository;

import java.util.List;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService{

    @Inject
    private MarcaRepository marcaRepository;

    @Override
    public Marca registrarMarca(String nombre) throws Exception {
        // Regla: Evitar duplicados. (Asumiendo que agregaste buscarPorNombre en tu repositorio)
        Marca existente = marcaRepository.buscarPorNombre(nombre);
        if (existente != null) {
            throw new Exception("Error: La marca '" + nombre + "' ya está registrada.");
        }

        Marca nuevaMarca = new Marca();
        nuevaMarca.setNombre(nombre);
        marcaRepository.guardar(nuevaMarca);
        return nuevaMarca;
    }

    @Override
    public Marca buscarPorId(Integer id) {
        return marcaRepository.buscarPorId(id);
    }

    @Override
    public List<Marca> listarTodas() {
        return marcaRepository.listarTodos();
    }
}
