package com.co.sofka.profesional.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.experiencia.values.*;

import java.util.Set;

public class NuevaExperienciaLaboralAgregada extends DomainEvent {

    private IdExperienciaLaboral id;
    private Institucion institucion;
    private Periodo periodo;
    private Set<ConocimientosAdquiridos> conocimientosAdquiridos;

    public NuevaExperienciaLaboralAgregada(IdExperienciaLaboral id, Institucion institucion, Periodo periodo, Set<ConocimientosAdquiridos> conocimientosAdquiridos) {
        super("sofka.experiencia.nuevaexperiencialaboralagregada");
        this.id = id;
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }

    public IdExperienciaLaboral getId() {
        return id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Set<ConocimientosAdquiridos> getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
