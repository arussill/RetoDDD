package co.com.sofkau.retoDDD.producion.fabrica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
import co.com.sofkau.retoDDD.producion.fabrica.entitys.*;
import co.com.sofkau.retoDDD.producion.fabrica.events.FabricaCreada;
import co.com.sofkau.retoDDD.producion.fabrica.events.MoldeCreado;
import co.com.sofkau.retoDDD.producion.fabrica.values.*;
import co.com.sofkau.retoDDD.producion.taller.values.TallerId;
import generic.values.Direccion;
import generic.values.Nombre;
import generic.values.Telefono;

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

    public void agregarMolde(Forma forma, Tamano tamano, Cantidad cantidad){
        var moldeId = new MoldeId();
        appendChange(new MoldeCreado(moldeId, forma, tamano, cantidad)).apply();

    }
}



