package co.com.sofkau.retoDDD.producion.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.fabrica.values.Cantidad;
import co.com.sofkau.retoDDD.producion.fabrica.values.Forma;
import co.com.sofkau.retoDDD.producion.fabrica.values.MoldeId;
import co.com.sofkau.retoDDD.producion.fabrica.values.Tamano;

public class DetallesDelMoldeCambiados extends DomainEvent {
    private final MoldeId mentoriaId;
    private final Forma forma;
    private final Tamano tamano;
    private final Cantidad cantidad;

    public DetallesDelMoldeCambiados(MoldeId mentoriaId, Forma forma, Tamano tamano, Cantidad cantidad) {
        super("co.com.sofkau.retoDDD.producion.fabrica.DetallesDeInsumoCambiados");
        this.mentoriaId = mentoriaId;
        this.forma = forma;
        this.tamano = tamano;
        this.cantidad = cantidad;
    }

    public MoldeId getMentoriaId() {
        return mentoriaId;
    }

    public Forma getForma() {
        return forma;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
