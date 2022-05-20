package co.com.sofkau.retoDDD.producion.fabrica;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.retoDDD.producion.fabrica.entitys.Insumo;
import co.com.sofkau.retoDDD.producion.fabrica.entitys.Maquinaria;
import co.com.sofkau.retoDDD.producion.fabrica.entitys.Molde;
import co.com.sofkau.retoDDD.producion.fabrica.events.*;

import java.util.HashSet;

public class FabricaEventChange extends EventChange {
    public FabricaEventChange(Fabrica fabrica) {
        apply((FabricaCreada event)->{
            fabrica.nombre = event.getNombre();
            fabrica.direccion = event.getDireccion();
            fabrica.telefono = event.getTelefono();
            fabrica.maquinaria = null;
            fabrica.insumo = null;

        });

        apply((MoldeCreado event)->{
            var moldeId = event.getMoldeId();
            var molde = new Molde(moldeId, event.getForma(), event.getTamano(), event.getCantidad());
            fabrica.listaDeMoldes.add(molde);
        });

        apply((MaquinariaAgregada event) -> {
            var maquinariaId = event.getMaquinariaId();
            fabrica.maquinaria= new Maquinaria(maquinariaId, event.getTipo());
        });

        apply((InsumoAgregado event)->{
            var insumoId = event.getInsumoId();
            fabrica.insumo= new Insumo(insumoId, event.getTipo());
        });

        apply((DetallesDelMoldeCambiados event)->{
            var moldeId = event.getMentoriaId();
            var forma = event.getForma();
            var tamano = event.getTamano();
            var cantidad = event.getCantidad();
            fabrica.listaDeMoldes.forEach(molde->{
                molde.cambiarDetalles(moldeId, forma, tamano, cantidad);
            });
        });
    }
}
