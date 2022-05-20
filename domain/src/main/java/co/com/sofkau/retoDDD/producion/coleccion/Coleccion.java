package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Personal;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Producto;
import co.com.sofkau.retoDDD.producion.coleccion.entitys.Prueba;
import co.com.sofkau.retoDDD.producion.coleccion.events.*;
import co.com.sofkau.retoDDD.producion.coleccion.values.*;;
import generic.values.Fecha;
import generic.values.Nombre;
import generic.values.Telefono;

import java.util.List;

public class Coleccion extends AggregateEvent<ColeccionId> {

    protected Nombre nombre;
    protected Fecha fecha;
    protected Prueba prueba;
    protected Personal personal;
    protected Producto producto;

    /**
     * Constructor del Agregado Colección.
     *
     * @param entityId the entity id
     */
    public Coleccion(ColeccionId entityId, Nombre nombre, Fecha fecha) {
        super(entityId);
        appendChange(new ColeccionCreada(nombre, fecha)).apply();
        subscribe(new ColeccionEventChange(this));
    }

    private Coleccion(ColeccionId coleccionId){
        super(coleccionId);
        subscribe(new ColeccionEventChange(this));
    }

    public static Coleccion from(ColeccionId coleccionId, List<DomainEvent> events){
        var coleccion = new Coleccion(coleccionId);
        events.forEach(coleccion::applyEvent);
        return coleccion;
    }

    //Comportamientos

    public void realizarPrueba(Fecha fecha, Resultado resultado){
        var pruebaId = new PruebaId();
        appendChange(new PruebaRealizada(pruebaId, fecha, resultado)).apply();
    }

    public void agregarPersonal(Nombre nombre, Telefono telefono){
        var personalId = new PersonalId();
        appendChange(new PersonalAgregado(personalId, nombre, telefono)).apply();
    }

    public void agregarProducto(Nombre nombre, Color color, Talla talla, Categoria categoria){
        var porductoId = new ProductoId();
        appendChange(new ProductoAgregado(porductoId, nombre, color, talla, categoria)).apply();
    }

    public void cambiarPersonal(PersonalId personalId, Nombre nombre, Telefono telefono){
        appendChange(new PersonalCambiado(personalId,nombre,telefono)).apply();
    }

    //Propiedades

    public Nombre Nombre() {
        return nombre;
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Prueba Prueba() {
        return prueba;
    }

    public Personal Personal() {
        return personal;
    }

    public Producto Producto() {
        return producto;
    }
}
