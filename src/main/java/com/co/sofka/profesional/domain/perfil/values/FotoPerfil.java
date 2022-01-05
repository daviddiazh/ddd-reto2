package com.co.sofka.profesional.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FotoPerfil implements ValueObject<String> {

    private final String path;

    public FotoPerfil(String path) {
        this.path = Objects.requireNonNull(path);
        if(path.isBlank()){
            throw new IllegalArgumentException("La ruta no puede estar vacía.");
        }
        if(!path.contains("https://")){
            throw new IllegalArgumentException("La URL debe contener el protocolo HTTPS");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoPerfil that = (FotoPerfil) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    @Override
    public String value() {
        return path;
    }

}
