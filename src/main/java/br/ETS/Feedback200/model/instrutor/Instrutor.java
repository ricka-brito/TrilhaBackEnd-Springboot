package br.ETS.Feedback200.model.instrutor;

import br.ETS.Feedback200.model.informacoes.Informacoes;
import br.ETS.Feedback200.model.instrutor.dto.InstrutorDTO;
import br.ETS.Feedback200.model.instrutor.dto.UpdateInstrutorDTO;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Instrutor")
@Table(name = "tbInstrutores")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private String edv;

    @Embedded
    private Informacoes informacoes;

    private boolean ferias;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    private boolean ativo;

    public Instrutor(InstrutorDTO instrutorDTO) {
        this.nome = instrutorDTO.nome();
        this.email = instrutorDTO.email();
        this.edv = instrutorDTO.edv();
        this.informacoes = new Informacoes(instrutorDTO.informacoes());
        this.curso = instrutorDTO.curso();
        this.ferias = instrutorDTO.ferias();
        this.ativo = true;

    }

    public void atualizar(UpdateInstrutorDTO updateInstrutorDTO){
        if(updateInstrutorDTO.nome() != null) {
            this.nome = updateInstrutorDTO.nome();
        }
        if(updateInstrutorDTO.email() != null) {
            this.email = updateInstrutorDTO.email();
        }
        if(updateInstrutorDTO.edv() != null) {
            this.edv = updateInstrutorDTO.edv();
        }
        if(updateInstrutorDTO.curso() != null) {
            this.curso = updateInstrutorDTO.curso();
        }

        if(updateInstrutorDTO.informacoes() != null){
            this.informacoes.atualizar(updateInstrutorDTO.informacoes());
        }

        this.ferias = updateInstrutorDTO.ferias();

    }

    public void excluir() {
        this.ativo = false;
    }
}
