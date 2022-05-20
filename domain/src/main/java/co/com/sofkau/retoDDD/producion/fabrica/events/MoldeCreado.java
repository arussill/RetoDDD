package co.com.sofkau.retoDDD.producion.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Medidas;
import co.com.sofkau.retoDDD.producion.fabrica.values.Cantidad;
import co.com.sofkau.retoDDD.producion.fabrica.values.Forma;
import co.com.sofkau.retoDDD.producion.fabrica.values.MoldeId;

public class MoldeCreado extends DomainEvent {
    private final MoldeId moldeId;
    private final Forma forma;
    private final Medidas medidas;
    private final Cantidad cantidad;

    public MoldeCreado(MoldeId moldeId, Forma forma, Medidas medidas, Cantidad cantidad) {
        super("co.com.sofkau.retoDDD.producion.MoldeCreado");
        this.moldeId = moldeId;
        this.forma = forma;
        this.medidas = medidas;
        this.cantidad = cantidad;
    }

    public MoldeId getMoldeId() {
        return moldeId;
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
