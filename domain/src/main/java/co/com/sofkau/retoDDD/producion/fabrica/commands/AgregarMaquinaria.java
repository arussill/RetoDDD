package co.com.sofkau.retoDDD.producion.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.producion.fabrica.values.MaquinariaId;
import generic.values.Tipo;

/**
 * Comando Agregar Maquinaria
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

public class AgregarMaquinaria extends Command {
    private final MaquinariaId maquinariaId;
    private final Tipo tipo;

    public AgregarMaquinaria(MaquinariaId maquinariaId, Tipo tipo) {
        this.maquinariaId = maquinariaId;
        this.tipo = tipo;
    }

    public MaquinariaId getMaquinariaId() {
        return maquinariaId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}