package com.co.sofka.profesional.usesCases.commands.gestioneducacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.gestioneducacion.commands.CrearGestionEducacion;
import com.co.sofka.profesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.co.sofka.profesional.domain.gestioneducacion.values.IdGestionEducacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearGestionEducacionUseCaseTest {

    @Test
    void crearGestionEducacionUseCaseTest() {
        //Arrange
        IdGestionEducacion idGestionEducacion = IdGestionEducacion.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");

        var command = new CrearGestionEducacion(idGestionEducacion, hojaDeVidaId);
        var useCase = new CrearGestionEducacionUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts
        GestionEducacionCreada event = (GestionEducacionCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("cvxxx", event.getHojaDeVidaId().value());
    }

}
