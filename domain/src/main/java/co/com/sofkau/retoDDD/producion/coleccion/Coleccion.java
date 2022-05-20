package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Personal;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Producto;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Prueba;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.coleccion.events.PruebaRealizada;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
import co.com.sofkau.retoDDD.producion.coleccion.values.PruebaId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Resultado;
import co.com.sofkau.retoDDD.producion.fabrica.Fabrica;
import co.com.sofkau.retoDDD.producion.fabrica.FabricaEventChange;
import co.com.sofkau.retoDDD.producion.fabrica.values.FabricaId;
import generic.values.Fecha;
import generic.values.Nombre;

import java.util.List;

public class Coleccion extends AggregateEvent<ColeccionId> {

    protected Nombre nombre;
    protected Fecha fecha;
    protected Prueba prueba;
    protected Personal personal;
    protected Producto producto;

    /**
     * Constructor del Agregado Colección.
     *
     * @param entityId the entity id
     */
    public Coleccion(ColeccionId entityId, Nombre nombre, Fecha fecha) {
        super(entityId);
        appendChange(new ColeccionCreada(nombre, fecha)).apply();
        subscribe(new ColeccionEventChange(this));
    }

    private Coleccion(ColeccionId coleccionId){
        super(coleccionId);
        subscribe(new ColeccionEventChange(this));
    }

    public static Coleccion from(ColeccionId coleccionId, List<DomainEvent> events){
        var coleccion = new Coleccion(coleccionId);
        events.forEach(coleccion::applyEvent);
        return coleccion;
    }

    //Comportamientos

    public void realizarPrueba(Fecha fecha, Resultado resultado){
        var pruebaId = new PruebaId();
        appendChange(new PruebaRealizada(pruebaId, fecha, resultado)).apply();
    }
}
