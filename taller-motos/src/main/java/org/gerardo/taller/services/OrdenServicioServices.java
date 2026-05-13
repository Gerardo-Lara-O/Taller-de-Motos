package org.gerardo.taller.services;

import org.gerardo.taller.models.DetalleOrden;
import org.gerardo.taller.models.OrdenServicio;

public interface OrdenServicioServices {

    OrdenServicio registrarEntradaTaller(Integer motocicletaId, String descripcionProblema) throws Exception;

    DetalleOrden agregarDetalleAOrden(Integer ordenId, Integer itemId, Integer cantidad) throws Exception;
}
