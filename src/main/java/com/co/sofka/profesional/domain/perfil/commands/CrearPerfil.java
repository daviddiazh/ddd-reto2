package com.co.sofka.profesional.domain.perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.perfil.values.Cedula;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.perfil.values.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.FotoPerfil;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;

public class CrearPerfil extends Command {

    private final IdPerfil idPerfil;
    private final HojaDeVidaId hojaDeVidaId;
    private final InformacionContacto informacionContacto;
    private final FotoPerfil fotoPerfil;

    public CrearPerfil(IdPerfil idPerfil, HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil) {
        this.idPerfil = idPerfil;
        this.hojaDeVidaId = hojaDeVidaId;
        this.informacionContacto = informacionContacto;
        this.fotoPerfil = fotoPerfil;
    }

    public IdPerfil getIdPerfil() {
        return idPerfil;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public FotoPerfil getFotoPerfil() {
        return fotoPerfil;
    }

}
