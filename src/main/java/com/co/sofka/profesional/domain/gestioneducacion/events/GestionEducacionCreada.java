package com.co.sofka.profesional.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.gestioneducacion.values.IdGestionEducacion;

public class GestionEducacionCreada extends DomainEvent {

    private HojaDeVidaId hojaDeVidaId;

    public GestionEducacionCreada(HojaDeVidaId hojaDeVidaId) {
        super("sofka.gestioneducacion.gestioneducacioncreada");
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

}
