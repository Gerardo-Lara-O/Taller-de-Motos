package org.gerardo.taller.services;

import jakarta.inject.Inject;
import org.gerardo.taller.models.DetalleOrden;
import org.gerardo.taller.models.ItemCatalogo;
import org.gerardo.taller.models.Motocicleta;
import org.gerardo.taller.models.OrdenServicio;
import org.gerardo.taller.models.enums.StatusOrden;
import org.gerardo.taller.repositories.DetalleOrdenRepository;
import org.gerardo.taller.repositories.ItemCatalogoRepository;
import org.gerardo.taller.repositories.MotocicletaRepository;
import org.gerardo.taller.repositories.OrdenServicioRepository;

public class OrdenServicioServiceImpl implements OrdenServicioServices{

    // Inyectamos los repositorios que necesitamos usar
    @Inject
    private MotocicletaRepository motocicletaRepository;

    @Inject
    private OrdenServicioRepository ordenServicioRepository;

    @Inject
    private ItemCatalogoRepository itemCatalogoRepository;

    @Inject
    private DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public OrdenServicio registrarEntradaTaller(Integer motocicletaId, String descripcionProblema) throws Exception {
        // 1. Validar regla de negocio: ¿La moto existe?
        Motocicleta moto = motocicletaRepository.buscarPorId(motocicletaId);
        if (moto == null){
            throw new Exception("Error: No se encontro la motocicleta con ID " + motocicletaId);
        }
        // 2. Aplicar lógica de negocio: Construir la orden
        OrdenServicio nuevaOrden = new OrdenServicio();
        nuevaOrden.setMotocicleta(moto);
        nuevaOrden.setDescripcionProblema(descripcionProblema);
        nuevaOrden.setStatus(StatusOrden.OPEN); // Regla: Toda orden nueva entra como OPEN
        nuevaOrden.setTotal(0.0); // Regla: El total inicial es 0 hasta que se agreguen detalles

        // 3. Persistir en la base de datos
        ordenServicioRepository.guardar(nuevaOrden);
        return nuevaOrden;
    }

    @Override
    public DetalleOrden agregarDetalleAOrden(Integer ordenId, Integer itemId, Integer cantidad) throws Exception {

        // 1. Validar la orden de servicio
        OrdenServicio orden = ordenServicioRepository.buscarPorId(ordenId);
        if (orden == null) {
            throw new Exception("Error: La orden de servicio no existe.");
        }

        // Regla de negocio: No puedes cobrarle más piezas a una moto que ya se entregó
        if (orden.getStatus() == StatusOrden.CLOSED) {
            throw new Exception("Error: La orden ya está cerrada, no se pueden agregar más detalles.");
        }

        // 2. Validar el artículo del catálogo
        ItemCatalogo item = itemCatalogoRepository.buscarPorId(itemId);
        if (item == null) {
            throw new Exception("Error: El artículo no existe en el catálogo.");
        }

        // 3. Crear el nuevo renglón (Detalle)
        DetalleOrden detalle = new DetalleOrden();
        detalle.setOrdenServicio(orden);
        detalle.setItemCatalogo(item);
        detalle.setCantidad(cantidad);

        // REGLA DE NEGOCIO VITAL (Precio Histórico):
        // Copiamos el precio actual del catálogo y lo congelamos en el detalle.
        // Así, si mañana la bujía sube de precio en el catálogo, no le alteras
        // la factura de ayer a este cliente.
        detalle.setPrecioHistorico(item.getPrecioBase());

        // 4. Actualizar el total de la cabecera (Orden)
        double subtotal = item.getPrecioBase() * cantidad;
        orden.setTotal(orden.getTotal() + subtotal);

        // 5. Persistir los cambios
        detalleOrdenRepository.guardar(detalle);   // Guardamos el renglón nuevo
        ordenServicioRepository.guardar(orden);    // Actualizamos el total general

        return detalle;
    }


}
