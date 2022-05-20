package co.com.sofkau.retoDDD.producion.coleccion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.coleccion.values.Categoria;
import co.com.sofkau.retoDDD.producion.coleccion.values.Color;
import co.com.sofkau.retoDDD.producion.coleccion.values.ProductoId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Talla;
import generic.values.Nombre;

public class ProductoAgregado extends DomainEvent {
    private final Color color;
    private final Talla talla;
    private final Categoria categoria;

    public ProductoAgregado(ProductoId porductoId, Nombre nombre, Color color, Talla talla, Categoria categoria) {
        super("co.com.sofkau.retoDDD.producion.ProductoAgregado");
        this.color = color;
        this.talla = talla;
        this.categoria = categoria;
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
