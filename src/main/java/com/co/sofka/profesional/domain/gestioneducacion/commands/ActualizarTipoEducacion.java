package com.co.sofka.profesional.domain.gestioneducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.gestioneducacion.values.EducacionId;
import com.co.sofka.profesional.domain.gestioneducacion.values.IdGestionEducacion;
import com.co.sofka.profesional.domain.gestioneducacion.values.Tipo;

public class ActualizarTipoEducacion extends Command {

    private final IdGestionEducacion idGestionEducacion;
    private final EducacionId educacionId;
    private final Tipo tipo;

    public ActualizarTipoEducacion(IdGestionEducacion idGestionEducacion, EducacionId educacionId, Tipo tipo) {
        this.idGestionEducacion = idGestionEducacion;
        this.educacionId = educacionId;
        this.tipo = tipo;
    }

    public IdGestionEducacion getIdGestionEducacion() {
        return idGestionEducacion;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Tipo getTipo() {
        return tipo;
    }

}
