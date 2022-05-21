package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Medidas;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.taller.commands.CrearBoceto;
import co.com.sofkau.retoDDD.producion.taller.events.BocetoCreado;
import co.com.sofkau.retoDDD.producion.taller.values.BocetoId;
import co.com.sofkau.retoDDD.producion.taller.values.Descripcion;
import co.com.sofkau.retoDDD.producion.taller.values.TallerId;
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
class CrearBocetoUseCaseTest {

    @InjectMocks
    private CrearBocetoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarPersonalHappyPass() {
        //arrange
        TallerId tallerId = TallerId.of("Taller01");
        BocetoId bocetoId = BocetoId.of("Boceto01");
        Medidas medidas = new Medidas("1m", "2m");
        Descripcion descripcion = new Descripcion("Este boceto es para una camisa");
        var command = new CrearBoceto(tallerId, bocetoId, medidas, descripcion);

        when(repository.getEventsBy("Taller01")).thenReturn(storedEvents());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTallerId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (BocetoCreado) events.get(0);
        Assertions.assertEquals("2m", event.getMedidas().value().ancho());
        Assertions.assertEquals("1m", event.getMedidas().value().largo());
        Assertions.assertEquals("Este boceto es para una camisa", event.getDescripcion().value());
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