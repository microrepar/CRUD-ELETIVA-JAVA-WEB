/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.microrepar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author m.c.silva
 */
public class ServicoRequisito extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequisitoDAO dao = new RequisitoDAO();

            if (null != request.getParameter("acao")) {
                if (request.getParameter("acao").equals("SALVAR")) {
                    System.out.println("=>> ENTROU NO SALVAR");
                    Requisito requisito = new Requisito();
                    requisito.setSigla((String) request.getParameter("sigla"));
                    requisito.setTipo((String) request.getParameter("tipo"));
                    requisito.setNome((String) request.getParameter("nome"));
                    requisito.setDescricao((String) request.getParameter("descricao"));
                    requisito.setEscopo((String) request.getParameter("escopo"));
                    dao.salvar(requisito);
                    // Redireciona para a listagem com sendRedirect - evita o problema com o Reload (F5).
                    response.sendRedirect(request.getContextPath()+"/ServicoRequisito");
                    return;
                }else if(request.getParameter("acao").equals("EXCLUIR")){
                    long id = Long.parseLong(request.getParameter("id"));
                    dao.excluir(id);
                }

            } else {
                Requisito requisito = new Requisito();
                List<Requisito> requisitos = dao.listarTodos();
                request.setAttribute("requisitos", RequisitoDTO.listaDe(requisitos));
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                System.out.println("=>> ENTROU NO ELSE" + requisitos);
                return;
            }

        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

}
