package org.gerardo.taller.services;

import org.gerardo.taller.models.Cliente;

public interface ClienteService {
    Cliente registrarCliente(String nombre, String apellido, String email, String telefono) throws Exception;
    Cliente buscarPorEmail(String email);
}
