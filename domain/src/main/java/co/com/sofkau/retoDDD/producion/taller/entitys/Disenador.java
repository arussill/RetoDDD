package co.com.sofkau.retoDDD.producion.taller.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;
import co.com.sofkau.retoDDD.producion.taller.values.DisenadorId;


public class Disenador extends Entity<DisenadorId> {
    protected DisenadorId disenadorId;
    protected Nombre nombre;
    protected Telefono telefono;

    /**
     * Instantiates a new Entity.
     *
     * @param disenadorId the entity id
     * @param nombre
     * @param telefono
     */
    public Disenador(DisenadorId disenadorId, Nombre nombre, Telefono telefono) {
        super(disenadorId);
        this.disenadorId = disenadorId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void cambiarInformacion(DisenadorId disenadorId, Nombre nombre, Telefono telefono){
        this.disenadorId = DisenadorId.of(disenadorId.value());
        this.nombre = Nombre.of(nombre.value());
        this.telefono = Telefono.of(telefono.value());
    }
}
