package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.fabrica.values.Cantidad;
import co.com.sofkau.retoDDD.producion.fabrica.values.Forma;
import co.com.sofkau.retoDDD.producion.fabrica.values.MoldeId;
import co.com.sofkau.retoDDD.producion.fabrica.values.Tamano;

public class Molde extends Entity<MoldeId> {

    private Forma forma;
    private Tamano tamano;
    private Cantidad cantidad;

    /**
     * Instantiates a new Entity.
     *
     * @param entityId the entity id
     * @param forma
     * @param tamano
     * @param cantidad
     */
    public Molde(MoldeId entityId, Forma forma, Tamano tamano, Cantidad cantidad) {
        super(entityId);
        this.forma = forma;
        this.tamano = tamano;
        this.cantidad = cantidad;
    }

    public void cambiarDetalles(MoldeId entityId, Forma forma, Tamano tamano, Cantidad cantidad){
        //Validaciones
        var molde = new Molde(entityId, forma, tamano, cantidad);
    }
}
