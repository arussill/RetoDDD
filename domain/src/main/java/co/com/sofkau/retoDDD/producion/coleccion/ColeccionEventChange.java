package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;

public class ColeccionEventChange extends EventChange {
    public ColeccionEventChange(Coleccion coleccion) {
    apply((ColeccionCreada event) ->{
        coleccion.nombre = event.getNombre();
        coleccion.fecha = event.getFecha();
    });
    }
}
