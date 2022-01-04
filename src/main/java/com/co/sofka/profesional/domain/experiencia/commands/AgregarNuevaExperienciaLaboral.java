package com.co.sofka.profesional.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;
import com.co.sofka.profesional.domain.experiencia.values.IdExperienciaLaboral;
import com.co.sofka.profesional.domain.generics.Institucion;
import com.co.sofka.profesional.domain.generics.Periodo;

public class AgregarNuevaExperienciaLaboral extends Command {

    private final IdExperiencia idExperiencia;
    private final IdExperienciaLaboral idExperienciaLaboral;
    private final Periodo periodo;
    private final Institucion institucion;

    public AgregarNuevaExperienciaLaboral(IdExperiencia idExperiencia, IdExperienciaLaboral idExperienciaLaboral, Periodo periodo, Institucion institucion) {
        this.idExperiencia = idExperiencia;
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.periodo = periodo;
        this.institucion = institucion;
    }

    public IdExperiencia getIdExperiencia() {
        return idExperiencia;
    }

    public IdExperienciaLaboral getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

}
