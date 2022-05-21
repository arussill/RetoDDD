package co.com.sofkau.retoDDD.producion.fabrica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.fabrica.commands.CrearFabrica;

/**
 * Caso de uso Crear Fabrica
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */
public class CrearFabricaUseCase extends UseCase<RequestCommand<CrearFabrica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFabrica> crearFabricaRequestCommand) {
        var command = crearFabricaRequestCommand.getCommand();

        var fabrica = new Fabrica(command.getFabricaId(),command.getNombre(),command.getDireccion(),command.getTelefono());

        emit().onResponse(new ResponseEvents(fabrica.getUncommittedChanges()));
    }
}
