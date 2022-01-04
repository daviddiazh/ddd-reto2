package com.co.sofka.profesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.generics.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.Referencia;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;

public class ActualizarNombreCompletoReferencia extends Command {

    private final IdPerfil idPerfil;
    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreCompletoReferencia(IdPerfil idPerfil, ReferenciaId referenciaId, NombreCompleto nombreCompleto) {
        this.idPerfil = idPerfil;
        this.referenciaId = referenciaId;
        this.nombreCompleto = nombreCompleto;
    }

    public IdPerfil getIdPerfil() {
        return idPerfil;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

}
