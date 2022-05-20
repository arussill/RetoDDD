package co.com.sofkau.retoDDD.producion.coleccion.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.values.Categoria;
import co.com.sofkau.retoDDD.producion.coleccion.values.Color;
import co.com.sofkau.retoDDD.producion.coleccion.values.ProductoId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Talla;

public class Producto extends Entity<ProductoId> {
    protected ProductoId productoId;
    protected Nombre nombre;
    protected Color color;
    protected Talla talla;
    protected Categoria categoria;

    /**
     * Instantiates a new Entity.
     *
     * @param productoId the entity id
     */
    public Producto(ProductoId productoId, Nombre nombre, Color color, Talla talla, Categoria categoria) {
        super(productoId);
        this.productoId = productoId;
        this.nombre = nombre;
        this.color = color;
        this.talla = talla;
        this.categoria = categoria;
    }
}
