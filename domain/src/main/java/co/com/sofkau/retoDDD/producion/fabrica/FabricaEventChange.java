package co.com.sofkau.retoDDD.producion.fabrica;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.retoDDD.producion.fabrica.events.FabricaCreada;

public class FabricaEventChange extends EventChange {
    public FabricaEventChange(Fabrica fabrica) {
        apply((FabricaCreada event)->{
            fabrica.nombre = event.getNombre();
            fabrica.direccion = event.getDireccion();
            fabrica.telefono = event.getTelefono();
        });
    }
}