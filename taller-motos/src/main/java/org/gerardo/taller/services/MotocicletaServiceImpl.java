package org.gerardo.taller.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.gerardo.taller.models.Cliente;
import org.gerardo.taller.models.Modelo;
import org.gerardo.taller.models.Motocicleta;
import org.gerardo.taller.repositories.ClienteRepository;
import org.gerardo.taller.repositories.ModeloRepository;
import org.gerardo.taller.repositories.MotocicletaRepository;

@ApplicationScoped
public class MotocicletaServiceImpl implements MotocicletaService{

    @Inject
    private MotocicletaRepository motocicletaRepository;

    // Fíjate cómo un Servicio puede inyectar Repositorios de otras entidades
    // para orquestar las validaciones.
    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    private ModeloRepository modeloRepository;


    @Override
    public Motocicleta registrarMoto(Integer clienteId, Integer modeloId, int year, String placa, String vin, int cilindrada) throws Exception {

        // 1. Validar que el dueño exista
        Cliente dueno = clienteRepository.buscarPorId(clienteId);
        if (dueno == null){
            throw new Exception("Error: El modelo con ID " + modeloId + " no está registrado en el catálogo.");
        }

        // 2. Validar que el modelo exista
        Modelo modeloMoto = modeloRepository.buscarPorId(modeloId);
        if (modeloMoto == null){
            throw new Exception("Error: El modelo con ID " + modeloId + " no está registrado en el catálogo.");
        }
        // 3. Construir el objeto
        Motocicleta nuevaMoto = new Motocicleta();
        nuevaMoto.setCliente(dueno);
        nuevaMoto.setModelo(modeloMoto);

        nuevaMoto.setYear(year);
        nuevaMoto.setPlaca(placa);
        nuevaMoto.setVin(vin);
        nuevaMoto.setCilindrada(cilindrada);

        motocicletaRepository.guardar(nuevaMoto);
        return nuevaMoto;
    }
}
