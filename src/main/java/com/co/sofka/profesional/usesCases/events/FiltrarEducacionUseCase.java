package com.co.sofka.profesional.usesCases.events;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.co.sofka.profesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import com.co.sofka.profesional.domain.gestioneducacion.values.IdGestionEducacion;
import com.co.sofka.profesional.usesCases.services.FiltrarService;

import java.util.List;

public class FiltrarEducacionUseCase extends UseCase<TriggeredEvent<NuevaEducacionAgregada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<NuevaEducacionAgregada> triggeredEvent) {

        var event = triggeredEvent.getDomainEvent();
        var gestionEducacionId = IdGestionEducacion.of(event.aggregateRootId());
        var service = getService(FiltrarService.class).orElseThrow();

        Boolean esValido = service.filtrar(
                event.getEstudio(),
                event.getEstudio(),
                gestionEducacionId
        );

        if (!esValido) {
            throw new BusinessException(event.aggregateRootId(), "No se encontraron coincidencias");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }


}
