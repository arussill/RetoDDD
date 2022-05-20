package co.com.sofkau.retoDDD.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String telefono;

    public Telefono(String telefono) {

        this.telefono = Objects.requireNonNull(telefono, "El telefono no puede estar vacio");

        if(this.telefono.length() > 10){
            throw new IllegalArgumentException("El telefono no puede superar los 10 digitos");
        }
        if(this.telefono.equals("0") && this.telefono.equals("-") ){
            throw new IllegalArgumentException("El telefono no puede empezar con cero o numero negativo");
        }
    }

    public static Telefono of(String telefono) {
        return new Telefono(telefono);
    }

    @Override
    public String value() {
        return null;
    }
}
