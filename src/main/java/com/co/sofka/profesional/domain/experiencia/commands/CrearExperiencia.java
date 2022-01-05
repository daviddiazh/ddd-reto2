package com.co.sofka.profesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.experiencia.ExperienciaLaboral;
import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;

public class CrearExperiencia extends Command {

    private final IdExperiencia idExperiencia;
    private final HojaDeVidaId hojaDeVidaId;

    public CrearExperiencia(IdExperiencia idExperiencia, HojaDeVidaId hojaDeVidaId) {
        this.idExperiencia = idExperiencia;
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public IdExperiencia getIdExperiencia() {
        return idExperiencia;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

}
