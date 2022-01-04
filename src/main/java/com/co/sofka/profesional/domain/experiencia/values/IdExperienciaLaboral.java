package com.co.sofka.profesional.domain.experiencia.values;

import co.com.sofka.domain.generic.Identity;

public class IdExperienciaLaboral extends Identity {

    public IdExperienciaLaboral(String id) {
        super(id);
    }

    public IdExperienciaLaboral(){

    }

    public static IdExperienciaLaboral of(String id){
        return new IdExperienciaLaboral(id);
    }

}
