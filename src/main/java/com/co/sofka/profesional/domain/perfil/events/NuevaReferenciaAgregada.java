package com.co.sofka.profesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.Cedula;
import com.co.sofka.profesional.domain.generics.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;

import java.util.UUID;

public class NuevaReferenciaAgregada extends DomainEvent {

    private final Cedula id;
    private final NombreCompleto nombreCompleto;
    private final InformacionContacto informacionContacto;

    public NuevaReferenciaAgregada(String aggregateRootId, String aggregateParentId, UUID uuid, Cedula id, NombreCompleto nombreCompleto, InformacionContacto informacionContacto) {
        super("sofka.perfil.nuevareferenciaagregada");
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.informacionContacto = informacionContacto;
    }

    public Cedula getId() {
        return id;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

}
