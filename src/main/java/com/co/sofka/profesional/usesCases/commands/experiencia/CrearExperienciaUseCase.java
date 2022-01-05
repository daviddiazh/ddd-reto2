package com.co.sofka.profesional.usesCases.commands.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.sofka.profesional.domain.experiencia.Experiencia;
import com.co.sofka.profesional.domain.experiencia.commands.CrearExperiencia;
import com.co.sofka.profesional.domain.perfil.commands.CrearPerfil;

public class CrearExperienciaUseCase extends UseCase<RequestCommand<CrearExperiencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearExperiencia> crearExperienciaRequestCommand) {

        var command = crearExperienciaRequestCommand.getCommand();

        Experiencia experiencia;

        experiencia = new Experiencia(
                command.getIdExperiencia(),
                command.getHojaDeVidaId()
        );

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));

    }

}
