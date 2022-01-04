package com.co.sofka.profesional.domain.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import com.co.sofka.profesional.domain.generics.Cedula;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.FotoPerfil;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;

public class Perfil extends AggregateEvent<IdPerfil> {

    protected HojaDeVidaId hojaDeVidaId;
    protected InformacionContacto informacionContacto;
    protected NombreCompleto nombreCompleto;
    protected Cedula cedula;
    protected FotoPerfil fotoPerfil;

    public Perfil(IdPerfil entityId) {
        super(entityId);
    }

}
