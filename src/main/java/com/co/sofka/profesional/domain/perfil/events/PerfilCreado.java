package com.co.sofka.profesional.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.Cedula;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.values.FotoPerfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;

import java.util.UUID;

public class PerfilCreado extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;
    private final InformacionContacto informacionContacto;
    private final NombreCompleto nombreCompleto;
    private final Cedula cedula;
    private final FotoPerfil fotoPerfil;


    public PerfilCreado(HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, NombreCompleto nombreCompleto, Cedula cedula, FotoPerfil fotoPerfil) {
        super("sofka.perfil.perfilcreado");
        this.hojaDeVidaId = hojaDeVidaId;
        this.informacionContacto = informacionContacto;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.fotoPerfil = fotoPerfil;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public FotoPerfil getFotoPerfil() {
        return fotoPerfil;
    }

}
