package co.com.sofkau.retoDDD.producion.coleccion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.retoDDD.generic.values.Fecha;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.coleccion.commands.CrearColeccion;
import co.com.sofkau.retoDDD.producion.coleccion.events.ColeccionCreada;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Caso de uso Crear Coleccion
 *
 * @author Aura russil
 * @version 1.0.0
 * @since 1.0.0
 */

class CrearColeccionUseCaseTest {

    private CrearColeccionUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearColeccionUseCase();
    }

    @Test
    void crearColeccionHappyPass() {
        //arrange
        ColeccionId coleccionId = ColeccionId.of("DDD");
        Nombre nombre = new Nombre("DDD");
        Fecha fecha = new Fecha(LocalTime.now(), LocalDate.now());
        var command = new CrearColeccion(coleccionId, nombre, fecha);

        //act
        var events =UseCaseHandler.getInstance().syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //asserts
        var coleccionCreada = (ColeccionCreada)events.get(0);
        Assertions.assertEquals("DDD", coleccionCreada.aggregateRootId());
        Assertions.assertEquals("DDD", coleccionCreada.getNombre().value());
        Assertions.assertEquals(fecha, coleccionCreada.getFecha());


    }
}