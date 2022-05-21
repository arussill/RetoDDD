package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.taller.commands.CrearTaller;

/**
 * Caso de uso Crear Taller
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */
public class CrearTallerUseCase extends UseCase<RequestCommand<CrearTaller>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTaller> crearTallerRequestCommand) {
        var command = crearTallerRequestCommand.getCommand();

        var taller = new Taller(command.getTallerId(), command.getNombre(), command.getDireccion(), command.getTelefono());

        emit().onResponse(new ResponseEvents(taller.getUncommittedChanges()));
    }
}

