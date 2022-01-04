package com.co.sofka.profesional.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.gestioneducacion.values.EducacionId;
import com.co.sofka.profesional.domain.gestioneducacion.values.Tipo;

public class TipoEducacionActualizada extends DomainEvent {
    private EducacionId educacionId;
    private Tipo tipo;

    public TipoEducacionActualizada(EducacionId educacionId, Tipo tipo) {
        super("sofka.gestioneducacion.tipoeducacionactualizada");
        this.educacionId = educacionId;
        this.tipo = tipo;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
