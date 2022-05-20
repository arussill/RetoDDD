package co.com.sofkau.retoDDD.producion.coleccion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.values.Categoria;
import co.com.sofkau.retoDDD.producion.coleccion.values.Color;
import co.com.sofkau.retoDDD.producion.coleccion.values.ProductoId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Talla;

public class ProductoAgregado extends DomainEvent {
    private final ProductoId productoId;
    private final Nombre nombre;
    private final Color color;
    private final Talla talla;
    private final Categoria categoria;

    public ProductoAgregado(ProductoId productoId, Nombre nombre, Color color, Talla talla, Categoria categoria) {
        super("co.com.sofkau.retoDDD.producion.ProductoAgregado");
        this.productoId = productoId;
        this.nombre = nombre;
        this.color = color;
        this.talla = talla;
        this.categoria = categoria;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Color getColor() {
        return color;
    }

    public Talla getTalla() {
        return talla;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
