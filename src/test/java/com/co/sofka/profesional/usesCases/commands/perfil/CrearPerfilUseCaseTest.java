package com.co.sofka.profesional.usesCases.commands.perfil;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.perfil.commands.CrearPerfil;
import com.co.sofka.profesional.domain.perfil.events.PerfilCreado;
import com.co.sofka.profesional.domain.perfil.values.FotoPerfil;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrearPerfilUseCaseTest {

    @Test
    void crearPerfilUseCaseTest(){

        //Arrange
        IdPerfil idPerfil = IdPerfil.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");
        InformacionContacto informacionContacto = new InformacionContacto("123456789");
        FotoPerfil fotoPerfil = new FotoPerfil("https://mipath.com");

        var command = new CrearPerfil(idPerfil, hojaDeVidaId, informacionContacto, fotoPerfil);
        var useCase = new CrearPerfilUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts
        PerfilCreado event = (PerfilCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("cvxxx", event.getHojaDeVidaId().value());
        Assertions.assertEquals("123456789", event.getInformacionContacto().value());
        Assertions.assertEquals("https://mipath.com", event.getFotoPerfil().value());

    }

    @Test
    void crearPerfil_errorFotoDePerfil(){
        //Arrange
        IdPerfil idPerfil = IdPerfil.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");
        InformacionContacto informacionContacto = new InformacionContacto("123456789");
        FotoPerfil fotoPerfil = new FotoPerfil("C:/Users/123/foto");

        var command = new CrearPerfil(idPerfil, hojaDeVidaId, informacionContacto, fotoPerfil);
        var useCase = new CrearPerfilUseCase();

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(idPerfil.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

}
