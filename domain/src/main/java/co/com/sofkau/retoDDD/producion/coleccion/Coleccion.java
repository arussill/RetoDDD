package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Personal;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Prueba;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
import generic.values.Fecha;
import generic.values.Nombre;

public class Coleccion extends AggregateEvent<ColeccionId> {

    protected Nombre nombre;
    protected Fecha fecha;
    protected Prueba prueba;
    protected Personal personal;

    /**
     * Instantiates a new Aggregate event.
     *
     * @param entityId the entity id
     */
    public Coleccion(ColeccionId entityId, Nombre nombre, Fecha fecha) {
        super(entityId);
        appendChange(new ColeccionCreada(nombre, fecha)).apply();
        subscribe(new ColeccionEventChange(this));
    }
}
