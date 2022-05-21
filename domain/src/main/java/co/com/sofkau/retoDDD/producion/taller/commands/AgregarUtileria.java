package co.com.sofkau.retoDDD.producion.taller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.taller.values.TallerId;
import co.com.sofkau.retoDDD.producion.taller.values.UtileriaId;

/**
 * Comando Agregar Utileria
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class AgregarUtileria extends Command {
    private final TallerId tallerId;
    private final UtileriaId utileriaId;
    private final Nombre nombre;

    public AgregarUtileria(TallerId tallerId, UtileriaId utileriaId, Nombre nombre) {
        this.tallerId = tallerId;
        this.utileriaId = utileriaId;
        this.nombre = nombre;
    }

    public UtileriaId getUtileriaId() {
        return utileriaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public TallerId getTallerId() {
        return tallerId;
    }
}
