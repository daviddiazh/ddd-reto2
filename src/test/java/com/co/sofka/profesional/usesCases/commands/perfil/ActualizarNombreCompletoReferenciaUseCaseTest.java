package com.co.sofka.profesional.usesCases.commands.perfil;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.perfil.commands.ActualizarNombreCompletoReferencia;
import com.co.sofka.profesional.domain.perfil.events.NombreCompletoReferenciaActualizada;
import com.co.sofka.profesional.domain.perfil.events.NuevaReferenciaAgregada;
import com.co.sofka.profesional.domain.perfil.events.PerfilCreado;
import com.co.sofka.profesional.domain.perfil.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarNombreCompletoReferenciaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarNombreCompletoReferenciaUseCaseTest() {
        //Arrange
        IdPerfil idPerfil = IdPerfil.of("1");
        ReferenciaId referenciaId = ReferenciaId.of("xxxx");

        var command = new ActualizarNombreCompletoReferencia(idPerfil, referenciaId, new NombreCompleto("Diana Isabel"));
        var useCase = new ActualizarNombreCompletoReferenciaUseCase();

        //Act
        when(repository.getEventsBy(idPerfil.toString())).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPerfil.toString())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Assert
        var event = (NombreCompletoReferenciaActualizada)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.getReferenciaId().value());
        Assertions.assertEquals("Diana Isabel", event.getNombreCompleto().value());
    }

    private List<DomainEvent> eventList(){
        return List.of(new PerfilCreado(
                        new HojaDeVidaId("cvxxx"),
                        new InformacionContacto("3012254789"),
                        new FotoPerfil("https://miruta.com")
                ),
                new NuevaReferenciaAgregada(ReferenciaId.of("xxxx"),
                        new Cedula("1152700580"),
                        new NombreCompleto("Diana I"),
                        new InformacionContacto("3117878607")
                ));
    }

}