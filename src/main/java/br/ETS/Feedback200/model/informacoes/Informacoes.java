package br.ETS.Feedback200.model.informacoes;
import br.ETS.Feedback200.model.instrutor.Curso;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Informacoes {
    private String disciplina;
    private String trilha;
    private String faculdade;
    private String turma;


    public Informacoes(InformacoesDTO informacoesDTO) {
        this.disciplina = informacoesDTO.disciplina();
        this.faculdade = informacoesDTO.faculdade();
        this.trilha = informacoesDTO.trilha();
        this.turma = informacoesDTO.turma();
    }

    public void atualizar(InformacoesDTO informacoesDTO) {
        this.disciplina = informacoesDTO.disciplina() != null ? informacoesDTO.disciplina() : this.disciplina;
        this.trilha = informacoesDTO.trilha() != null ? informacoesDTO.trilha() : this.trilha;
        this.faculdade = informacoesDTO.faculdade() != null ? informacoesDTO.faculdade() : this.faculdade;
        this.turma = informacoesDTO.turma() != null ? informacoesDTO.turma() : this.turma;
    }
}
