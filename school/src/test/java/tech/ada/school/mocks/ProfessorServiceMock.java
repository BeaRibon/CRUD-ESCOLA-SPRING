package tech.ada.school.mocks;

import tech.ada.school.domain.dto.exception.NotFoundException;
import tech.ada.school.domain.dto.v1.ProfessorDto;
import tech.ada.school.service.IProfessorService;

import java.util.List;

public class ProfessorServiceMock implements IProfessorService {
    @Override
    public ProfessorDto criarProfessor(ProfessorDto pedido) {
        return null;
    }

    @Override
    public List<ProfessorDto> listarProfessores() {
        return List.of(new ProfessorDto());
    }

    @Override
    public ProfessorDto buscarProfessor(int id) throws NotFoundException {
        return null;
    }

    @Override
    public ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) {
        return null;
    }

    @Override
    public void removerProfessor(int id) throws NotFoundException {

    }

    @Override
    public ProfessorDto buscarPorCpf(String cpf) throws NotFoundException {
        return null;
    }
}