package com.co.sofka.profesional.usesCases.events;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;
import com.co.sofka.profesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.co.sofka.profesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import com.co.sofka.profesional.domain.gestioneducacion.values.*;
import com.co.sofka.profesional.usesCases.services.FiltrarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FiltrarEducacionUseCaseTest {

    @Mock
    FiltrarService filtrarService;

    @Mock
    DomainEventRepository repository;

    @Test
    void filtrarEducacionUseCaseTest() {

        IdGestionEducacion gestionEducacionId = IdGestionEducacion.of("xxxx");
        EducacionId educacionId = EducacionId.of("yyyy");
        TarjetaProfesional tarjetaProfesional = new TarjetaProfesional("y",true);
        Tipo tipo = new Tipo("profesional");
        Estudio estudio = new Estudio("Ingeniería");
        Institucion institucion = new Institucion("Politecnico JIC");
        Periodo periodo = new Periodo("7");

        var event = new NuevaEducacionAgregada(educacionId,tarjetaProfesional,tipo,estudio,institucion,periodo);
        event.setAggregateRootId(gestionEducacionId.value());
        var useCase = new FiltrarEducacionUseCase();

        when(filtrarService.filtrar(
                estudio,
                estudio,
                gestionEducacionId
        )).thenReturn(true);


        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(filtrarService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(gestionEducacionId.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(filtrarService).filtrar(
                estudio,
                estudio,
                gestionEducacionId
        );
    }

    @Test
    void filtrarEducacionUseCaseTest_errorFiltro() {

        IdGestionEducacion gestionEducacionId = IdGestionEducacion.of("xxxx");
        EducacionId educacionId = EducacionId.of("yyyy");
        TarjetaProfesional tarjetaProfesional = new TarjetaProfesional("y",true);
        Tipo tipo = new Tipo("profesional");
        Estudio estudio = new Estudio("Ingeniería");
        Institucion institucion = new Institucion("Politecnico JIC");
        Periodo periodo = new Periodo("7");

        var event = new NuevaEducacionAgregada(educacionId,tarjetaProfesional,tipo,estudio,institucion,periodo);
        event.setAggregateRootId(gestionEducacionId.value());
        var useCase = new FiltrarEducacionUseCase();

        when(filtrarService.filtrar(
                estudio,
                estudio,
                gestionEducacionId
        )).thenReturn(false);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(filtrarService);
        useCase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(gestionEducacionId.value())
                    .syncExecutor(useCase, new TriggeredEvent<>(event))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> eventList(){
        return List.of(new GestionEducacionCreada(new HojaDeVidaId("cvxxx")),
                new NuevaEducacionAgregada(EducacionId.of("xxxx"),
                        new TarjetaProfesional("y", true),
                        new Tipo("Tecnico"),
                        new Estudio("Ingeniería"),
                        new Institucion("Politecnico JIC"),
                        new Periodo("6")
                ));
    }

}
