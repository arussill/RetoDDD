package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.retoDDD.producion.taller.events.TallerCreado;

public class TallerEventChange extends EventChange {
    public TallerEventChange(Taller taller) {
        apply((TallerCreado event) -> {
            taller.nombre = event.getNombre();
            taller.direccion = event.getDireccion();
            taller.telefono = event.getTelefono();
        });
    }
}
