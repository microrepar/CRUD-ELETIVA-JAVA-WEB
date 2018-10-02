package br.com.fatecmogidascruzes.topicos;

import java.util.ArrayList;
import java.util.List;

public class SolicitacaoDTO {

    private int id;
    private String raAluno, nomeAluno, tipoDocumento, situacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(String raAluno) {
        this.raAluno = raAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public static SolicitacaoDTO de(Solicitacao solicitacao) {
        SolicitacaoDTO solicitacaoDTO = new SolicitacaoDTO();
        solicitacaoDTO.setId(solicitacao.getId());
        solicitacaoDTO.setNomeAluno(solicitacao.getNomeAluno());
        solicitacaoDTO.setRaAluno(solicitacao.getRaAluno());
        solicitacaoDTO.setSituacao(solicitacao.getSituacao());
        solicitacaoDTO.setTipoDocumento(solicitacao.getTipoDocumento());
        return solicitacaoDTO;
    }

    public static List<SolicitacaoDTO> listaDe(List<Solicitacao> solicitacoes) {
        List<SolicitacaoDTO> solicitacoesDTOs = new ArrayList<>();
        solicitacoes.forEach(solicitacao -> solicitacoesDTOs.add(SolicitacaoDTO.de(solicitacao)));
        return solicitacoesDTOs;
    }

}
