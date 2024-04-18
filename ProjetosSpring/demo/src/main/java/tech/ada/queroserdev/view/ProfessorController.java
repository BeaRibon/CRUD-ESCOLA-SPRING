package tech.ada.queroserdev.view;

import org.springframework.web.bind.annotation.*;
import tech.ada.queroserdev.domain.dto.v1.ProfessorDto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final List<ProfessorDto> professores = new ArrayList<>();

    private int id = 1;
    @GetMapping
    public List<String> lerProfessores(){
        return Collections.singletonList("Beatriz");

    }

    @PostMapping
    public int criarProfessor(
            @RequestBody ProfessorDto pedido
        ){
    professores.add(new ProfessorDto(id++, pedido.getNome()));
    return id;
    }

    @PutMapping("/{id}")
    public void atualizarProfessor(
            @PathVariable("id") int id,
            @RequestBody ProfessorDto pedido
    ) {

        Optional<ProfessorDto> professor = professores
                .stream()
                .filter(it -> it.getId() == id)
                .findFirst();
        if (professor.isPresent()) {
            professores.remove(professor.get());
            professores.add(new ProfessorDto(id, pedido.getNome()));
        }

    }

    @GetMapping("/{id}")
    public ProfessorDto buscarProfessor(
            @PathVariable("id") int id
    ){
        Optional<ProfessorDto> professor = professores
                .stream()
                .filter(it -> it.getId() == id)
                .findFirst();
       return professor.orElse(null);
    }
}