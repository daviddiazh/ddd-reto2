package com.co.sofka.profesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.perfil.values.Cedula;
import com.co.sofka.profesional.domain.perfil.values.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;

public class NuevaReferenciaAgregada extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final Cedula cedula;
    private final NombreCompleto nombreCompleto;
    private final InformacionContacto informacionContacto;

    public NuevaReferenciaAgregada(ReferenciaId referenciaId, Cedula cedula, NombreCompleto nombreCompleto, InformacionContacto informacionContacto) {
        super("sofka.perfil.nuevareferenciaagregada");
        this.referenciaId = referenciaId;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.informacionContacto = informacionContacto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

}
