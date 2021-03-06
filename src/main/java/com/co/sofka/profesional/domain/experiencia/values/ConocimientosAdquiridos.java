package com.co.sofka.profesional.domain.experiencia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Set;

public class ConocimientosAdquiridos implements ValueObject<String> {

    private final String value;

    public ConocimientosAdquiridos(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isEmpty()){
            throw new IllegalArgumentException("Los conocimientos no puede estar vacío.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConocimientosAdquiridos that = (ConocimientosAdquiridos) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }

}
