package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.coleccion.commands.RealizarPrueba;

public class RealizarPruebaUseCase extends UseCase<RequestCommand<RealizarPrueba>, ResponseEvents> {
@Override
public void executeUseCase(RequestCommand<RealizarPrueba> realizarPruebaRequestCommand) {
        var command = realizarPruebaRequestCommand.getCommand();
        var coleccion= Coleccion.from(command.getColeccionId(), repository().getEventsBy(command.getColeccionId().value()));
        coleccion.realizarPrueba(command.getFecha(), command.getResultado());

        emit().onResponse(new ResponseEvents(coleccion.getUncommittedChanges()));
        }
}
