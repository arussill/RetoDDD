package co.com.sofkau.retoDDD.producion.taller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.taller.values.BocetoId;
import co.com.sofkau.retoDDD.producion.taller.values.Descripcion;
import generic.values.Medidas;

public class BocetoCreado extends DomainEvent {
    private final BocetoId bocetoId;
    private final Medidas medidas;
    private final Descripcion descripcion;

    public BocetoCreado(BocetoId bocetoId, Medidas medidas, Descripcion descripcion) {
        super("co.com.sofkau.retoDDD.producion.BocetoCreado");
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
