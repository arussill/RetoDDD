package co.com.sofkau.retoDDD.producion.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.producion.fabrica.values.InsumoId;
import generic.values.Tipo;

/**
 * Comando Agregar Insumo
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class AgregarInsumo extends Command {
    private final InsumoId insumoId;
    private final Tipo tipo;

    public AgregarInsumo(InsumoId insumoId, Tipo tipo) {
        this.insumoId = insumoId;
        this.tipo = tipo;
    }

    public InsumoId getInsumoId() {
        return insumoId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
