package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.taller.commands.AgregarUtileria;

public class AgregarUtileriaUseCase extends UseCase<RequestCommand<AgregarUtileria>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarUtileria> agregarUtileriaRequestCommand) {
        var command = agregarUtileriaRequestCommand.getCommand();
        var taller= Taller.from(command.getTallerId(), repository().getEventsBy(command.getTallerId().value()));
        taller.agregarUtileria(command.getNombre());

        emit().onResponse(new ResponseEvents(taller.getUncommittedChanges()));
    }

}