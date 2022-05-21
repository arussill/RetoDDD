package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.taller.commands.AgregarDisenador;

public class AgregarDisenadorUseCase extends UseCase<RequestCommand<AgregarDisenador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDisenador> agregarDisenadorRequestCommand) {
        var command = agregarDisenadorRequestCommand.getCommand();
        var taller= Taller.from(command.getTallerId(), repository().getEventsBy(command.getTallerId().value()));
        taller.agregarDisenador(command.getNombre(), command.getTelefono());

        emit().onResponse(new ResponseEvents(taller.getUncommittedChanges()));
    }

}
