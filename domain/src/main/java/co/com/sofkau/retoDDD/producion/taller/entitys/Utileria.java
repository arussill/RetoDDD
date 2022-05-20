package co.com.sofkau.retoDDD.producion.taller.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.taller.values.UtileriaId;
import generic.values.Nombre;

public class Utileria extends Entity<UtileriaId> {
    protected UtileriaId utileriaId;
    protected Nombre nombre;

    /**
     * Instantiates a new Entity.
     *
     * @param utileriaId the entity id
     * @param nombre
     */
    public Utileria(UtileriaId utileriaId, Nombre nombre) {
        super(utileriaId);
        this.utileriaId = utileriaId;
        this.nombre = nombre;
    }
}
