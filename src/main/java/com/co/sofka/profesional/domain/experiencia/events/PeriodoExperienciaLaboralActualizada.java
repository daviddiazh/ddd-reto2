package com.co.sofka.profesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.experiencia.values.IdExperienciaLaboral;
import com.co.sofka.profesional.domain.generics.Periodo;

public class PeriodoExperienciaLaboralActualizada extends DomainEvent {
    private IdExperienciaLaboral idExperienciaLaboral;
    private Periodo periodo;

    public PeriodoExperienciaLaboralActualizada(IdExperienciaLaboral idExperienciaLaboral, Periodo periodo) {
        super("sofka.experiencia.experiencialaboralactualizada");
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.periodo = periodo;
    }

    public IdExperienciaLaboral getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

}
