package com.co.sofka.profesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.perfil.values.Cedula;
import com.co.sofka.profesional.domain.perfil.values.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.Perfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;

public class AgregarNuevaReferencia extends Command {

    private final Perfil perfil;
    private final ReferenciaId referenciaId;
    private final Cedula cedula;
    private final NombreCompleto nombreCompleto;
    private final InformacionContacto informacionContacto;

    public AgregarNuevaReferencia(Perfil perfil ,ReferenciaId referenciaId, Cedula id, NombreCompleto nombreCompleto, InformacionContacto informacionContacto) {
        this.perfil = perfil;
        this.referenciaId = referenciaId;
        this.cedula = id;
        this.nombreCompleto = nombreCompleto;
        this.informacionContacto = informacionContacto;
    }

    public Perfil getPerfil() {
        return perfil;
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
