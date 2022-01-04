package com.co.sofka.profesional.domain.perfil;

import co.com.sofka.domain.generic.Entity;
import com.co.sofka.profesional.domain.generics.Cedula;
import com.co.sofka.profesional.domain.generics.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;

import java.util.Objects;

public class Referencia extends Entity<ReferenciaId> {

    protected Cedula cedula;
    protected NombreCompleto nombreCompleto;
    protected InformacionContacto informacionContacto;

    public Referencia(ReferenciaId entityId, Cedula cedula, NombreCompleto nombreCompleto, InformacionContacto informacionContacto) {
        super(entityId);
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.informacionContacto = informacionContacto;
    }

    public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }


}
