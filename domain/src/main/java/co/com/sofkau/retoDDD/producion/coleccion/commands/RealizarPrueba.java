package co.com.sofkau.retoDDD.producion.coleccion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.producion.coleccion.values.PruebaId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Resultado;

public class RealizarPrueba extends Command {
    private final PruebaId pruebaId;
    private final Fecha fecha;
    private final Resultado resultado;

    public RealizarPrueba(PruebaId pruebaId, Fecha fecha, Resultado resultado) {
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
