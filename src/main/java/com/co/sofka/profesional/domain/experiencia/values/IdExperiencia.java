package com.co.sofka.profesional.domain.experiencia.values;

import co.com.sofka.domain.generic.Identity;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;

public class IdExperiencia extends Identity {

    public IdExperiencia(String id) {
        super(id);
    }

    public IdExperiencia(){

    }

    public static IdExperiencia of(String id){
        return new IdExperiencia(id);
    }

}
