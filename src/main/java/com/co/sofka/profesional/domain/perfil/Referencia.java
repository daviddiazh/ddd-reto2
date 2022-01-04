package com.co.sofka.profesional.domain.perfil;

import co.com.sofka.domain.generic.Entity;
import com.co.sofka.profesional.domain.generics.Cedula;
import com.co.sofka.profesional.domain.generics.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;

public class Referencia extends Entity<ReferenciaId> {

    protected Cedula id;
    protected NombreCompleto nombreCompleto;
    protected InformacionContacto informacionContacto;

    public Referencia(ReferenciaId entityId) {
        super(entityId);
    }

}
