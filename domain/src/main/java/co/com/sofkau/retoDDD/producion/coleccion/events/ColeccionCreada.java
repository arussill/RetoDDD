package co.com.sofkau.retoDDD.producion.coleccion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Nombre;


public class ColeccionCreada extends DomainEvent {

    private final Nombre nombre;
    private final Fecha fecha;

    public ColeccionCreada(Nombre nombre, Fecha fecha) {
        super("co.com.sofkau.retoDDD.producion.ColeccionCreada");
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
