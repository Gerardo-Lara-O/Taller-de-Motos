package org.gerardo.taller.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.gerardo.taller.models.Cliente;
import org.gerardo.taller.repositories.ClienteRepository;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService{

    @Inject
    private ClienteRepository clienteRepository;


    @Override
    public Cliente registrarCliente(String nombre, String apellido, String email, String telefono) throws Exception {
        // Regla de Negocio: Validar que el email no exista previamente
        Cliente clienteExistente = clienteRepository.buscarPorEmail(email);
        if (clienteExistente != null){
            throw new Exception("Regla de negocio fallida: El correo " + email + " ya está registrado.");
        }

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setApellidos(apellido);
        nuevoCliente.setEmail(email);
        nuevoCliente.setNumeroTelefonico(telefono);

        clienteRepository.guardar(nuevoCliente);
        return nuevoCliente;
    }

    @Override
    public Cliente buscarPorEmail(String email) {
        return clienteRepository.buscarPorEmail(email);
    }
}
