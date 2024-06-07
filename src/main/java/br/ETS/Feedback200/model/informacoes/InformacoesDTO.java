package br.ETS.Feedback200.model.informacoes;

import jakarta.validation.constraints.NotBlank;

public record InformacoesDTO(@NotBlank String disciplina,
                             @NotBlank String trilha,
                             @NotBlank String faculdade,
                             @NotBlank String turma) {
    public InformacoesDTO(Informacoes informacoes) {
        this(informacoes.getDisciplina(), informacoes.getTrilha(), informacoes.getFaculdade(), informacoes.getTurma());
    }
}
