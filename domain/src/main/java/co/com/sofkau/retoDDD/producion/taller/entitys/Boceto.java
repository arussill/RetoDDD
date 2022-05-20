package co.com.sofkau.retoDDD.producion.taller.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.generic.values.Medidas;
import co.com.sofkau.retoDDD.producion.taller.values.BocetoId;
import co.com.sofkau.retoDDD.producion.taller.values.Descripcion;

public class Boceto extends Entity<BocetoId> {
    protected BocetoId bocetoId;
    protected Medidas medidas;
    protected Descripcion descripcion;

    /**
     * Instantiates a new Entity.
     *
     * @param bocetoId the entity id
     */
    public Boceto(BocetoId bocetoId, Medidas medidas, Descripcion descripcion) {
        super(bocetoId);
        this.bocetoId = bocetoId;
        this.medidas = medidas;
        this.descripcion = descripcion;
    }


}
