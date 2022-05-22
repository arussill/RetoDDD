package co.com.sofkau.retoDDD.producion.coleccion.event;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.retoDDD.producion.coleccion.Coleccion;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionFinalizada;

public class RealizarPruebaUseCase extends UseCase<TriggeredEvent<ColeccionFinalizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ColeccionFinalizada> input) {
        var event = input.getDomainEvent();
        var coleccion = Coleccion.from(event.getColeccionId(), repository().getEventsBy(event.getColeccionId().value()));
        coleccion.realizarPrueba(event.getFecha(), event.getResultado());

        emit().onResponse(new ResponseEvents(coleccion.getUncommittedChanges()));
    }
}
