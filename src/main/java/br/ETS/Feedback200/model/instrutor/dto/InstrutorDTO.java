package br.ETS.Feedback200.model.instrutor.dto;

import br.ETS.Feedback200.model.informacoes.Informacoes;
import br.ETS.Feedback200.model.informacoes.InformacoesDTO;
import br.ETS.Feedback200.model.instrutor.Curso;
import br.ETS.Feedback200.model.instrutor.Instrutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record InstrutorDTO(@NotBlank String nome,
                           @NotBlank @Email String email,
                           @NotBlank @Pattern(regexp = "^\\d{8}$") String edv,
                           @NotNull Curso curso,
                           @NotNull @Valid InformacoesDTO informacoes,
                           @NotNull boolean ferias) {
    public InstrutorDTO(Instrutor instrutor) {
        this(
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.getCurso(),
                new InformacoesDTO(instrutor.getInformacoes()),
                instrutor.isFerias()
        );
    }

}
