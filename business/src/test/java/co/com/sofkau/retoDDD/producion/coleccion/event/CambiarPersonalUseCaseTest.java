package co.com.sofkau.retoDDD.producion.coleccion.event;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCambiada;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.coleccion.events.PersonalCambiado;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
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
class CambiarPersonalUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @InjectMocks
    private CambiarPersonalUseCase useCase;

    @Test
    void cambiarPersonalHappyPass(){
        //arrange
        var coleccionId = ColeccionId.of("Coleccion02") ;
        var nombre = new Nombre("Aura") ;
        var telefono = new Telefono("123654");
        var event = new ColeccionCambiada( coleccionId,  nombre,  telefono);
        when(repository.getEventsBy("Coleccion02")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var cambioDePersonal = (PersonalCambiado)events.get(0);
        Assertions.assertEquals("Aura", cambioDePersonal.getNombre().value());
        Assertions.assertEquals("123654", event.getTelefono().value());
        Assertions.assertEquals("Coleccion02", cambioDePersonal.aggregateRootId());
    }

    private List<DomainEvent> history(){
        var nombre = new Nombre("Coleccion De Verano");
        var fecha = new Fecha(now(), LocalDate.now());
        var event = new ColeccionCreada(nombre, fecha);
        return List.of(event);
    }
}