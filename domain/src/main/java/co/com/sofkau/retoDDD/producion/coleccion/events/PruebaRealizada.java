package co.com.sofkau.retoDDD.producion.coleccion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.coleccion.values.PruebaId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Resultado;
import generic.values.Fecha;

public class PruebaRealizada extends DomainEvent {

    private final PruebaId pruebaId;
    private final Fecha fecha;
    private final Resultado resultado;

    public PruebaRealizada(PruebaId pruebaId, Fecha fecha, Resultado resultado) {
        super("co.com.sofkau.retoDDD.producion.PruebaRealizada");
        this.pruebaId = pruebaId;
        this.fecha = fecha;
        this.resultado = resultado;
    }

    public PruebaId getPruebaId() {
        return pruebaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Resultado getResultado() {
        return resultado;
    }
}
