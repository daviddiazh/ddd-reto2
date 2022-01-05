package com.co.sofka.profesional.usesCases.commands.perfil;

import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;
import org.junit.jupiter.api.Test;

public class CrearPerfilUseCaseTest {

    @Test
    void crearPerfilUseCaseTest(){

        //Arrange
        IdPerfil idPerfil = IdPerfil.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");
        InformacionContacto informacionContacto = new InformacionContacto("");

    }

}
