package co.com.sofkau.retoDDD.producion.coleccion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.values.*;

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
    private final Nombre nombre;
    private final ColeccionId coleccionId;

    public AgregarProducto(ProductoId productoId, Talla talla, Color color, Categoria categoria, Nombre nombre, ColeccionId coleccionId) {
        this.productoId = productoId;
        this.talla = talla;
        this.color = color;
        this.categoria = categoria;
        this.nombre = nombre;
        this.coleccionId = coleccionId;
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

    public Nombre getNombre() {
        return nombre;
    }

    public ColeccionId getColeccionId() {
        return coleccionId;
    }
}
