package com.co.sofka.profesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.generics.Cedula;
import com.co.sofka.profesional.domain.generics.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;

public class AgregarNuevaReferencia extends Command {

    private final ReferenciaId referenciaId;
    private final Cedula id;
    private final NombreCompleto nombreCompleto;
    private final InformacionContacto informacionContacto;

    public AgregarNuevaReferencia(ReferenciaId referenciaId, Cedula id, NombreCompleto nombreCompleto, InformacionContacto informacionContacto) {
        this.referenciaId = referenciaId;
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.informacionContacto = informacionContacto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
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
