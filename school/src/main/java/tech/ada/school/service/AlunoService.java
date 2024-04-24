//package tech.ada.school.service;
//
//import org.springframework.stereotype.Service;
//import tech.ada.school.domain.dto.v1.AlunoDto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service
//public class AlunoService implements IAlunoService {
//
//    private final List<AlunoDto> alunos = new ArrayList<>();
//
//    private int id = 0;
//
//
//    @Override
//    public int criaAluno(String nome, String ra, String cpf, String email) {
//        alunos.add(new AlunoDto(id, nome, ra, cpf, email));
//        return id++;
//    }
//
//    @Override
//    public List<AlunoDto> listarAluno() {
//        return alunos;
//    }
//
//    @Override
//    public AlunoDto buscarAluno(int id) {
//        return null;
//    }
//
//    @Override
//    public void atualizarAluno(int id, String nome) {
//
//    }
//
//    @Override
//    public List<AlunoDto> listarAlunos() {
//        return null;
//    }
//}
