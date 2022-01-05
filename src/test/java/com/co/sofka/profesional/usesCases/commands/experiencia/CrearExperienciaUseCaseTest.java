package com.co.sofka.profesional.usesCases.commands.experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.co.sofka.profesional.domain.experiencia.commands.CrearExperiencia;
import com.co.sofka.profesional.domain.experiencia.events.ExperienciaCreada;
import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearExperienciaUseCaseTest {

    @Test
    void crearExperienciaUseCaseTest() {
        //Arrange
        IdExperiencia idExperiencia = IdExperiencia.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");

        var command = new CrearExperiencia(idExperiencia, hojaDeVidaId);
        var useCase = new CrearExperienciaUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts
        ExperienciaCreada event = (ExperienciaCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("cvxxx", event.getHojaDeVidaId().value());
    }

}