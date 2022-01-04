package com.co.sofka.profesional.domain.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;

public class Perfil extends AggregateEvent<IdPerfil> {

    public Perfil(IdPerfil entityId) {
        super(entityId);
    }

}
