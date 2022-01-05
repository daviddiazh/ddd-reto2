package com.co.sofka.profesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.Entity;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;
import com.co.sofka.profesional.domain.gestioneducacion.values.EducacionId;
import com.co.sofka.profesional.domain.gestioneducacion.values.Estudio;
import com.co.sofka.profesional.domain.gestioneducacion.values.TarjetaProfesional;
import com.co.sofka.profesional.domain.gestioneducacion.values.Tipo;

import java.util.Objects;

public class Educacion extends Entity<EducacionId> {

    protected TarjetaProfesional tarjetaProfesional;
    protected Tipo tipo;
    protected Estudio estudio;
    protected Institucion institucion;
    protected Periodo periodo;

    public Educacion(EducacionId entityId, TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.tarjetaProfesional = tarjetaProfesional;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public void actualizarTipoEducacion(Tipo tipo){
        this.tipo = Objects.requireNonNull(tipo);
    }

    public TarjetaProfesional id() {
        return tarjetaProfesional;
    }

    public Tipo tipo() {
        return tipo;
    }

    public Estudio estudio() {
        return estudio;
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }

}