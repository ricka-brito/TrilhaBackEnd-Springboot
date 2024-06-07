package br.ETS.Feedback200.controller;


import br.ETS.Feedback200.model.instrutor.Instrutor;
import br.ETS.Feedback200.model.instrutor.dto.InstrutorDTO;
import br.ETS.Feedback200.model.instrutor.InstrutorRepository;
import br.ETS.Feedback200.model.instrutor.dto.ListInstrutorDTO;
import br.ETS.Feedback200.model.instrutor.dto.UpdateInstrutorDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ListInstrutorDTO> cadastrar(@RequestBody @Valid InstrutorDTO instrutorDTO, UriComponentsBuilder uriComponentsBuilder){
        var instrutor = new Instrutor(instrutorDTO);
        repository.save(instrutor);
        var uri = uriComponentsBuilder.path("/instrutor/{id}").buildAndExpand(instrutor.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListInstrutorDTO(instrutor));
    }

    @GetMapping
    public ResponseEntity<Page<ListInstrutorDTO>> listar(@PageableDefault(size = 3, sort = {"nome"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(ListInstrutorDTO::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<ListInstrutorDTO> atualizar(@RequestBody @Valid UpdateInstrutorDTO updateInstrutorDTO) {
        var instrutor = repository.getReferenceById(updateInstrutorDTO.id());
        instrutor.atualizar(updateInstrutorDTO);
        return ResponseEntity.ok(new ListInstrutorDTO((instrutor)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Instrutor> excluir(@PathVariable int id){
        var instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrutorDTO> buscarPorId(@PathVariable int id) {
        var instrutor = repository.findByIdAndAtivoTrue(id);

        if (instrutor != null) {
            return ResponseEntity.ok(new InstrutorDTO(instrutor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
