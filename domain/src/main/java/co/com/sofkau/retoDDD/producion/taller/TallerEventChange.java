package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.retoDDD.producion.taller.entitys.Boceto;
import co.com.sofkau.retoDDD.producion.taller.entitys.Disenador;
import co.com.sofkau.retoDDD.producion.taller.entitys.Utileria;
import co.com.sofkau.retoDDD.producion.taller.events.*;

public class TallerEventChange extends EventChange {
    public TallerEventChange(Taller taller) {
        apply((TallerCreado event) -> {
            taller.nombre = event.getNombre();
            taller.direccion = event.getDireccion();
            taller.telefono = event.getTelefono();
            taller.disenador = null;
            taller.boceto = null;
            taller.utileria = null;
        });

        apply((DisenadorAgregado event)->{
            var disenadorId = event.getDisenadorId();
            taller.disenador = new Disenador(disenadorId, event.getNombre(), event.getTelefono());
        });

        apply((UtileriaAgregada event)->{
            var utileriaId = event.getUtileriaId();
            taller.utileria = new Utileria(utileriaId, event.getNombre());
        });

        apply((BocetoCreado event)->{
            var bocetoId = event.getBocetoId();
            taller.boceto = new Boceto(bocetoId, event.getMedidas(), event.getDescripcion());
        });

        apply((InformacionDelDisenadorCambiada event) -> {
            var disenadorId = event.getDisenadorId();
            var nombre = event.getNombre();
            var telefono = event.getTelefono();
            taller.disenador.cambiarInformacion(disenadorId, nombre, telefono);
        });


    }
}
