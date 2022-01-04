package com.co.sofka.profesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;
import com.co.sofka.profesional.domain.experiencia.values.IdExperienciaLaboral;
import com.co.sofka.profesional.domain.experiencia.values.Periodo;

public class ActualizarExperienciaLaboralPeriodo extends Command {

    private final IdExperiencia idExperiencia;
    private final IdExperienciaLaboral idExperienciaLaboral;
    private final Periodo periodo;

    public ActualizarExperienciaLaboralPeriodo(IdExperiencia idExperiencia, IdExperienciaLaboral idExperienciaLaboral, Periodo periodo) {
        this.idExperiencia = idExperiencia;
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.periodo = periodo;
    }

    public IdExperiencia getIdExperiencia() {
        return idExperiencia;
    }

    public IdExperienciaLaboral getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

}
