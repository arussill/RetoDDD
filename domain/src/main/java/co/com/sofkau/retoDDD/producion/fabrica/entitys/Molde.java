package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.fabrica.values.Cantidad;
import co.com.sofkau.retoDDD.producion.fabrica.values.Forma;
import co.com.sofkau.retoDDD.producion.fabrica.values.MoldeId;
import co.com.sofkau.retoDDD.producion.fabrica.values.Tamano;

public class Molde extends Entity<MoldeId> {

    private MoldeId moldeId;
    private Forma forma;
    private Tamano tamano;
    private Cantidad cantidad;

    /**
     * Instantiates a new Entity.
     *
     * @param moldeId the entity id
     * @param forma
     * @param tamano
     * @param cantidad
     */
    public Molde(MoldeId moldeId, Forma forma, Tamano tamano, Cantidad cantidad) {
        super(moldeId);
        this.moldeId = moldeId;
        this.forma = forma;
        this.tamano = tamano;
        this.cantidad = cantidad;
    }

    public void cambiarDetalles(MoldeId moldeId, Forma forma, Tamano tamano, Cantidad cantidad){
        if(moldeId == this.moldeId){
            this.moldeId = moldeId;
            this.forma = forma;
            this.tamano = tamano;
            this.cantidad = cantidad;
        }
    }
}
