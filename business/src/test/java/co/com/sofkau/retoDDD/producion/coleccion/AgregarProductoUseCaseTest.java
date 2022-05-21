package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.commands.AgregarProducto;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.coleccion.events.ProductoAgregado;
import co.com.sofkau.retoDDD.producion.coleccion.values.*;
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
class AgregarProductoUseCaseTest {
    @InjectMocks
    private AgregarProductoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarProductoHappyPass() {
        //arrange
        ProductoId productoId = ProductoId.of("Producto1");
        Talla talla = new Talla("S");
        Color color = new Color("Azul");
        Categoria categoria = new Categoria("Mujer");
        Nombre nombre = new Nombre("Camisa");
        ColeccionId coleccionId = ColeccionId.of("DDD");
        var command = new AgregarProducto( productoId, talla, color, categoria, nombre, coleccionId);

        when(repository.getEventsBy("DDD")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events= UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getColeccionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ProductoAgregado)events.get(0);
        Assertions.assertEquals("Camisa", event.getNombre().value());
        Assertions.assertEquals("S", event.getTalla().value());
        Assertions.assertEquals("Azul", event.getColor().value());
        Assertions.assertEquals("Mujer", event.getCategoria().value());
    }

    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("Coleccion de Verano");
        Fecha fecha = new Fecha(LocalTime.now(), LocalDate.now());
        var event = new ColeccionCreada(
                nombre,
                fecha
        );
        event.setAggregateRootId("DDD");
        return List.of(event);
    }


}