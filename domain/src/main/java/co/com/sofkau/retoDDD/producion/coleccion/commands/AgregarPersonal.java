package co.com.sofkau.retoDDD.producion.coleccion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;
import co.com.sofkau.retoDDD.producion.coleccion.values.PersonalId;


/**
 * Comando Agregar personal
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class AgregarPersonal extends Command {
    private final PersonalId personalId;
    private final Nombre nombre;
    private final Telefono telefono;

    public AgregarPersonal(PersonalId personalId, Nombre nombre, Telefono telefono) {
        this.personalId = personalId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
