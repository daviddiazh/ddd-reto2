package com.co.sofka.profesional.domain.perfil;

import co.com.sofka.domain.generic.Entity;
import com.co.sofka.profesional.domain.perfil.values.Cedula;
import com.co.sofka.profesional.domain.perfil.values.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;

public class Referencia extends Entity<ReferenciaId> {

    protected Cedula id;
    protected NombreCompleto nombreCompleto;

    public Referencia(ReferenciaId entityId) {
        super(entityId);
    }

}