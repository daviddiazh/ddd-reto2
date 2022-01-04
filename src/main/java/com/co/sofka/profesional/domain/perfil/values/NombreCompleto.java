package com.co.sofka.profesional.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject<String> {

    private final String value;

    public NombreCompleto(String value){
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("El nombre completo no puede estar vacío.");
        }
        if(value.length() > 5){
            throw new IllegalArgumentException("El nombre completo debe contener más de 5 letras.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreCompleto that = (NombreCompleto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return null;
    }

}
