package co.com.sofkau.retoDDD.producion.taller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Direccion;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;
import co.com.sofkau.retoDDD.producion.taller.values.TallerId;


/**
 * Comando Crear Taller
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class CrearTaller extends Command {
    private final TallerId tallerId;
    private final Nombre nombre;
    private final Direccion direccion;
    private final Telefono telefono;

    public CrearTaller(TallerId tallerId, Nombre nombre, Direccion direccion, Telefono telefono) {
        this.tallerId = tallerId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public TallerId getTallerId() {
        return tallerId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
