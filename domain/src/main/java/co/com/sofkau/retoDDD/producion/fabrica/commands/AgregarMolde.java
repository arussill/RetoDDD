package co.com.sofkau.retoDDD.producion.fabrica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.retoDDD.producion.fabrica.values.Cantidad;
import co.com.sofkau.retoDDD.producion.fabrica.values.Forma;
import co.com.sofkau.retoDDD.producion.fabrica.values.MoldeId;
import generic.values.Medidas;
/**
 * Comando Agregar Molde
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */
public class AgregarMolde extends Command {
    private final MoldeId moldeId;
    private final Forma forma;
    private final Medidas medidas;
    private final Cantidad cantidad;

    public AgregarMolde(MoldeId moldeId, Forma forma, Medidas medidas, Cantidad cantidad) {
        this.moldeId = moldeId;
        this.forma = forma;
        this.medidas = medidas;
        this.cantidad = cantidad;
    }

    public MoldeId getMoldeId() {
        return moldeId;
    }

    public Forma getForma() {
        return forma;
    }

    public Medidas getMedidas() {
        return medidas;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
