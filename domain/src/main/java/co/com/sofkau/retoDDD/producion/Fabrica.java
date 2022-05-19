package co.com.sofkau.retoDDD.producion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkau.retoDDD.producion.entitys.Insumo;
import co.com.sofkau.retoDDD.producion.entitys.Maquinaria;
import co.com.sofkau.retoDDD.producion.entitys.Molde;
import co.com.sofkau.retoDDD.producion.events.FabricaCreada;
import co.com.sofkau.retoDDD.producion.values.*;

import java.util.Set;

public class Fabrica extends AggregateEvent<FabricaId> {

    protected Nombre nombre;
    protected Direccion direccion;
    protected Telefono telefono;
    protected Maquinaria maquinaria;
    protected Insumo insumo;
    protected Set<Molde> listaDeMoldes;
    protected ColeccionId coleccionId;
    protected TallerId tallerId;
    /**
     * Constructor del Agregado Fabrica.
     *
     * @param entityId the entity id
     */
    public Fabrica(FabricaId entityId, Nombre nombre, Direccion direccion, Telefono telefono) {
        super(entityId);
        appendChange(new FabricaCreada(nombre, direccion, telefono)).apply();
        subscribe(new FabricaEventChange(this));
    }
}



