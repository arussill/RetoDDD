package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.coleccion.commands.CrearColeccion;

public class CrearColeccionUseCase extends UseCase<RequestCommand<CrearColeccion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearColeccion> crearColeccionRequestCommand) {
        var command = crearColeccionRequestCommand.getCommand();

        var coleccion = new Coleccion(command.getColeccionId(), command.getNombre(), command.getFecha());

        emit().onResponse(new ResponseEvents(coleccion.getUncommittedChanges()));
    }
}
