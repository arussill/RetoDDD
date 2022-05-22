package co.com.sofkau.retoDDD.producion.coleccion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Resultado;

public class ColeccionFinalizada extends DomainEvent {

    private final Resultado resultado;
    private final ColeccionId coleccionId;
    private final Fecha fecha;

    public ColeccionFinalizada(Resultado resultado, ColeccionId coleccionId, Fecha fecha) {
        super("co.com.sofkau.retoDDD.producion.ColeccionFinalizada");
        this.resultado = resultado;
        this.coleccionId = coleccionId;
        this.fecha = fecha;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public ColeccionId getColeccionId() {
        return coleccionId;
    }

    public Fecha getFecha() {
        return fecha;
    }

}
