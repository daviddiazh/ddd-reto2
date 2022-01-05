package com.co.sofka.profesional.domain.experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.experiencia.events.ExperienciaCreada;
import com.co.sofka.profesional.domain.experiencia.events.NuevaExperienciaLaboralAgregada;
import com.co.sofka.profesional.domain.experiencia.events.PeriodoExperienciaLaboralActualizada;
import com.co.sofka.profesional.domain.experiencia.values.*;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Experiencia extends AggregateEvent<IdExperiencia> {

    protected ExperienciaLaboral experienciaLaboral;
    protected HojaDeVidaId hojaDeVidaId;

    public Experiencia(IdExperiencia entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
        appendChange(new ExperienciaCreada(hojaDeVidaId)).apply();
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
        var id = new IdExperienciaLaboral();
        Objects.requireNonNull(id);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        Objects.requireNonNull(conocimientosAdquiridos);
        appendChange(new NuevaExperienciaLaboralAgregada(id, institucion, periodo, conocimientosAdquiridos)).apply();
    }

    public void actualizarExperienciaLaboralPeriodo(IdExperienciaLaboral idExperienciaLaboral, Periodo periodo){
        var id = new IdExperienciaLaboral();
        Objects.requireNonNull(idExperienciaLaboral);
        Objects.requireNonNull(periodo);
        appendChange(new PeriodoExperienciaLaboralActualizada(idExperienciaLaboral, periodo)).apply();
    }


    public ExperienciaLaboral experienciaLaboral() {
        return experienciaLaboral;
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

}
