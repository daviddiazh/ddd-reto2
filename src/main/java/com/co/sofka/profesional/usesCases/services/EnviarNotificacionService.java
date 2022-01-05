package com.co.sofka.profesional.usesCases.services;

import com.co.sofka.profesional.domain.experiencia.values.IdExperiencia;
import com.co.sofka.profesional.domain.perfil.Perfil;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;

public interface EnviarNotificacionService {

    boolean enviar(String correo, String descripcion, IdPerfil idPerfil);
    Boolean enviarExperiencia(String correo, String descripcion, IdExperiencia idExperiencia);

}
