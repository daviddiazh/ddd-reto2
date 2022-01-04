package com.co.sofka.profesional.domain.gestioneducacion;

import co.com.sofka.domain.generic.EventChange;
import com.co.sofka.profesional.domain.gestioneducacion.events.GestionEducacionCreada;
import com.co.sofka.profesional.domain.gestioneducacion.events.NuevaEducacionAgregada;
import com.co.sofka.profesional.domain.gestioneducacion.events.TipoEducacionActualizada;

public class GestionEducacionChange extends EventChange {
    public GestionEducacionChange(GestionEducacion gestionEducacion) {

        apply((GestionEducacionCreada event)->{
            gestionEducacion.hojaDeVidaId = event.getHojaDeVidaId();
        });

        apply((NuevaEducacionAgregada event)->{
            gestionEducacion.educacion = new Educacion(
                    event.getId(),
                    event.getTarjetaProfesional(),
                    event.getTipo(),
                    event.getEstudio(),
                    event.getInstitucion(),
                    event.getPeriodo()
            );
        });

        apply((TipoEducacionActualizada event)->{
            gestionEducacion.educacion.tipo = event.getTipo();
        });

    }
}
