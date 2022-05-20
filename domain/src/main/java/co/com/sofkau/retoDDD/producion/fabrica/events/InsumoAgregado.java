package co.com.sofkau.retoDDD.producion.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.fabrica.values.InsumoId;
import generic.values.Tipo;

public class InsumoAgregado extends DomainEvent {
    private final InsumoId insumoId;
    private final Tipo tipo;

    public InsumoAgregado(InsumoId insumoId, Tipo tipo) {
        super("co.com.sofkau.retoDDD.producion.fabrica.InsumoAgregado");
        this.insumoId = insumoId;
        this.tipo = tipo;
    }

    public InsumoId getInsumoId() {
        return insumoId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
