package br.ETS.Feedback200.model.instrutor.dto;

import br.ETS.Feedback200.model.instrutor.Curso;
import br.ETS.Feedback200.model.instrutor.Instrutor;

public record ListInstrutorDTO(int id,
                               String nome,
                               String email,
                               String edv,
                               boolean ferias,
                               Curso curso) {

    public ListInstrutorDTO(Instrutor instrutor) {
        this(
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.isFerias(),
                instrutor.getCurso()
        );
    }
}
