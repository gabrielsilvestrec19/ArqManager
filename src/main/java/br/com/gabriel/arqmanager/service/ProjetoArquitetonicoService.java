package br.com.gabriel.arqmanager.service;

import br.com.gabriel.arqmanager.entity.ProjetoArquitetonico;
import br.com.gabriel.arqmanager.repository.ProjetoArquitetonicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetoArquitetonicoService {

    private final ProjetoArquitetonicoRepository repository;

    public List<ProjetoArquitetonico> recuperaTodos(){
        return repository.findAll();
    }

    public ProjetoArquitetonico recuperaPeloNome(String nome){
        Optional<ProjetoArquitetonico> projetoOptional = repository.findByNomeObra(nome);
        if (projetoOptional.isEmpty()) {
            throw new RuntimeException("Obra não encontrada");
        }
        return projetoOptional.get();
    }

    public ProjetoArquitetonico recuperaPorId(Long id) {
        Optional<ProjetoArquitetonico> projetoOptional = repository.findById(id);

        if (projetoOptional.isEmpty()) {
            throw new RuntimeException("Projeto não encontrado com o ID: " + id);
        }

        return projetoOptional.get();
    }

    public ProjetoArquitetonico salvaProjeto(ProjetoArquitetonico projetoArquitetonico){
        Optional<ProjetoArquitetonico> obraExistente = repository.findByNomeObra(projetoArquitetonico.getNomeObra());

        if (obraExistente.isPresent()) {
            throw new RuntimeException("Já existe um projeto registado com o nome: " + projetoArquitetonico.getNomeObra());
        }

        return repository.save(projetoArquitetonico);
    }

    public void deletaPorId(Long id){

        if(!repository.existsById(id)){
            throw new RuntimeException("Esse ID não existe");
        }
        repository.deleteById(id);
    }
    public ProjetoArquitetonico atualizaProjeto(Long id, ProjetoArquitetonico projetoAtualizado) {

        ProjetoArquitetonico projetoExistente = recuperaPorId(id);

        if (!projetoExistente.getNomeObra().equals(projetoAtualizado.getNomeObra())) {
            Optional<ProjetoArquitetonico> obraComMesmoNome = repository.findByNomeObra(projetoAtualizado.getNomeObra());
            if (obraComMesmoNome.isPresent()) {
                throw new RuntimeException("Já existe outro projeto registado com o nome: " + projetoAtualizado.getNomeObra());
            }
        }
        projetoExistente.setNomeObra(projetoAtualizado.getNomeObra());
        return repository.save(projetoExistente);
    }

}
