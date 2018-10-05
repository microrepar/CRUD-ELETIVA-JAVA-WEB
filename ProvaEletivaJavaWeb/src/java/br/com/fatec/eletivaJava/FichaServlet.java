/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.eletivaJava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FATEC
 */
public class FichaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            FichaPacienteDAO dao = new FichaPacienteDAO();

            if (null != request.getParameter("acao")) {

                if (request.getParameter("acao").equals("SALVAR")) {
                    FichaPaciente ficha = new FichaPaciente();
                    ficha.setCpf(request.getParameter("cpf"));
                    ficha.setNome(request.getParameter("nome"));
                    ficha.setEspecialidade(request.getParameter("especialidade"));
                    ficha.setDescSintomas(request.getParameter("descricao"));
                    ficha.setGravidade(request.getParameter("gravidade"));
                    dao.salvar(ficha);
                    response.sendRedirect(request.getContextPath() + "/FichaServlet");
                    return;
                } else if (request.getParameter("acao").equals("EXCLUIR")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.excluir(id);
                    response.sendRedirect(request.getContextPath() + "/FichaServlet");
                } else if (request.getParameter("acao").equals("ATUALIZAR")) {
                    FichaPaciente ficha = new FichaPaciente();
                    ficha.setId(Integer.parseInt(request.getParameter("id")));
                    ficha.setCpf(request.getParameter("cpf"));
                    ficha.setNome(request.getParameter("nome"));
                    ficha.setEspecialidade(request.getParameter("especialidade"));
                    ficha.setDescSintomas(request.getParameter("descricao"));
                    ficha.setGravidade(request.getParameter("gravidade"));
                    dao.atualizar(ficha);
                    response.sendRedirect(request.getContextPath() + "/FichaServlet");
                    return;
                }else if(request.getParameter("acao").equals("EDITAR")){
                    FichaPaciente ficha = dao.buscaPorId(request.getParameter("id"));
                    FichaPacienteDTO dto = FichaPacienteDTO.de(ficha);
                    request.setAttribute("ficha", dto);
                    request.getRequestDispatcher("atulizar.jsp").forward(request, response);
                    return;
                }                
                
            } else {
                FichaPaciente ficha = new FichaPaciente();
                List<FichaPaciente> fichas = dao.listarTodos();
                request.setAttribute("fichas", FichaPacienteDTO.listaDe(fichas));
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }

        } catch (Exception erro) {
            erro.printStackTrace();
        }

    }

}
