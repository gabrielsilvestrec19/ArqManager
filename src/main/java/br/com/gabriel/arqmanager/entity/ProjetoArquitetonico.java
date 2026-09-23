package br.com.gabriel.arqmanager.entity;

import br.com.gabriel.arqmanager.enums.FaseProjeto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "projeto")
@Data
public class ProjetoArquitetonico {

    @Id
    @Column(name = "id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_obra", unique = true, nullable = false, length = 40)
    private String nomeObra;

    @Column(name = "arquiteto_responsavel", nullable = false, length = 25)
    private String arquitetoResponsavel;

    @Enumerated(EnumType.STRING)
    @Column(name = "fase_projeto", nullable = false)
    private FaseProjeto faseProjeto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataDeInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_final", nullable = false)
    private LocalDate dataFinal;
}
