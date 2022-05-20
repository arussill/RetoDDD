package co.com.sofkau.retoDDD.producion.coleccion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.producion.coleccion.values.Categoria;
import co.com.sofkau.retoDDD.producion.coleccion.values.Color;
import co.com.sofkau.retoDDD.producion.coleccion.values.ProductoId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Talla;

/**
 * Comando Agregar producto
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */
public class AgregarProducto extends Command {

    private final ProductoId productoId;
    private final Talla talla;
    private final Color color;
    private final Categoria categoria;

    public AgregarProducto(ProductoId productoId, Talla talla, Color color, Categoria categoria) {
        this.productoId = productoId;
        this.talla = talla;
        this.color = color;
        this.categoria = categoria;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Talla getTalla() {
        return talla;
    }

    public Color getColor() {
        return color;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
