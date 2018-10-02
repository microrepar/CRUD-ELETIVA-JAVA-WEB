package br.com.fatecmogidascruzes.topicos;

import br.com.fatecmogidascruzes.topicos.Solicitacao;
import br.com.fatecmogidascruzes.topicos.SolicitacaoDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicoSolicitacao extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Verificar se foi recebida alguma ação.
            if (null != request.getParameter("acao")) {
                // Se for ação de exclusão, exclui o registro do banco de dados.
                if (request.getParameter("acao").equals("excluir")) {
                    Solicitacao solicitacao = new Solicitacao();
                    solicitacao.setId(Integer.valueOf(request.getParameter("id")));
                    solicitacao.excluir();

                    // Redireciona para a listagem com sendRedirect - evita o problema com o Reload (F5).
                    response.sendRedirect(request.getContextPath() + "/ServicoSolicitacao");
                    return;
                } else if (request.getParameter("acao").equals("inserir")) {
                    Solicitacao solicitacao = new Solicitacao();
                    solicitacao.setRaAluno(request.getParameter("ra_aluno"));
                    solicitacao.setNomeAluno(request.getParameter("nome_aluno"));
                    solicitacao.setTipoDocumento(request.getParameter("tipo_documento"));
                    solicitacao.setSituacao("Solicitado");
                    solicitacao.salvar();

                    // Redireciona para a listagem com sendRedirect - evita o problema com o Reload (F5).
                    response.sendRedirect(request.getContextPath() + "/ServicoSolicitacao");
                    return;
                } else if (request.getParameter("acao").equals("alterar")) {
                    Solicitacao solicitacao = new Solicitacao();
                    solicitacao.setId(Integer.valueOf(request.getParameter("id")));
                    solicitacao.setRaAluno(request.getParameter("ra_aluno"));
                    solicitacao.setNomeAluno(request.getParameter("nome_aluno"));
                    solicitacao.setTipoDocumento(request.getParameter("tipo_documento"));
                    solicitacao.alterar();

                    // Redireciona para a listagem com sendRedirect - evita o problema com o Reload (F5).
                    response.sendRedirect(request.getContextPath() + "/ServicoSolicitacao");
                    return;
                } else if (request.getParameter("acao").equals("preAlteracao")) {
                    Solicitacao solicitacao = new Solicitacao();
                    Solicitacao encontrada = solicitacao.consultarPorId(Integer.valueOf(request.getParameter("id")));

                    request.setAttribute("solicitacao", SolicitacaoDTO.de(encontrada));
                    request.getRequestDispatcher("/alterar.jsp").forward(request, response);
                    return;

                } else if (request.getParameter("acao").equals("Pesquisar")) {
                    Solicitacao solicitacao = new Solicitacao();
                    List<Solicitacao> solicitacoes = solicitacao.filtrar(request.getParameter("filtrar"));
                    request.setAttribute("solicitacoes", SolicitacaoDTO.listaDe(solicitacoes));
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                }

            } else {
                Solicitacao solicitacao = new Solicitacao();
                List<Solicitacao> solicitacoes = solicitacao.listarTodos();
                request.setAttribute("solicitacoes", SolicitacaoDTO.listaDe(solicitacoes));
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }

        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

}
