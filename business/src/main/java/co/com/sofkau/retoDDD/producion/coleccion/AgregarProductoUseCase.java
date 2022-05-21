package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.coleccion.commands.AgregarProducto;

public class AgregarProductoUseCase extends UseCase<RequestCommand<AgregarProducto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarProducto> agregaProductoRequestCommand) {
        var command = agregaProductoRequestCommand.getCommand();
        var coleccion= Coleccion.from(command.getColeccionId(), repository().getEventsBy(command.getColeccionId().value()));
        coleccion.agregarProducto(command.getNombre(), command.getColor(),command.getTalla(),command.getCategoria());

        emit().onResponse(new ResponseEvents(coleccion.getUncommittedChanges()));
    }
}
