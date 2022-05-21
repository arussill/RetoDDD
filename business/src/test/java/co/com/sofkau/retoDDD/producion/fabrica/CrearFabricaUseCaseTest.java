package co.com.sofkau.retoDDD.producion.fabrica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.retoDDD.generic.values.Direccion;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;
import co.com.sofkau.retoDDD.producion.fabrica.commands.CrearFabrica;
import co.com.sofkau.retoDDD.producion.fabrica.events.FabricaCreada;
import co.com.sofkau.retoDDD.producion.fabrica.values.FabricaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CrearFabricaUseCaseTest {

    private CrearFabricaUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearFabricaUseCase();
    }

    @Test
    void crearFabricaHappyPass() {
        //arrange
        Nombre nombre = new Nombre("Empresa Aura");
        Direccion direccion = new Direccion(("Mi casa"));
        Telefono telefono = new Telefono("321456");
        FabricaId fabricaId = FabricaId.of("Fabrica01");
        var command = new CrearFabrica(fabricaId, nombre, direccion,  telefono);

        //act
        var events = UseCaseHandler.getInstance().syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //asserts
        var event = (FabricaCreada)events.get(0);
        Assertions.assertEquals("Fabrica01", event.aggregateRootId());
        Assertions.assertEquals("Empresa Aura", event.getNombre().value());
        Assertions.assertEquals("Mi casa", event.getDireccion().value());
        Assertions.assertEquals("321456", event.getTelefono().value());



    }
}