package co.com.sofkau.retoDDD.producion.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.fabrica.values.Cantidad;
import co.com.sofkau.retoDDD.producion.fabrica.values.Forma;
import co.com.sofkau.retoDDD.producion.fabrica.values.MoldeId;
import generic.values.Medidas;

public class DetallesDelMoldeCambiados extends DomainEvent {
    private final MoldeId mentoriaId;
    private final Forma forma;
    private final Medidas medidas;
    private final Cantidad cantidad;

    public DetallesDelMoldeCambiados(MoldeId mentoriaId, Forma forma, Medidas medidas, Cantidad cantidad) {
        super("co.com.sofkau.retoDDD.producion.DetallesDeInsumoCambiados");
        this.mentoriaId = mentoriaId;
        this.forma = forma;
        this.medidas = medidas;
        this.cantidad = cantidad;
    }

    public MoldeId getMentoriaId() {
        return mentoriaId;
    }

    public Forma getForma() {
        return forma;
    }

    public Medidas getTamano() {
        return medidas;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
