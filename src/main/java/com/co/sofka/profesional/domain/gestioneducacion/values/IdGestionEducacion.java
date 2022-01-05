package com.co.sofka.profesional.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdGestionEducacion extends Identity {

    public IdGestionEducacion(String id) {
        super(id);
    }

    public IdGestionEducacion(){

    }

    public static IdGestionEducacion of(String id){
        return new IdGestionEducacion(id);
    }

}
