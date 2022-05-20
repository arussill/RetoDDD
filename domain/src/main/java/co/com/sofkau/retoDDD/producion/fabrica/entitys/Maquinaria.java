package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import  co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.generic.values.Tipo;
import co.com.sofkau.retoDDD.producion.fabrica.values.MaquinariaId;

public class Maquinaria extends Entity<MaquinariaId> {
    protected MaquinariaId maquinariaId;
    protected Tipo tipo;

    /**
     * Instantiates a new Entity.
     *
     * @param maquinariaId the entity id
     * @param tipo
     */
    public Maquinaria(MaquinariaId maquinariaId, Tipo tipo) {
        super(maquinariaId);
        this.maquinariaId = maquinariaId;
        this.tipo = tipo;
    }
}
