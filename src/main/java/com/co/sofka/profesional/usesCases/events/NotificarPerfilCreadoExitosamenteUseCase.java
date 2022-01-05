package com.co.sofka.profesional.usesCases.events;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.co.sofka.profesional.domain.perfil.PerfilChange;
import com.co.sofka.profesional.domain.perfil.events.PerfilCreado;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.usesCases.services.EnviarNotificacionService;

import java.util.List;

public class NotificarPerfilCreadoExitosamenteUseCase extends UseCase<TriggeredEvent<PerfilCreado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<PerfilCreado> triggeredEvent) {

        var event = triggeredEvent.getDomainEvent();

        var service = getService(EnviarNotificacionService.class).orElseThrow();

        Boolean esValido = service.enviar(
                "hola@sofkau.com",
                "Perfil creado exitosamente.",
                IdPerfil.of(event.aggregateRootId())
        );

        if (!esValido) {
            throw new BusinessException(event.aggregateRootId(), "No es posible notificar la creación del recorrido");
        }

        emit().onResponse(new ResponseEvents(List.of()));

    }

}
