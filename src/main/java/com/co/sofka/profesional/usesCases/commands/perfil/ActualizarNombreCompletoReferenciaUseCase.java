package com.co.sofka.profesional.usesCases.commands.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.perfil.Perfil;
import com.co.sofka.profesional.domain.perfil.commands.ActualizarNombreCompletoReferencia;
import com.co.sofka.profesional.domain.perfil.values.*;

public class ActualizarNombreCompletoReferenciaUseCase extends UseCase<RequestCommand<ActualizarNombreCompletoReferencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCompletoReferencia> actualizarNombreCompletoReferenciaRequestCommand) {

        var command = actualizarNombreCompletoReferenciaRequestCommand.getCommand();

        Perfil perfil;

        perfil = Perfil.from(
                command.getIdPerfil(),
                retrieveEvents()
        );

        perfil.actualizarNombreCompletoReferencia(
                command.getReferenciaId(),
                command.getNombreCompleto()
        );

        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));

    }

}
