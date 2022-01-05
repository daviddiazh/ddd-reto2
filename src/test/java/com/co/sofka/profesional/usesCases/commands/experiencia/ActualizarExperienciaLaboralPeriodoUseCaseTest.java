package com.co.sofka.profesional.usesCases.commands.experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.experiencia.commands.ActualizarExperienciaLaboralPeriodo;
import com.co.sofka.profesional.domain.experiencia.events.ExperienciaCreada;
import com.co.sofka.profesional.domain.experiencia.events.NuevaExperienciaLaboralAgregada;
import com.co.sofka.profesional.domain.experiencia.events.PeriodoExperienciaLaboralActualizada;
import com.co.sofka.profesional.domain.experiencia.values.ConocimientosAdquiridos;
import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;
import com.co.sofka.profesional.domain.experiencia.values.IdExperienciaLaboral;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ActualizarExperienciaLaboralPeriodoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarExperienciaLaboralPeriodoUseCaseTest() {
        //Arrange
        IdExperiencia experienciaId;
        experienciaId = IdExperiencia.of("1");

        IdExperienciaLaboral experienciaLaboralId;
        experienciaLaboralId = IdExperienciaLaboral.of("xxxx");

        var command = new ActualizarExperienciaLaboralPeriodo(experienciaId, experienciaLaboralId, new Periodo("2021/02/02 - 2021/12/31"));
        var useCase = new ActualizarExperienciaLaboralPeriodoUseCase();

        //Act
        when(repository.getEventsBy(experienciaId.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(experienciaId.toString())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Assert
        var event =  (PeriodoExperienciaLaboralActualizada)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.getIdExperienciaLaboral().value());
        Assertions.assertEquals("2021/02/02 - 2021/12/31", event.getPeriodo().value());
    }

    private List<DomainEvent> eventList(){
        return List.of(new ExperienciaCreada(new HojaDeVidaId("cvxxx")),
                new NuevaExperienciaLaboralAgregada(IdExperienciaLaboral.of("xxxx"),
                        new Institucion("Play the kids"),
                        new Periodo("2021/01/01 - 2021/12/31"),
                        new ConocimientosAdquiridos("Asesor ventas")
                ));
    }

}