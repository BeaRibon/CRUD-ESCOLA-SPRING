package tech.ada.school.service;

import tech.ada.school.domain.dto.exception.NotFoundException;
import tech.ada.school.domain.dto.v1.AlunoDto;

import java.util.List;

public interface IAlunoService {

    AlunoDto criarAluno(AlunoDto pedido);

    List<AlunoDto> listarAluno();

    AlunoDto buscarAluno(int id) throws NotFoundException;

    AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException;

    void removerAlunos(int id) throws NotFoundException;

    AlunoDto buscarPorCpf(String cpf)throws NotFoundException;
}
