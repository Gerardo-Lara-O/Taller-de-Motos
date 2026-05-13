package org.gerardo.taller.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.gerardo.taller.models.ItemCatalogo;
import org.gerardo.taller.models.enums.TipoItem;
import org.gerardo.taller.repositories.ItemCatalogoRepository;

import java.util.List;

@ApplicationScoped
public class ItemCatalogoServiceImpl implements ItemCatalogoService{
    @Inject
    private ItemCatalogoRepository itemCatalogoRepository;

    @Override
    public ItemCatalogo registrarItem(String descripcion, String codigoSku, double precioBase, TipoItem tipo) throws Exception {

        // Regla: Prevención de errores de captura
        if (precioBase < 0) {
            throw new Exception("Error de negocio: El precio base de un artículo no puede ser menor a 0.");
        }

        ItemCatalogo nuevoItem = new ItemCatalogo();
        nuevoItem.setDescripcion(descripcion);
        nuevoItem.setCodigoSku(codigoSku);
        nuevoItem.setPrecioBase(precioBase);
        nuevoItem.setTipo(tipo);

        itemCatalogoRepository.guardar(nuevoItem);
        return nuevoItem;
    }

    @Override
    public List<ItemCatalogo> listarTodos() {
        return itemCatalogoRepository.listarTodos();
    }
}
