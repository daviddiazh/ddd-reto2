package com.co.sofka.profesional.domain.experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Identity;
import com.co.sofka.profesional.domain.experiencia.values.*;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.perfil.Perfil;
import com.co.sofka.profesional.domain.perfil.PerfilChange;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;

import java.util.List;
import java.util.Objects;

public class Experiencia extends AggregateEvent<IdExperiencia> {

    protected ExperienciaLaboral experienciaLaboral;
    protected HojaDeVidaId hojaDeVidaId;

    public Experiencia(IdExperiencia entityId, ExperienciaLaboral experienciaLaboral, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        this.experienciaLaboral = Objects.requireNonNull(experienciaLaboral);
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
    }

    public Experiencia(IdExperiencia idExperiencia) {
        super(idExperiencia);
        subscribe(new ExperienciaChange(this));
    }

    public static Experiencia from(IdExperiencia entityId, List<DomainEvent> events){
        var experiencia = new Experiencia(entityId);
        events.forEach(experiencia::applyEvent);
        return experiencia;
    }

    public void agregarExperienciaLaboral(Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos){
        var id = new IdExperiencia();
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        Objects.requireNonNull(conocimientosAdquiridos);
    }

    public void actualizarExperienciaLaboralPeriodo(IdExperienciaLaboral idExperienciaLaboral, Periodo periodo){
        var id = new IdExperienciaLaboral();
        Objects.requireNonNull(idExperienciaLaboral);
        Objects.requireNonNull(periodo);
    }


    public ExperienciaLaboral experienciaLaboral() {
        return experienciaLaboral;
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

}
