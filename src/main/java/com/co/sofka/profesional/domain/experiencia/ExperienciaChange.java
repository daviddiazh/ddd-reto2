package com.co.sofka.profesional.domain.experiencia;

import co.com.sofka.domain.generic.EventChange;
import com.co.sofka.profesional.domain.experiencia.commands.ActualizarExperienciaLaboralPeriodo;
import com.co.sofka.profesional.domain.experiencia.events.ExperienciaCreada;
import com.co.sofka.profesional.domain.experiencia.events.NuevaExperienciaLaboralAgregada;
import com.co.sofka.profesional.domain.experiencia.events.PeriodoExperienciaLaboralActualizada;

public class ExperienciaChange extends EventChange {

    public ExperienciaChange(Experiencia experiencia) {

        apply((ExperienciaCreada event) -> {
            experiencia.hojaDeVidaId = event.getHojaDeVidaId();
        });

        apply((NuevaExperienciaLaboralAgregada event) -> {
            experiencia.experienciaLaboral = new ExperienciaLaboral(
                    event.getId(),
                    event.getInstitucion(),
                    event.getPeriodo(),
                    event.getConocimientosAdquiridos()
            );
        });

        apply((PeriodoExperienciaLaboralActualizada event) -> {
            experiencia.experienciaLaboral.periodo = event.getPeriodo();
        });

    }

}
