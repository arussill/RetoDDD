package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import  co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.fabrica.values.MaquinariaId;
import generic.values.Tipo;

public class Maquinaria extends Entity<MaquinariaId> {
    private final MaquinariaId maquinariaId;
    private final Tipo tipo;

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
