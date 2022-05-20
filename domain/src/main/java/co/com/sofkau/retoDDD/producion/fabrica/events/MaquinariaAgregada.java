package co.com.sofkau.retoDDD.producion.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.fabrica.entitys.Maquinaria;
import co.com.sofkau.retoDDD.producion.fabrica.values.MaquinariaId;
import co.com.sofkau.retoDDD.producion.fabrica.values.Tipo;

public class MaquinariaAgregada extends DomainEvent {

    private final MaquinariaId maquinariaId;
    private final Tipo tipo;

    public MaquinariaAgregada(MaquinariaId maquinariaId, Tipo tipo) {
        super("co.com.sofkau.retoDDD.producion.MaquinariAgregada");
        this.maquinariaId = maquinariaId;
        this.tipo = tipo;
    }

    public MaquinariaId getMaquinariaId() {
        return maquinariaId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
