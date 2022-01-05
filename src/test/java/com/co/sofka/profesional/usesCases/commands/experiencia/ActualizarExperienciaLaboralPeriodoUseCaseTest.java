package com.co.sofka.profesional.usesCases.commands.experiencia;

import co.com.sofka.business.generic.BusinessException;
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
        IdExperiencia idExperiencia;
        idExperiencia = IdExperiencia.of("1");

        IdExperienciaLaboral idExperienciaLaboral;
        idExperienciaLaboral = IdExperienciaLaboral.of("xxxx");

        var command = new ActualizarExperienciaLaboralPeriodo(idExperiencia, idExperienciaLaboral, new Periodo("3"));
        var useCase = new ActualizarExperienciaLaboralPeriodoUseCase();

        //Act
        when(repository.getEventsBy(idExperiencia.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idExperiencia.toString())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Assert
        var event =  (PeriodoExperienciaLaboralActualizada)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.getIdExperienciaLaboral().value());
        Assertions.assertEquals("3", event.getPeriodo().value());
    }

    @Test
    void actualizarExperienciaLaboralPeriodo_errorPeriodoMuyLargo() {
        //Arrange
        IdExperiencia idExperiencia;
        idExperiencia = IdExperiencia.of("1");

        IdExperienciaLaboral idExperienciaLaboral;
        idExperienciaLaboral = IdExperienciaLaboral.of("xxxx");

        var command = new ActualizarExperienciaLaboralPeriodo(idExperiencia, idExperienciaLaboral, new Periodo("1000"));
        var useCase = new ActualizarExperienciaLaboralPeriodoUseCase();

        //Act
        when(repository.getEventsBy(idExperiencia.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(idExperiencia.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> eventList(){
        return List.of(new ExperienciaCreada(new HojaDeVidaId("cvxxx")),
                new NuevaExperienciaLaboralAgregada(IdExperienciaLaboral.of("xxxx"),
                        new Institucion("SofkaU"),
                        new Periodo("1"),
                        new ConocimientosAdquiridos("Programacion")
                ));
    }

}
