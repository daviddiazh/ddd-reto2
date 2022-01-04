package com.co.sofka.profesional.domain.gestioneducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.gestioneducacion.values.IdGestionEducacion;

public class CrearGestionEducacion  extends Command {

    private final IdGestionEducacion idGestionEducacion;
    private final HojaDeVidaId hojaDeVidaId;

    public CrearGestionEducacion(IdGestionEducacion idGestionEducacion, HojaDeVidaId hojaDeVidaId) {
        this.idGestionEducacion = idGestionEducacion;
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public IdGestionEducacion getIdGestionEducacion() {
        return idGestionEducacion;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

}
