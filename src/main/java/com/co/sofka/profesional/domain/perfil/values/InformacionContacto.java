package com.co.sofka.profesional.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InformacionContacto implements ValueObject<String> {

    private final String value;

    public InformacionContacto(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if(this.value.length()< 7 || this.value.length() > 10){
            throw new IllegalArgumentException("El teléfono no puede tener menos de siete caracteres");
        }
        if (!this.value.matches("[0-9]*")){
            throw new IllegalArgumentException("El teléfono sólo puede incluir números");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
