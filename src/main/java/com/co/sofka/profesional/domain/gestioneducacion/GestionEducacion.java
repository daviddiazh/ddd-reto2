package com.co.sofka.profesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;
import com.co.sofka.profesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.co.sofka.profesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import com.co.sofka.profesional.domain.gestioneducacion.events.TipoEducacionActualizada;
import com.co.sofka.profesional.domain.gestioneducacion.values.*;
import com.co.sofka.profesional.domain.perfil.Perfil;
import com.co.sofka.profesional.domain.perfil.PerfilChange;
import com.co.sofka.profesional.domain.perfil.events.PerfilCreado;
import com.co.sofka.profesional.domain.perfil.values.FotoPerfil;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;

import java.util.List;
import java.util.Objects;

public class GestionEducacion extends AggregateEvent<IdGestionEducacion> {

    protected Educacion educacion;
    protected HojaDeVidaId hojaDeVidaId;

    public GestionEducacion(IdGestionEducacion entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
        appendChange(new GestionEducacionCreada(hojaDeVidaId)).apply();
    }

    public GestionEducacion(IdGestionEducacion gestionEducacionId) {
        super(gestionEducacionId);
        subscribe(new GestionEducacionChange(this));
    }

    public static GestionEducacion from(IdGestionEducacion entityId, List<DomainEvent> events){
        var gestionEducacion = new GestionEducacion(entityId);
        events.forEach(gestionEducacion::applyEvent);
        return gestionEducacion;
    }

    public void agregarNuevaEducacion(TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        var id = new EducacionId();
        Objects.requireNonNull(tarjetaProfesional);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(estudio);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new NuevaEducacionAgregada(id, tarjetaProfesional, tipo, estudio, institucion, periodo)).apply();
    }

    public void actualizarTipoEducacion(EducacionId educacionId, Tipo tipo){
        Objects.requireNonNull(educacionId);
        Objects.requireNonNull(tipo);
        appendChange(new TipoEducacionActualizada(educacionId, tipo)).apply();
    }

    public Educacion educacion() {
        return educacion;
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

}

