package com.co.sofka.profesional.domain.experiencia;

import co.com.sofka.domain.generic.Entity;
import com.co.sofka.profesional.domain.experiencia.values.ConocimientosAdquiridos;
import com.co.sofka.profesional.domain.experiencia.values.IdExperienciaLaboral;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;

import java.util.Objects;
import java.util.Set;

public class ExperienciaLaboral extends Entity<IdExperienciaLaboral> {

    protected Institucion institucion;
    protected Periodo periodo;
    protected Set<ConocimientosAdquiridos> conocimientosAdquiridos;

    public ExperienciaLaboral(IdExperienciaLaboral entityId, Institucion institucion, Periodo periodo, Set<ConocimientosAdquiridos> conocimientosAdquiridos) {
        super(entityId);
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }

    public void actualizarPeriodo (Periodo periodo){
        Objects.requireNonNull(periodo);
        this.periodo = periodo;
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }

    public Set<ConocimientosAdquiridos> conocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}