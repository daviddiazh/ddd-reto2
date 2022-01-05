package com.co.sofka.profesional.usesCases.commands.gestioneducacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.co.sofka.profesional.domain.gestioneducacion.GestionEducacion;
import com.co.sofka.profesional.domain.gestioneducacion.commands.AgregarNuevaEducacion;

public class AgregarEducacionUseCase extends UseCase<RequestCommand<AgregarNuevaEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaEducacion> requestCommand) {

        var command = requestCommand.getCommand();

        GestionEducacion gestionEducacion;

        gestionEducacion = GestionEducacion.from(
                command.getGestionEducacionId(),
                retrieveEvents()
        );

        gestionEducacion.agregarNuevaEducacion(
                command.getTarjetaProfesional(),
                command.getTipo(),
                command.getEstudio(),
                command.getInstitucion(),
                command.getPeriodo()
        );

        if (!(gestionEducacion.educacion().tarjetaProfesional().value().respuesta().equalsIgnoreCase("y") || gestionEducacion.educacion().tarjetaProfesional().value().retorno())) {
            throw new BusinessException(command.getGestionEducacionId().value(), "El aspirante debe tener tarjeta profesional de su educación");
        }

        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));
    }

}
