package co.com.sofkau.retoDDD.producion.coleccion.event;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.retoDDD.producion.coleccion.Coleccion;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCambiada;

public class CambiarPersonalUseCase extends UseCase<TriggeredEvent<ColeccionCambiada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ColeccionCambiada> input) {
        var event = input.getDomainEvent();
        var coleccion = Coleccion.from(event.getColeccionId(), repository().getEventsBy(event.getColeccionId().value()));
        coleccion.cambiarPersonal(event.getNombre(), event.getTelefono());

        emit().onResponse(new ResponseEvents(coleccion.getUncommittedChanges()));
    }
}
