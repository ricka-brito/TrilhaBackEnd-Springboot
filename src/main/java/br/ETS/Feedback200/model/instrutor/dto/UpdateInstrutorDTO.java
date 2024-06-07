package br.ETS.Feedback200.model.instrutor.dto;

import br.ETS.Feedback200.model.informacoes.InformacoesDTO;
import br.ETS.Feedback200.model.instrutor.Curso;
import jakarta.validation.constraints.NotNull;

public record UpdateInstrutorDTO(@NotNull int id,
                                 String nome,
                                 String email,
                                 String edv,
                                 Curso curso,
                                 boolean ferias,

                                 InformacoesDTO informacoes

){
}
