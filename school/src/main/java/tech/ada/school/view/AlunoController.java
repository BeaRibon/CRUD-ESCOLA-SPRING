package tech.ada.school.view;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.school.domain.dto.exception.NotFoundException;
import tech.ada.school.domain.dto.v1.AlunoDto;
import tech.ada.school.service.IAlunoService;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final IAlunoService servicoAluno;

    @Autowired
    public AlunoController(IAlunoService servicoAluno){ this.servicoAluno = servicoAluno;}

    @GetMapping
    public ResponseEntity<List<AlunoDto>> lerAlunos(){
        return ResponseEntity.ok(servicoAluno.listarAluno());
    }

    @PostMapping
    public ResponseEntity<AlunoDto> criarAluno(
            @RequestBody @Valid AlunoDto pedidoAluno
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoAluno.criarAluno(pedidoAluno));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> atualizarAluno(
            @PathVariable("id") int id,
            @RequestBody AlunoDto pedido
    ) throws NotFoundException {
        final AlunoDto a = servicoAluno.atualizarAluno(id, pedido);

        if(a == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(a);


    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscarAluno(
            @PathVariable("id") int id
    ) throws NotFoundException{
        return ResponseEntity.ok(servicoAluno.buscarAluno(id));
    }

    @DeleteMapping("/{id}")
    @SecurityRequirements(@SecurityRequirement(name = "JWT"))
    public ResponseEntity<Void> removerAluno(
            @PathVariable("id") int id
    ) throws NotFoundException{
        servicoAluno.removerAlunos(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<AlunoDto> buscarPorCpf(@PathParam("cpf") String cpf) throws NotFoundException{
        return ResponseEntity.ok(servicoAluno.buscarPorCpf(cpf));
    }


}
