package com.co.sofka.profesional.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;
import com.co.sofka.profesional.domain.gestioneducacion.values.EducacionId;
import com.co.sofka.profesional.domain.gestioneducacion.values.Estudio;
import com.co.sofka.profesional.domain.gestioneducacion.values.TarjetaProfesional;
import com.co.sofka.profesional.domain.gestioneducacion.values.Tipo;

public class NuevaEducacionAgregada extends DomainEvent {

    private EducacionId id;
    private TarjetaProfesional tarjetaProfesional;
    private Tipo tipo;
    private Estudio estudio;
    private Institucion institucion;
    private Periodo periodo;

    public NuevaEducacionAgregada(EducacionId id, TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super("sofka.gestioneducacion.educacionagregada");
        this.id = id;
        this.tarjetaProfesional = tarjetaProfesional;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public EducacionId getId() {
        return id;
    }

    public TarjetaProfesional getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

}
