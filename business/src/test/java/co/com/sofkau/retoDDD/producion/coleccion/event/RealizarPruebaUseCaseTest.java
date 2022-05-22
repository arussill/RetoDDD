package co.com.sofkau.retoDDD.producion.coleccion.event;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionFinalizada;
import co.com.sofkau.retoDDD.producion.coleccion.events.PruebaRealizada;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
import co.com.sofkau.retoDDD.producion.coleccion.values.Resultado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalTime.now;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RealizarPruebaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @InjectMocks
    private RealizarPruebaUseCase useCase;

    @Test
    void realizarPruebaHappyPass(){
        //arrange
        var resultado = new Resultado("Pasada");
        var coleccionId = ColeccionId.of("Coleccion01");
        var fecha = new Fecha(now(), LocalDate.now());
        var event = new ColeccionFinalizada(resultado, coleccionId, fecha);
        when(repository.getEventsBy("Coleccion01")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var pruebaRealizada = (PruebaRealizada)events.get(0);
        Assertions.assertEquals("Pasada", pruebaRealizada.getResultado().value());
        Assertions.assertEquals(fecha, pruebaRealizada.getFecha());
        Assertions.assertEquals("Coleccion01", pruebaRealizada.aggregateRootId());
    }

    private List<DomainEvent> history(){
        var nombre = new Nombre("Coleccion De Verano");
        var fecha = new Fecha(now(), LocalDate.now());
        var event = new ColeccionCreada(nombre, fecha);
        return List.of(event);
    }
}