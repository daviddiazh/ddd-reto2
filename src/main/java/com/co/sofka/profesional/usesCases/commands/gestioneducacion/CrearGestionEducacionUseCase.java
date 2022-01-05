package com.co.sofka.profesional.usesCases.commands.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.sofka.profesional.domain.gestioneducacion.GestionEducacion;
import com.co.sofka.profesional.domain.gestioneducacion.commands.CrearGestionEducacion;

public class CrearGestionEducacionUseCase extends UseCase<RequestCommand<CrearGestionEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearGestionEducacion> requestCommand) {
        var command = requestCommand.getCommand();

        GestionEducacion gestionEducacion;

        gestionEducacion = new GestionEducacion(
                command.getIdGestionEducacion(),
                command.getHojaDeVidaId()
        );

        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));

    }

}
