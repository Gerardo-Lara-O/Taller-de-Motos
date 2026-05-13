package org.gerardo.taller.services;

import org.gerardo.taller.models.ItemCatalogo;
import org.gerardo.taller.models.enums.TipoItem;

import java.util.List;

public interface ItemCatalogoService {
    ItemCatalogo registrarItem(String descripcion, String codigoSku, double precioBase, TipoItem tipo) throws Exception;
    List<ItemCatalogo> listarTodos();
}
