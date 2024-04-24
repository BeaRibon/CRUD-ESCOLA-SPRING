package tech.ada.school.service;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tech.ada.school.domain.dto.exception.NotFoundException;
import tech.ada.school.domain.dto.v1.AlunoDto;
import tech.ada.school.domain.entities.Aluno;
import tech.ada.school.domain.mappers.AlunoMapper;
import tech.ada.school.external.FeignBoredApi;
import tech.ada.school.repositories.AlunoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class AlunoServicoBD implements IAlunoService{


    private final AlunoRepository repositorio;
    private final FeignBoredApi boredApi;


    @Override
    public AlunoDto criarAluno(AlunoDto pedido) {
        Aluno a = AlunoMapper.toEntity(pedido);
        return AlunoMapper.toDto(repositorio.save(a), boredApi.getActivity().activity());
    }

    @Override
    public List<AlunoDto> listarAluno() {
        return repositorio
                .findAll()
                .stream()
                .map(ent -> AlunoMapper.toDto(ent, boredApi.getActivity().activity()))
                .toList();
    }

    @Override
    public AlunoDto buscarAluno(int id) throws NotFoundException {
        System.out.println((boredApi.getActivity()));
        return AlunoMapper.toDto(buscarAlunoPorId(id), boredApi.getActivity().activity());
    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException {
        final Aluno a = buscarAlunoPorId(id);
        a.setNome(pedido.getNome());
        a.setRa(pedido.getRa());
        a.setCpf(pedido.getCpf());
        a.setEMail(pedido.getEmail());

        return AlunoMapper.toDto(repositorio.save(a), boredApi.getActivity().activity());
    }

    @Override
    public void removerAlunos(int id) throws NotFoundException {
        final Aluno a = buscarAlunoPorId(id);
        repositorio.delete(a);
        repositorio.deleteById(id);

    }

    private Aluno buscarAlunoPorId(int id) throws NotFoundException{
        return repositorio.findById(id).orElseThrow(() -> new NotFoundException(Aluno.class, String.valueOf(id)));
    }

    @Override
    public AlunoDto buscarPorCpf(String cpf) throws NotFoundException {
        return AlunoMapper.toDto(repositorio.findByCpf(cpf).orElseThrow(() -> new NotFoundException(Aluno.class, cpf)), boredApi.getActivity()
                .activity());
    }
}
