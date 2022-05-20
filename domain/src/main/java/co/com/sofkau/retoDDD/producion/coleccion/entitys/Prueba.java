package co.com.sofkau.retoDDD.producion.coleccion.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.producion.coleccion.values.PruebaId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Resultado;

public class Prueba extends Entity<PruebaId> {
    protected PruebaId pruebaId;
    protected Fecha fecha;
    protected Resultado resultado;

    /**
     * Instantiates a new Entity.
     *
     * @param pruebaId the entity id
     * @param fecha
     * @param resultado
     */
    public Prueba(PruebaId pruebaId, Fecha fecha, Resultado resultado) {
        super(pruebaId);
        this.pruebaId = pruebaId;
        this.fecha = fecha;
        this.resultado = resultado;
    }
}
