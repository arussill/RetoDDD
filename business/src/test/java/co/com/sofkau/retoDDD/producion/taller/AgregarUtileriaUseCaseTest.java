package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.taller.commands.AgregarUtileria;
import co.com.sofkau.retoDDD.producion.taller.events.UtileriaAgregada;
import co.com.sofkau.retoDDD.producion.taller.values.TallerId;
import co.com.sofkau.retoDDD.producion.taller.values.UtileriaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarUtileriaUseCaseTest {

    @InjectMocks
    private AgregarUtileriaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUtileriaHappyPass() {
        //arrange
        TallerId tallerId = TallerId.of("Taller01");
        UtileriaId utileriaId = UtileriaId.of("Materiales01");
        Nombre nombre = new Nombre("Telas");
        var command = new AgregarUtileria(tallerId, utileriaId, nombre);

        when(repository.getEventsBy("Taller01")).thenReturn(storedEvents());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTallerId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (UtileriaAgregada) events.get(0);
        Assertions.assertEquals("Telas", event.getNombre().value());
        Assertions.assertEquals("Taller01", event.aggregateRootId());

    }

    private List<DomainEvent> storedEvents() {
        Nombre nombre = new Nombre("Colecion de Verano");
        Fecha fecha = new Fecha(LocalTime.now(), LocalDate.now());
        var event = new ColeccionCreada(
                nombre,
                fecha
        );
        event.setAggregateRootId("DDD");
        return List.of(event);
    }
}