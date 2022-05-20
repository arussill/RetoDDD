package co.com.sofkau.retoDDD.producion.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.fabrica.values.Cantidad;
import co.com.sofkau.retoDDD.producion.fabrica.values.Forma;
import co.com.sofkau.retoDDD.producion.fabrica.values.Tamano;
import co.com.sofkau.retoDDD.producion.fabrica.values.MoldeId;

public class MoldeCreado extends DomainEvent {
    private final MoldeId moldeId;
    private final Forma forma;
    private final Tamano tamano;
    private final Cantidad cantidad;

    public MoldeCreado(MoldeId moldeId, Forma forma, Tamano tamano, Cantidad cantidad) {
        super("co.com.sofkau.retoDDD.producion.MoldeCreado");
        this.moldeId = moldeId;
        this.forma = forma;
        this.tamano = tamano;
        this.cantidad = cantidad;
    }

    public MoldeId getMoldeId() {
        return moldeId;
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
