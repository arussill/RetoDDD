package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.coleccion.commands.AgregarPersonal;

public class AgregarPersonalUseCase extends UseCase<RequestCommand<AgregarPersonal>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPersonal> agregarPersonalRequestCommand) {
     var command = agregarPersonalRequestCommand.getCommand();
     var coleccion= Coleccion.from(command.getColeccionId(), repository().getEventsBy(command.getColeccionId().value()));
     coleccion.agregarPersonal(command.getNombre(), command.getTelefono());

     emit().onResponse(new ResponseEvents(coleccion.getUncommittedChanges()));
    }

}
