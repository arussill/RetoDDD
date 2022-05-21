package co.com.sofkau.retoDDD.producion.taller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Medidas;
import co.com.sofkau.retoDDD.producion.taller.values.BocetoId;
import co.com.sofkau.retoDDD.producion.taller.values.Descripcion;
import co.com.sofkau.retoDDD.producion.taller.values.TallerId;

/**
 * Comando Crear Boceto
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class CrearBoceto extends Command {
    private final TallerId tallerId;
    private final BocetoId bocetoId;
    private final Medidas medidas;
    private final Descripcion descripcion;

    public CrearBoceto(TallerId tallerId, BocetoId bocetoId, Medidas medidas, Descripcion descripcion) {
        this.tallerId = tallerId;
        this.bocetoId = bocetoId;
        this.medidas = medidas;
        this.descripcion = descripcion;
    }

    public BocetoId getBocetoId() {
        return bocetoId;
    }

    public Medidas getMedidas() {
        return medidas;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public TallerId getTallerId() {
        return tallerId;
    }
}
