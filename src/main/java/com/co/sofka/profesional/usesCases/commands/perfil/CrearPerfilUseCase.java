package com.co.sofka.profesional.usesCases.commands.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.sofka.profesional.domain.perfil.Perfil;
import com.co.sofka.profesional.domain.perfil.commands.CrearPerfil;

public class CrearPerfilUseCase extends UseCase<RequestCommand<CrearPerfil>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPerfil> crearPerfilRequestCommand) {

        var command = crearPerfilRequestCommand.getCommand();

        Perfil perfil;

        perfil = new Perfil(
                command.getIdPerfil(),
                command.getHojaDeVidaId(),
                command.getInformacionContacto(),
                command.getFotoPerfil()
        );

        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));

    }
}
