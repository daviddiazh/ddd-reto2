package com.co.sofka.profesional.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.Identity;
import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;

public class EducacionId extends Identity {

    public EducacionId(String id) {
        super(id);
    }

    public EducacionId(){

    }

    public static EducacionId of(String id){
        return new EducacionId(id);
    }

}
