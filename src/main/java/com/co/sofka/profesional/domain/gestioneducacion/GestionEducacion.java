package com.co.sofka.profesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.gestioneducacion.events.GestionEducacionCreado;
import com.co.sofka.profesional.domain.gestioneducacion.values.EducacionId;
import com.co.sofka.profesional.domain.gestioneducacion.values.IdGestionEducacion;
import com.co.sofka.profesional.domain.perfil.Perfil;
import com.co.sofka.profesional.domain.perfil.PerfilChange;
import com.co.sofka.profesional.domain.perfil.events.PerfilCreado;
import com.co.sofka.profesional.domain.perfil.values.FotoPerfil;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;

import java.util.List;
import java.util.Objects;

public class GestionEducacion extends AggregateEvent<IdGestionEducacion> {

    protected HojaDeVidaId hojaDeVidaId;
    protected Educacion educacion;

    public GestionEducacion(IdGestionEducacion entityId, HojaDeVidaId hojaDeVidaId, Educacion educacion) {
        super(entityId);
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
        this.educacion = Objects.requireNonNull(educacion);
        appendChange(new GestionEducacionCreado(hojaDeVidaId, educacion)).apply();
    }

    public GestionEducacion(IdGestionEducacion idGestionEducacion) {
        super(idGestionEducacion);
        subscribe(new GestionEducacionChange(this));
    }

    public static Perfil from(IdGestionEducacion entityId, List<DomainEvent> events){
        var gestionEducacion = new GestionEducacion(entityId);
        events.forEach(gestionEducacion::applyEvent);
        return gestionEducacion;
    }



    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public Educacion educacion() {
        return educacion;
    }

}
