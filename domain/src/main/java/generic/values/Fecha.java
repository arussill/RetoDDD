package generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Fecha implements ValueObject<Fecha.Pros> {

    private final LocalTime hora;
    private final LocalDate dia;

    public Fecha(LocalTime hora, LocalDate dia) {
        this.hora = Objects.requireNonNull(hora);
        this.dia = Objects.requireNonNull(dia);
    }

    @Override
    public Fecha.Pros value() {
        return new Pros() {
            @Override
            public LocalTime hora() {
                return hora;
            }

            @Override
            public LocalDate dia() {
                return dia;
            }
        };
    }

    public interface Pros {
        LocalTime hora();
        LocalDate dia();
    }
}
