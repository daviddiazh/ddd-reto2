package com.co.sofka.profesional.domain.perfil;

import co.com.sofka.domain.generic.EventChange;
import com.co.sofka.profesional.domain.perfil.events.NombreCompletoReferenciaActualizada;
import com.co.sofka.profesional.domain.perfil.events.NuevaReferenciaAgregada;
import com.co.sofka.profesional.domain.perfil.events.PerfilCreado;

public class PerfilChange extends EventChange {

    public PerfilChange(Perfil perfil){

        apply((PerfilCreado event)-> {
            perfil.hojaDeVidaId = event.getHojaDeVidaId();
            perfil.informacionContacto = event.getInformacionContacto();
            perfil.fotoPerfil = event.getFotoPerfil();
        });

        apply((NuevaReferenciaAgregada event) -> {
            perfil.referencia = new Referencia(event.getReferenciaId(), event.getCedula(), event.getNombreCompleto(), event.getInformacionContacto());
        });

        apply((NombreCompletoReferenciaActualizada event) -> {
            perfil.referencia.nombreCompleto = event.getNombreCompleto();
        });

    }

}
