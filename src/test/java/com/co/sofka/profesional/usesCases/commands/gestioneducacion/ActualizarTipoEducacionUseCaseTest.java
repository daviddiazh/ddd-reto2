package com.co.sofka.profesional.usesCases.commands.gestioneducacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.experiencia.Experiencia;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;
import com.co.sofka.profesional.domain.gestioneducacion.commands.ActualizarTipoEducacion;
import com.co.sofka.profesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.co.sofka.profesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import com.co.sofka.profesional.domain.gestioneducacion.events.TipoEducacionActualizada;
import com.co.sofka.profesional.domain.gestioneducacion.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ActualizarTipoEducacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarTipoEducacionUseCaseTest() {
        //Arrange
        IdGestionEducacion gestionEducacionId = IdGestionEducacion.of("1");
        EducacionId educacionId = EducacionId.of("xxxx");

        var command = new ActualizarTipoEducacion(gestionEducacionId, educacionId, new Tipo("Profesional"));
        var useCase = new ActualizarTipoEducacionUseCase();

        //Act
        when(repository.getEventsBy(gestionEducacionId.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(gestionEducacionId.toString())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Assert
        var event = (TipoEducacionActualizada)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.getEducacionId().value());
        Assertions.assertEquals("Profesional", event.getTipo().value());
    }

    private List<DomainEvent> eventList(){
        return List.of(new GestionEducacionCreada(new HojaDeVidaId("cvxxx")),
                new NuevaEducacionAgregada(EducacionId.of("xxxx"),
                        new TarjetaProfesional("y", true),
                        new Tipo("Tecnico"),
                        new Estudio("Informatica"),
                        new Institucion("Universidad de Antioquia"),
                        new Periodo("2021/01/01 - 2019/01/01")
                ));
    }

}
