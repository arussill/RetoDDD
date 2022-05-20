package co.com.sofkau.retoDDD.producion.taller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;
import co.com.sofkau.retoDDD.producion.taller.values.DisenadorId;


/**
 * Comando Agregar Diseñador
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class AgregarDisenador extends Command {
    private final DisenadorId disenadorId;
    private final Nombre nombre;
    private final Telefono telefono;

    public AgregarDisenador(DisenadorId disenadorId, Nombre nombre, Telefono telefono) {
        this.disenadorId = disenadorId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public DisenadorId getDisenadorId() {
        return disenadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
