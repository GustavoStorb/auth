package com.gustavostorb.auth.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "candidatos")
@Getter
@Setter
@Data
@RequiredArgsConstructor
public class Candidatos {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "TIPO_ELEICAO")
    private String tipoEleicao;

    @Column(name = "TURNO")
    private Integer turno;

    @Column(name = "ABRANGENCIA")
    private String abrangencia;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CARGO")
    private String cargo;

    @Column(name = "NOME_CANDIDATO_URNA")
    private String nomeCandidatoUrna;

    @Column(name = "SITUACAO_CANDIDATURA")
    private String situacaoCandidatura;

    @Column(name = "PARTIDO")
    private String partido;

    @Column(name = "COLIGACAO")
    private String coligacao;

    @Column(name = "NACIONALIDADE")
    private String nacionalidade;

    @Column(name = "ESTADO_NASCIMENTO")
    private String estadoNascimento;

    @Column(name = "MUNICIPIO_NASCIMENTO")
    private String municipioNascimento;

    @Column(name = "DATA_POSSE_IDADE")
    private Float dataPosseIdade;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "GRAU_INSTRUCAO")
    private String grauInstrucao;

    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;

    @Column(name = "COR_RACA")
    private String corRaca;

    @Column(name = "OCUPACAO")
    private String ocupacao;

    @Column(name = "DESPESA_MAX_CAMPANHA")
    private Float despesaMaxCampanha;

    @Column(name = "SITUACAO_TOTAL_TURNO")
    private String situacaoTotalTurno;

    @Column(name = "SITUACAO_REELEICAO")
    private boolean situacaoReeleicao;

    @Column(name = "DECLARAR_BENS")
    private boolean declararBens;

    @Column(name = "PRESTAR_CONTAS")
    private boolean prestasContas;

    public Candidatos(String tipoEleicao, Integer turno, String abrangencia, String estado, String cargo, String nomeCandidatoUrna, String situacaoCandidatura, String partido, String coligacao, String nacionalidade, String estadoNascimento, String municipioNascimento, Float dataPosseIdade, String genero, String grauInstrucao, String estadoCivil, String corRaca, String ocupacao, Float despesaMaxCampanha, String situacaoTotalTurno, boolean situacaoReeleicao, boolean declararBens, boolean prestasContas) {
        this.tipoEleicao = tipoEleicao;
        this.turno = turno;
        this.abrangencia = abrangencia;
        this.estado = estado;
        this.cargo = cargo;
        this.nomeCandidatoUrna = nomeCandidatoUrna;
        this.situacaoCandidatura = situacaoCandidatura;
        this.partido = partido;
        this.coligacao = coligacao;
        this.nacionalidade = nacionalidade;
        this.estadoNascimento = estadoNascimento;
        this.municipioNascimento = municipioNascimento;
        this.dataPosseIdade = dataPosseIdade;
        this.genero = genero;
        this.grauInstrucao = grauInstrucao;
        this.estadoCivil = estadoCivil;
        this.corRaca = corRaca;
        this.ocupacao = ocupacao;
        this.despesaMaxCampanha = despesaMaxCampanha;
        this.situacaoTotalTurno = situacaoTotalTurno;
        this.situacaoReeleicao = situacaoReeleicao;
        this.declararBens = declararBens;
        this.prestasContas = prestasContas;
    }

}
