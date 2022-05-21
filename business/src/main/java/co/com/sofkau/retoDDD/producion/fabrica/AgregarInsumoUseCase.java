package co.com.sofkau.retoDDD.producion.fabrica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.retoDDD.producion.fabrica.commands.AgregarInsumo;

public class AgregarInsumoUseCase extends UseCase<RequestCommand<AgregarInsumo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarInsumo> agregarInsumoRequestCommand) {
        var command = agregarInsumoRequestCommand.getCommand();
        var fabrica = Fabrica.from(command.getFabricaId(),repository().getEventsBy(command.getFabricaId().value()));
        fabrica.agregarInsumo(command.getTipo());

        emit().onResponse(new ResponseEvents(fabrica .getUncommittedChanges()));
    }

}
