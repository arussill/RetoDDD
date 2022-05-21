package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.commands.RealizarPrueba;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.coleccion.events.PruebaRealizada;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
import co.com.sofkau.retoDDD.producion.coleccion.values.PruebaId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Resultado;
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
class RealizarPruebaUseCaseTest {

    @InjectMocks
    private RealizarPruebaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void realizarPruebaHappyPass() {
        //arrange
        ColeccionId coleccionId = ColeccionId.of("DDD");
        PruebaId pruebaId = PruebaId.of("Prueba01");
        Fecha fecha = new Fecha(LocalTime.now(), LocalDate.now());
        Resultado resultado = new Resultado("Resultado positivo");
        var command = new RealizarPrueba(coleccionId, pruebaId, fecha, resultado);

        when(repository.getEventsBy("DDD")).thenReturn(storedEvents());
        useCase.addRepository(repository);

        //act
        var events= UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getColeccionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PruebaRealizada)events.get(0);
        Assertions.assertEquals(fecha, event.getFecha());
        Assertions.assertEquals("Resultado positivo", event.getResultado().value());
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