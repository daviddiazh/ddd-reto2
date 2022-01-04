package com.co.sofka.profesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;

public class ExperienciaCreada extends DomainEvent {

    private HojaDeVidaId hojaDeVidaId;

    public ExperienciaCreada(HojaDeVidaId hojaDeVidaId) {
        super("sofka.experiencia.experienciacreada");
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
