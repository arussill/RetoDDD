package co.com.sofkau.retoDDD.producion.taller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.retoDDD.generic.values.Direccion;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;
import co.com.sofkau.retoDDD.producion.taller.commands.CrearTaller;
import co.com.sofkau.retoDDD.producion.taller.events.TallerCreado;
import co.com.sofkau.retoDDD.producion.taller.values.TallerId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearTallerUseCaseTest {

    private CrearTallerUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearTallerUseCase();
    }

    @Test
    void crearColeccionHappyPass() {
        //arrange
        TallerId tallerId = TallerId.of("Taller01");
        Nombre nombre = new Nombre("Taller de Aura");
        Direccion direccion = new Direccion("Mi Casa");
        Telefono telefono = new Telefono("321456");
        var command = new CrearTaller( tallerId,  nombre,  direccion,  telefono);

        //act
        var events = UseCaseHandler.getInstance().syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //asserts
        var tallerCreado = (TallerCreado)events.get(0);
        Assertions.assertEquals("Taller01", tallerCreado.aggregateRootId());
        Assertions.assertEquals("Taller de Aura", tallerCreado.getNombre().value());
        Assertions.assertEquals("Mi Casa", tallerCreado.getDireccion().value());
        Assertions.assertEquals("321456", tallerCreado.getTelefono().value());


    }
}