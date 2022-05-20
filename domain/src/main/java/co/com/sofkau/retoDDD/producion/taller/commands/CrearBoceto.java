package co.com.sofkau.retoDDD.producion.taller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.producion.taller.values.BocetoId;
import co.com.sofkau.retoDDD.producion.taller.values.Descripcion;
import generic.values.Medidas;

/**
 * Comando Crear Boceto
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class CrearBoceto extends Command {
    private final BocetoId bocetoId;
    private final Medidas medidas;
    private final Descripcion descripcion;

    public CrearBoceto(BocetoId bocetoId, Medidas medidas, Descripcion descripcion) {
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
}
