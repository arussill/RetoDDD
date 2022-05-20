package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.fabrica.Fabrica;
import co.com.sofkau.retoDDD.producion.fabrica.FabricaEventChange;
import co.com.sofkau.retoDDD.producion.fabrica.values.FabricaId;
import co.com.sofkau.retoDDD.producion.taller.entitys.Boceto;
import co.com.sofkau.retoDDD.producion.taller.entitys.Disenador;
import co.com.sofkau.retoDDD.producion.taller.entitys.Utileria;
import co.com.sofkau.retoDDD.producion.taller.events.*;
import co.com.sofkau.retoDDD.producion.taller.values.*;
import generic.values.Direccion;
import generic.values.Medidas;
import generic.values.Nombre;
import generic.values.Telefono;

import java.util.List;

public class Taller extends AggregateEvent<TallerId> {

    protected Nombre nombre;
    protected Direccion direccion;
    protected Telefono telefono;
    protected Disenador disenador;
    protected Boceto boceto;
    protected Utileria utileria;

    /**
     * Instantiates a new Aggregate event.
     *
     * @param tallerId the entity id
     */
    public Taller(TallerId tallerId, Nombre nombre, Direccion direccion, Telefono telefono) {
        super(tallerId);
        appendChange(new TallerCreado(nombre, direccion, telefono)).apply();
        subscribe(new TallerEventChange(this));
    }

    private Taller(TallerId tallerId){
        super(tallerId);
        subscribe(new TallerEventChange(this));
    }

    public static Taller from(TallerId tallerId, List<DomainEvent> events){
        var taller = new Taller(tallerId);
        events.forEach(taller::applyEvent);
        return taller;
    }
    //Comportamientos

    public void agregarDisenador(Nombre nombre, Telefono telefono) {
        var disenadorId = new DisenadorId();
       appendChange(new DisenadorAgregado(disenadorId, nombre, telefono)).apply();
    }

    public void agregarUtileria(Nombre nombre){
        var utileriaId = new UtileriaId();
        appendChange(new UtileriaAgregada(utileriaId, nombre)).apply();
    }

    public void crearBoceto(Medidas medidas, Descripcion descripcion) {
    var bocetoId = new BocetoId();
    appendChange(new BocetoCreado(bocetoId, medidas, descripcion)).apply();
    }

    public void cambiarInformacionDelDisenador(DisenadorId disenadorId, Nombre nombre, Telefono telefono) {
        appendChange(new InformacionDelDisenadorCambiada(disenadorId, nombre, telefono)).apply();
    }

    //Propiedades

    public Nombre nombre() {
        return nombre;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Telefono telefono() {
        return telefono;
    }
}
