package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.domain.generic.AggregateEvent;
import generic.values.Direccion;
import generic.values.Nombre;
import generic.values.Telefono;

public class Taller extends AggregateEvent<TallerId> {

    protected Nombre nombre;
    protected Direccion direccion;
    protected Telefono telefono;

    /**
     * Instantiates a new Aggregate event.
     *
     * @param entityId the entity id
     */
    public Taller(TallerId entityId, Nombre nombre, Direccion direccion, Telefono telefono) {
        super(entityId);
        appendChange(new TallerCreado(nombre, direccion, telefono)).apply();
    }
}
