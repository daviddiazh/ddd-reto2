package com.co.sofka.profesional.domain.perfil.values;

import co.com.sofka.domain.generic.Identity;

public class ReferenciaId extends Identity {

    public ReferenciaId(String id) {
        super(id);
    }

    public ReferenciaId(){

    }

    public static ReferenciaId of(String id){
        return new ReferenciaId(id);
    }

}
