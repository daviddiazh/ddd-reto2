package com.co.sofka.profesional.domain.experiencia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Periodo implements ValueObject<String> {

    private final String value;

    public Periodo(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El periodo no puede estar vacía");
        }
        if(this.value.length() > 25){
            throw new IllegalArgumentException("El periodo no puede tener más de veinti cinco caracteres");
        }
        if (!this.value.matches("[/s][-][/][0-9]*")){
            throw new IllegalArgumentException("El periodo sólo puede incluir números y algunos caracteres especiales. Y seguir el siguiente formato: yyyy/mm/dd - yyyy/mm/dd");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo = (Periodo) o;
        return Objects.equals(value, periodo.value);
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
