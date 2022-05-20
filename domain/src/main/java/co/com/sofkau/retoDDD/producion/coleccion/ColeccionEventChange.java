package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Personal;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Prueba;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.coleccion.events.PersonalAgregado;
import co.com.sofkau.retoDDD.producion.coleccion.events.PruebaRealizada;

public class ColeccionEventChange extends EventChange {
    public ColeccionEventChange(Coleccion coleccion) {
    apply((ColeccionCreada event) ->{
        coleccion.nombre = event.getNombre();
        coleccion.fecha = event.getFecha();
        coleccion.prueba = null;
        coleccion.personal = null;
        coleccion.producto = null;
    });

    apply((PruebaRealizada event) ->{
        var pruebaId = event.getPruebaId();
        coleccion.prueba = new Prueba(pruebaId, event.getFecha(), event.getResultado());
    });

    apply((PersonalAgregado event)->{
        var personalId = event.getPersonalId();
        coleccion.personal=new Personal(personalId, event.getNombre(),event.getTelefono());
    });

    }
}
