package co.com.sofkau.retoDDD.producion.coleccion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;


/**
 * Comando Crear Coleccion
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class CrearColeccion extends Command {

    private final ColeccionId coleccionId;
    private final Nombre nombre;
    private final Fecha fecha;


    public CrearColeccion(ColeccionId coleccionId, Nombre nombre, Fecha fecha) {
        this.coleccionId = coleccionId;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public ColeccionId getColeccionId() {
        return coleccionId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
