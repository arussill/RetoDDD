package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.taller.commands.CrearBoceto;

public class CrearBocetoUseCase extends UseCase<RequestCommand<CrearBoceto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearBoceto> crearBocetoRequestCommand) {
        var command = crearBocetoRequestCommand.getCommand();
        var taller= Taller.from(command.getTallerId(), repository().getEventsBy(command.getTallerId().value()));
        taller.crearBoceto(command.getMedidas(),command.getDescripcion());

        emit().onResponse(new ResponseEvents(taller.getUncommittedChanges()));
    }

}