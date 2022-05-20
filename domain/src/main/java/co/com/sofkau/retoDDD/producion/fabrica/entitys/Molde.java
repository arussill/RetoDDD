package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.fabrica.values.Cantidad;
import co.com.sofkau.retoDDD.producion.fabrica.values.Forma;
import co.com.sofkau.retoDDD.producion.fabrica.values.MoldeId;
import generic.values.Medidas;

public class Molde extends Entity<MoldeId> {

    protected MoldeId moldeId;
    protected Forma forma;
    protected Medidas medidas;
    protected Cantidad cantidad;

    /**
     * Instantiates a new Entity.
     *
     * @param moldeId the entity id
     * @param forma
     * @param medidas
     * @param cantidad
     */
    public Molde(MoldeId moldeId, Forma forma, Medidas medidas, Cantidad cantidad) {
        super(moldeId);
        this.moldeId = moldeId;
        this.forma = forma;
        this.medidas = medidas;
        this.cantidad = cantidad;
    }

    public void cambiarDetalles(MoldeId moldeId, Forma forma, Medidas medidas, Cantidad cantidad){
        if(moldeId == this.moldeId){
            this.moldeId = moldeId;
            this.forma = forma;
            this.medidas = medidas;
            this.cantidad = cantidad;
        }
    }
}
