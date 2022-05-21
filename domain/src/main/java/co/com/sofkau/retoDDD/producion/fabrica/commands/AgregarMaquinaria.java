package co.com.sofkau.retoDDD.producion.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.generic.values.Tipo;
import co.com.sofkau.retoDDD.producion.fabrica.values.FabricaId;
import co.com.sofkau.retoDDD.producion.fabrica.values.MaquinariaId;

/**
 * Comando Agregar Maquinaria
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class AgregarMaquinaria extends Command {

    private final FabricaId fabricaId;
    private final MaquinariaId maquinariaId;
    private final Tipo tipo;

    public AgregarMaquinaria(FabricaId fabricaId, MaquinariaId maquinariaId, Tipo tipo) {
        this.fabricaId = fabricaId;
        this.maquinariaId = maquinariaId;
        this.tipo = tipo;
    }

    public MaquinariaId getMaquinariaId() {
        return maquinariaId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public FabricaId getFabricaId() {
        return fabricaId;
    }
}
