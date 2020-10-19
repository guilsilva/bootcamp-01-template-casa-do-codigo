package br.com.bootcamp.casadocodigo.api.handler;

import lombok.Getter;

import java.util.Collection;

public class ErrorMessage {
    @Getter
    private Collection<String> mensagens;

    public ErrorMessage(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }
}
