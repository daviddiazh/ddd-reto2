package com.co.sofka.profesional.domain.gestioneducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;
import com.co.sofka.profesional.domain.gestioneducacion.values.*;

public class AgregarNuevaEducacion extends Command {

    private final IdGestionEducacion idGestionEducacion;
    private final EducacionId educacionId;
    private final TarjetaProfesional tarjetaProfesional;
    private final Tipo tipo;
    private final Estudio estudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public AgregarNuevaEducacion(IdGestionEducacion idGestionEducacion, EducacionId educacionId, TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        this.idGestionEducacion = idGestionEducacion;
        this.educacionId = educacionId;
        this.tarjetaProfesional = tarjetaProfesional;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public IdGestionEducacion getGestionEducacionId() {
        return idGestionEducacion;
    }

    public EducacionId getEducacionId() {
        return educacionId;
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
