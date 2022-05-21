package co.com.sofkau.retoDDD.producion.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Tipo;
import co.com.sofkau.retoDDD.producion.fabrica.values.FabricaId;
import co.com.sofkau.retoDDD.producion.fabrica.values.InsumoId;

/**
 * Comando Agregar Insumo
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class AgregarInsumo extends Command {
    private final FabricaId fabricaId;
    private final InsumoId insumoId;
    private final Tipo tipo;

    public AgregarInsumo(FabricaId fabricaId, InsumoId insumoId, Tipo tipo) {
        this.fabricaId = fabricaId;
        this.insumoId = insumoId;
        this.tipo = tipo;
    }

    public InsumoId getInsumoId() {
        return insumoId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }
}
