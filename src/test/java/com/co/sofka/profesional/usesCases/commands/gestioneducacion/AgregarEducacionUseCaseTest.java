package com.co.sofka.profesional.usesCases.commands.gestioneducacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;
import com.co.sofka.profesional.domain.gestioneducacion.commands.AgregarNuevaEducacion;
import com.co.sofka.profesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.co.sofka.profesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import com.co.sofka.profesional.domain.gestioneducacion.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEducacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarEducacionUseCaseTest(){
        IdGestionEducacion idGestionEducacion = IdGestionEducacion.of("xxxx");
        EducacionId educacionId = EducacionId.of("yyyy");
        TarjetaProfesional tarjetaProfesional = new TarjetaProfesional("y",true);
        Tipo tipo = new Tipo("Ingeniero");
        Estudio estudio = new Estudio("Informatica");
        Institucion institucion = new Institucion("SENA La Estrella");
        Periodo periodo = new Periodo("6");

        var command = new AgregarNuevaEducacion(idGestionEducacion,educacionId,tarjetaProfesional,tipo,estudio,institucion,periodo);
        var useCase = new AgregarEducacionUseCase();

        when(repository.getEventsBy(idGestionEducacion.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idGestionEducacion.toString())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        var event = (NuevaEducacionAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("y", event.getTarjetaProfesional().value().respuesta());
        Assertions.assertEquals("Ingeniero", event.getTipo().value());
        Assertions.assertEquals("Informatica", event.getEstudio().value());
        Assertions.assertEquals("SENA La Estrella", event.getInstitucion().value());
        Assertions.assertEquals("6", event.getPeriodo().value());
    }

    @Test
    void agregarEducacionUse_errorTarjetaObligatoria(){
        IdGestionEducacion idGestionEducacion = IdGestionEducacion.of("xxxx");
        EducacionId educacionId = EducacionId.of("yyyy");
        TarjetaProfesional tarjetaProfesional = new TarjetaProfesional("n",false);
        Tipo tipo = new Tipo("Ingeniero");
        Estudio estudio = new Estudio("Informatica");
        Institucion institucion = new Institucion("SENA La Estrella");
        Periodo periodo = new Periodo("6");

        var command = new AgregarNuevaEducacion(idGestionEducacion,educacionId,tarjetaProfesional,tipo,estudio,institucion,periodo);
        var useCase = new AgregarEducacionUseCase();

        when(repository.getEventsBy(idGestionEducacion.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(idGestionEducacion.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> eventList(){
        return List.of(new GestionEducacionCreada(new HojaDeVidaId("cvxxx")),
                new NuevaEducacionAgregada(EducacionId.of("xxxx"),
                        new TarjetaProfesional("y", true),
                        new Tipo("Ingeniero"),
                        new Estudio("Informatica"),
                        new Institucion("Politecnico JIC"),
                        new Periodo("6")
                ));
    }

}
