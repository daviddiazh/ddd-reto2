package com.co.sofka.profesional.usesCases.events;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.co.sofka.profesional.domain.experiencia.events.ExperienciaCreada;
import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;
import com.co.sofka.profesional.usesCases.services.EnviarNotificacionService;

import java.util.List;

public class NotificarExperienciaCreadaExitosamenteUseCase extends UseCase<TriggeredEvent<ExperienciaCreada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ExperienciaCreada> triggeredEvent) {

        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarNotificacionService.class).orElseThrow();

        Boolean esValido = service.enviarExperiencia(
                "hola@sofkau.com",
                "Experiencia creada exitosamente.",
                IdExperiencia.of(event.aggregateRootId())
        );

        if (!esValido) {
            throw new BusinessException(event.aggregateRootId(), "No es posible notificar la creación de la experiencia profesional");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }

}
