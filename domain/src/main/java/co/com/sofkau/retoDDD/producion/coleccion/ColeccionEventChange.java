package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Personal;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Prueba;
import co.com.sofkau.retoDDD.producion.coleccion.events.*;
import co.com.sofkau.retoDDD.producion.coleccion.values.EstadoDeColeccion;

public class ColeccionEventChange extends EventChange {
    public ColeccionEventChange(Coleccion coleccion) {
        apply((ColeccionCreada event) -> {
            coleccion.nombre = event.getNombre();
            coleccion.fecha = event.getFecha();
            coleccion.estadoDeColeccion = new EstadoDeColeccion(EstadoDeColeccion.Estados.EN_PROCESO);
        });

        apply((PruebaRealizada event) -> {
            var pruebaId = event.getPruebaId();
            coleccion.prueba = new Prueba(pruebaId, event.getFecha(), event.getResultado());
        });

        apply((PersonalAgregado event) -> {
            var personalId = event.getPersonalId();
            coleccion.personal = new Personal(personalId, event.getNombre(), event.getTelefono());
        });

        apply((PersonalCambiado event) -> {
            var nommbre = event.getNombre();
            var telefono = event.getTelefono();
            coleccion.personal = new Personal(nommbre,telefono);
        });

        apply((ColeccionFinalizada event) -> {
            coleccion.estadoDeColeccion = new EstadoDeColeccion(EstadoDeColeccion.Estados.FINALIZADO);
        });

        apply((ColeccionCambiada event)->{
            coleccion.estadoDeColeccion = new EstadoDeColeccion(EstadoDeColeccion.Estados.FINALIZADO);
        });
    }
}
