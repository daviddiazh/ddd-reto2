package com.co.sofka.profesional.domain.perfil.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class IdPerfil extends Identity {

    public IdPerfil(String id) {
        super(id);
    }

    public IdPerfil(){

    }

    public static IdPerfil of(String id){
        return new IdPerfil(id);
    }

}
