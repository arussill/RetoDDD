package co.com.sofkau.retoDDD.producion.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
import co.com.sofkau.retoDDD.producion.fabrica.values.FabricaId;
import co.com.sofkau.retoDDD.producion.taller.values.TallerId;
import generic.values.Direccion;
import generic.values.Nombre;
import generic.values.Telefono;

/**
 * Comando Crear Fabrica
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */
public class CrearFabrica extends Command {
    private final FabricaId fabricaId;
    private final Nombre nombre;
    private final Direccion direccion;
    private final Telefono telefono;

    public CrearFabrica(FabricaId fabricaId, Nombre nombre, Direccion direccion, Telefono telefono) {
        this.fabricaId = fabricaId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
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
