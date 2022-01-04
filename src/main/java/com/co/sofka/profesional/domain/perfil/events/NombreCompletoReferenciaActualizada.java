package com.co.sofka.profesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;

import java.util.UUID;

public class NombreCompletoReferenciaActualizada extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;

    public NombreCompletoReferenciaActualizada(ReferenciaId referenciaId, NombreCompleto nombreCompleto) {
        super("sofka.perfil.nombrecompletoreferenciaactualizada");
        this.referenciaId = referenciaId;
        this.nombreCompleto = nombreCompleto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

}
