package com.co.sofka.profesional.usesCases.commands.experiencia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.sofka.profesional.domain.experiencia.Experiencia;
import com.co.sofka.profesional.domain.experiencia.ExperienciaLaboral;
import com.co.sofka.profesional.domain.experiencia.commands.ActualizarExperienciaLaboralPeriodo;
import com.co.sofka.profesional.domain.experiencia.values.ConocimientosAdquiridos;
import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;
import com.co.sofka.profesional.domain.experiencia.values.IdExperienciaLaboral;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;
import com.co.sofka.profesional.domain.perfil.commands.ActualizarNombreCompletoReferencia;

public class ActualizarExperienciaLaboralPeriodoUseCase extends UseCase<RequestCommand<ActualizarExperienciaLaboralPeriodo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarExperienciaLaboralPeriodo> actualizarExperienciaLaboralPeriodoRequestCommand) {

        var command = actualizarExperienciaLaboralPeriodoRequestCommand.getCommand();

        Experiencia experiencia;

        experiencia = Experiencia.from(
                command.getIdExperiencia(),
                retrieveEvents()
        );

        experiencia.actualizarExperienciaLaboralPeriodo(
                command.getIdExperienciaLaboral(),
                command.getPeriodo()
        );

        if (experiencia.experienciaLaboral().periodo().value().length() > 3) {
            throw new BusinessException(command.getIdExperiencia().value(), "El periodo de la experiencia no puede superar los 999 meses");
        }

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));

    }

}
