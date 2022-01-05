package com.co.sofka.profesional.usesCases.events;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.co.sofka.profesional.domain.experiencia.events.ExperienciaCreada;
import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.usesCases.services.EnviarNotificacionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificarExperienciaCreadaExitosamenteUseCaseTest {

    @Mock
    EnviarNotificacionService notificacionService;

    @Test
    void notificarExperienciaCreadaExitosamenteUseCaseTest() {

        IdExperiencia experienciaId = IdExperiencia.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");

        var event = new ExperienciaCreada(hojaDeVidaId);
        event.setAggregateRootId(experienciaId.value());
        var useCase = new NotificarExperienciaCreadaExitosamenteUseCase();

        when(notificacionService.enviarExperiencia(
                "hola@sofkau.com",
                "Experiencia creada exitosamente.",
                experienciaId
        )).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(notificacionService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(notificacionService).enviarExperiencia(
                "hola@sofkau.com",
                "Experiencia creada exitosamente.",
                experienciaId
        );
    }

    @Test
    void notificarExperienciaCreada_error() {

        IdExperiencia experienciaId = IdExperiencia.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");

        var event = new ExperienciaCreada(hojaDeVidaId);
        event.setAggregateRootId(experienciaId.value());
        var useCase = new NotificarExperienciaCreadaExitosamenteUseCase();

        when(notificacionService.enviarExperiencia(
                "hola@sofkau.com",
                "Experiencia creada exitosamente.",
                experienciaId
        )).thenReturn(false);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(notificacionService);
        useCase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(useCase, new TriggeredEvent<>(event))
                    .orElseThrow();
        });
    }

}

