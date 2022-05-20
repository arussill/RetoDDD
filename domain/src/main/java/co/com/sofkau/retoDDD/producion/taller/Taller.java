package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkau.retoDDD.producion.generic.values.Direccion;
import co.com.sofkau.retoDDD.producion.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.generic.values.Telefono;

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
