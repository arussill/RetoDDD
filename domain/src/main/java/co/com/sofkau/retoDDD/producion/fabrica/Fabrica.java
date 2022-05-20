package co.com.sofkau.retoDDD.producion.fabrica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.*;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
import co.com.sofkau.retoDDD.producion.fabrica.entitys.*;
import co.com.sofkau.retoDDD.producion.fabrica.events.*;
import co.com.sofkau.retoDDD.producion.fabrica.values.*;
import co.com.sofkau.retoDDD.producion.taller.values.TallerId;


import java.util.List;
import java.util.Set;

public class Fabrica extends AggregateEvent<FabricaId> {

    protected Nombre nombre;
    protected Direccion direccion;
    protected Telefono telefono;
    protected Maquinaria maquinaria;
    protected Insumo insumo;
    protected Set<Molde> listaDeMoldes;
    protected ColeccionId coleccionId;
    protected TallerId tallerId;

    /**
     * Constructor del Agregado Fabrica.
     *
     * @param fabricaId the entity id
     */
    public Fabrica(FabricaId fabricaId, Nombre nombre, Direccion direccion, Telefono telefono) {
        super(fabricaId);
        appendChange(new FabricaCreada(nombre, direccion, telefono)).apply();
        subscribe(new FabricaEventChange(this));
    }

    private Fabrica(FabricaId fabricaId){
        super(fabricaId);
        subscribe(new FabricaEventChange(this));
    }

    public static Fabrica from(FabricaId fabricaId, List<DomainEvent> events){
        var fabrica = new Fabrica(fabricaId);
        events.forEach(fabrica::applyEvent);
        return fabrica;
    }

    /*
    * Comportamientos
    */

    public void agregarMolde(Forma forma, Medidas medidas, Cantidad cantidad){
        var moldeId = new MoldeId();
        appendChange(new MoldeCreado(moldeId, forma, medidas, cantidad)).apply();

    }

    public void agregarMaquinaria(Tipo tipo){
        var maquinariaId = new MaquinariaId();
        appendChange(new MaquinariaAgregada(maquinariaId, tipo)).apply();
    }

    public void agregarInsumo(Tipo tipo){
        var insumoId = new InsumoId();
        appendChange(new InsumoAgregado(insumoId, tipo)).apply();
    }

    public void cambiarDetallesDelMolde(MoldeId mentoriaId, Forma forma, Medidas medidas, Cantidad cantidad){
        appendChange(new DetallesDelMoldeCambiados(mentoriaId, forma, medidas, cantidad)).apply();
    }

    //Propiedades

    public Nombre nombre (){
        return nombre;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Maquinaria maquinaria() {
        return maquinaria;
    }

    public Insumo insumo() {
        return insumo;
    }

    public Set<Molde> listaDeMoldes() {
        return listaDeMoldes;
    }
}



