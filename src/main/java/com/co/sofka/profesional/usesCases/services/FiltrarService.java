package com.co.sofka.profesional.usesCases.services;

import com.co.sofka.profesional.domain.gestioneducacion.values.Estudio;
import com.co.sofka.profesional.domain.gestioneducacion.values.IdGestionEducacion;

public interface FiltrarService {

    Boolean filtrar(Estudio busqueda, Estudio buscado, IdGestionEducacion gestionEducacionId);

}
