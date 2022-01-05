package com.co.sofka.profesional.usesCases.events;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.perfil.events.PerfilCreado;
import com.co.sofka.profesional.domain.perfil.values.FotoPerfil;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;
import com.co.sofka.profesional.usesCases.services.EnviarNotificacionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotificarPerfilCreadoExitosamenteUseCaseTest {

    @Mock
    EnviarNotificacionService notificacionService;

    @Test
    void notificarPerfilCreadoExitosamenteUseCaseTest(){

        IdPerfil idPerfil = IdPerfil.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");
        InformacionContacto informacionContacto = new InformacionContacto("123456789");
        FotoPerfil fotoPerfil = new FotoPerfil("https://mipath.com");

        var event = new PerfilCreado(hojaDeVidaId, informacionContacto, fotoPerfil);
        event.setAggregateRootId(idPerfil.value());
        var useCase = new NotificarPerfilCreadoExitosamenteUseCase();

        when(notificacionService.enviar(
                "hola@sofkau.com",
                "Perfil creado exitosamente.",
                idPerfil
        )).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(notificacionService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(notificacionService).enviar(
                "hola@sofkau.com",
                "Perfil creado exitosamente.",
                idPerfil
        );

    }


    @Test
    void notificarPerfil_error() {

        IdPerfil idPerfil = IdPerfil.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");
        InformacionContacto informacionContacto = new InformacionContacto("3001112233");
        FotoPerfil fotoPerfil = new FotoPerfil("https://mipath.com");

        var event = new PerfilCreado(hojaDeVidaId,informacionContacto,fotoPerfil);
        event.setAggregateRootId(idPerfil.value());
        var useCase = new NotificarPerfilCreadoExitosamenteUseCase();

        when(notificacionService.enviar(
                "hola@sofkau.com",
                "Perfil creado exitosamente.",
                idPerfil
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
