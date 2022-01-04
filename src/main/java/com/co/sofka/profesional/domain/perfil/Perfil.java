package com.co.sofka.profesional.domain.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.co.sofka.profesional.domain.generics.Cedula;
import com.co.sofka.profesional.domain.generics.HojaDeVidaId;
import com.co.sofka.profesional.domain.generics.NombreCompleto;
import com.co.sofka.profesional.domain.perfil.events.NombreCompletoReferenciaActualizada;
import com.co.sofka.profesional.domain.perfil.events.NuevaReferenciaAgregada;
import com.co.sofka.profesional.domain.perfil.events.PerfilCreado;
import com.co.sofka.profesional.domain.perfil.values.FotoPerfil;
import com.co.sofka.profesional.domain.perfil.values.IdPerfil;
import com.co.sofka.profesional.domain.perfil.values.InformacionContacto;
import com.co.sofka.profesional.domain.perfil.values.ReferenciaId;

import java.util.List;
import java.util.Objects;

public class Perfil extends AggregateEvent<IdPerfil> {

    protected HojaDeVidaId hojaDeVidaId;
    protected InformacionContacto informacionContacto;
    protected Cedula cedula;
    protected FotoPerfil fotoPerfil;
    protected Referencia referencia;


    public Perfil(IdPerfil entityId, HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil) {
        super(entityId);
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
        this.informacionContacto = Objects.requireNonNull(informacionContacto);
        this.fotoPerfil = Objects.requireNonNull(fotoPerfil);
        appendChange(new PerfilCreado(hojaDeVidaId, informacionContacto, fotoPerfil)).apply();
    }

    public Perfil(IdPerfil idPerfil) {
        super(idPerfil);
        subscribe(new PerfilChange(this));
    }

    public static Perfil from(IdPerfil entityId, List<DomainEvent> events){
        var paciente = new Perfil(entityId);
        events.forEach(paciente::applyEvent);
        return paciente;
    }

    public void agregarNuevaReferencia(Cedula cedula, NombreCompleto nombreCompleto, InformacionContacto informacionContacto){
        var id = new ReferenciaId();
        Objects.requireNonNull(cedula);
        Objects.requireNonNull(nombreCompleto);
        Objects.requireNonNull(informacionContacto);
        appendChange(new NuevaReferenciaAgregada(id, cedula, nombreCompleto, informacionContacto)).apply();
    }

    public void actualizarNombreCompletoReferencia(ReferenciaId referenciaId, NombreCompleto nombreCompleto){
        referenciaId = Objects.requireNonNull(referenciaId);
        nombreCompleto = Objects.requireNonNull(nombreCompleto);
        appendChange(new NombreCompletoReferenciaActualizada(referenciaId, nombreCompleto)).apply();
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public InformacionContacto informacionContacto() {
        return informacionContacto;
    }

    public Cedula cedula() {
        return cedula;
    }

    public FotoPerfil fotoPerfil() {
        return fotoPerfil;
    }

}
