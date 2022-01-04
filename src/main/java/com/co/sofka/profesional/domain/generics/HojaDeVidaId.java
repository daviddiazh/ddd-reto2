package com.co.sofka.profesional.domain.generics;

import co.com.sofka.domain.generic.ValueObject;
import jdk.jfr.Frequency;

import java.util.Objects;

public class HojaDeVidaId implements ValueObject<String> {

    private final String value;

    public HojaDeVidaId(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El ID de la hoja de vida no puede estar vacío.");
        }
    }

    @Override
    public String value() {
        return null;
    }

}
