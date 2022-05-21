package co.com.sofkau.retoDDD.producion.fabrica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Tipo;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.fabrica.commands.AgregarInsumo;
import co.com.sofkau.retoDDD.producion.fabrica.events.InsumoAgregado;
import co.com.sofkau.retoDDD.producion.fabrica.values.FabricaId;
import co.com.sofkau.retoDDD.producion.fabrica.values.InsumoId;
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
class AgregarInsumoUseCaseTest {

    @InjectMocks
    private AgregarInsumoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarInsumoHappyPass() {
        //arrange
        FabricaId fabricaId = FabricaId.of("Fabrica01");
        InsumoId insumoId = InsumoId.of("Insumo01");
        Tipo tipo = new Tipo("Materiales Sastreria");
        var command = new AgregarInsumo(fabricaId, insumoId, tipo);

        when(repository.getEventsBy("Fabrica01")).thenReturn(storedEvents());
        useCase.addRepository(repository);

        //act
        var events= UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getFabricaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (InsumoAgregado)events.get(0);
        Assertions.assertEquals("Materiales Sastreria", event.getTipo().value());
        Assertions.assertEquals("Fabrica01", event.aggregateRootId());

    }

    private List<DomainEvent> storedEvents() {
        Nombre nombre = new Nombre("Colecion de Verano");
        Fecha fecha = new Fecha(LocalTime.now(), LocalDate.now());
        var event = new ColeccionCreada(
                nombre,
                fecha
        );
        event.setAggregateRootId("Fabrica01");
        return List.of(event);
    }


}
