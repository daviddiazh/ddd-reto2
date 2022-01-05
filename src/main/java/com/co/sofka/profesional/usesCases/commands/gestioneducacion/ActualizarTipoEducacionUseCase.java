package com.co.sofka.profesional.usesCases.commands.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.sofka.profesional.domain.gestioneducacion.GestionEducacion;
import com.co.sofka.profesional.domain.gestioneducacion.commands.ActualizarTipoEducacion;

public class ActualizarTipoEducacionUseCase extends UseCase<RequestCommand<ActualizarTipoEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoEducacion> requestCommand) {

        var command = requestCommand.getCommand();

        GestionEducacion gestionEducacion;

        gestionEducacion = GestionEducacion.from(
                command.getIdGestionEducacion(),
                retrieveEvents()
        );

        gestionEducacion.actualizarTipoEducacion(
                command.getEducacionId(),
                command.getTipo()
        );

        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));
    }
}
