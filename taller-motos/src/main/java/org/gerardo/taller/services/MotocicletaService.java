package org.gerardo.taller.services;

import org.gerardo.taller.models.Motocicleta;

public interface MotocicletaService {
    Motocicleta registrarMoto(Integer clienteId, Integer modeloId,int year, String placa, String vin, int cilindrada) throws Exception;

}
