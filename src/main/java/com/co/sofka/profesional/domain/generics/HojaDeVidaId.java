package com.co.sofka.profesional.domain.generics;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;
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

    public static HojaDeVidaId of(String id){
        return new HojaDeVidaId(id);
    }

    @Override
    public String value() {
        return null;
    }

}
