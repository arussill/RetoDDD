package co.com.sofkau.retoDDD.producion.coleccion.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.coleccion.values.ProductoId;

public class Producto extends Entity<ProductoId> {
    /**
     * Instantiates a new Entity.
     *
     * @param entityId the entity id
     */
    public Producto(ProductoId entityId) {
        super(entityId);
    }
}
