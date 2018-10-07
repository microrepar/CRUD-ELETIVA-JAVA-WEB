package br.com.eletivaJavaWeb;

import br.com.eletivaJavaWeb.HospedagemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HospedagemServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HospedagemDAO dao = new HospedagemDAO();
            
            if(null != request.getParameter("acao")){
                if(request.getParameter("acao").equals("SALVAR")){
                    Hospedagem hospedagem = new Hospedagem();
                    hospedagem.setTipo(request.getParameter("tipo"));
                    hospedagem.setCapacidade(Integer.parseInt(request.getParameter("capacidade")));
                    hospedagem.setNumeroSuite(Integer.parseInt(request.getParameter("numero")));
                    hospedagem.setValorHospedagem(Double.parseDouble(request.getParameter("valor_h")));
                    hospedagem.setValorAdicionais(Double.parseDouble(request.getParameter("valor_a")));
                    hospedagem.setNome(request.getParameter("nome"));
                    hospedagem.setDescAmenidade(request.getParameter("descricao"));
                    hospedagem.setEntrada(new Date());
                    dao.salvar(hospedagem);
                    response.sendRedirect(request.getContextPath()+"/HospedagemServlet");
                    return;
                }else if(request.getParameter("acao").equals("EXCLUIR")){
                    int id = Integer.parseInt(request.getParameter("id"));
                    HospedagemDTO dto = HospedagemDTO.de(dao.buscarPorId(id));
                    request.setAttribute("hospedagemDTO", dto);
                    request.getRequestDispatcher("confirmarExcluir.jsp").forward(request, response);
                    return;
                }else if(request.getParameter("acao").equals("SIM")){
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.excluir(id);
                    response.sendRedirect(request.getContextPath()+"/HospedagemServlet");
                    return;
                }else if(request.getParameter("acao").equals("EDITAR")){
                    int id = Integer.parseInt(request.getParameter("id"));
                    HospedagemDTO dto = HospedagemDTO.de(dao.buscarPorId(id));
                    request.setAttribute("hospedagemDTO", dto);
                    request.getRequestDispatcher("atualizar.jsp").forward(request, response);
                    return;                    
                }else if(request.getParameter("acao").equals("ATUALIZAR")){
                    Hospedagem hospedagem = new Hospedagem();
                    hospedagem.setId(Integer.parseInt(request.getParameter("id")));
                    hospedagem.setTipo(request.getParameter("tipo")); 
                    hospedagem.setNumeroSuite(Integer.parseInt(request.getParameter("numero")));
                    hospedagem.setNome(request.getParameter("nome"));
                    hospedagem.setCapacidade(Integer.parseInt(request.getParameter("capacidade")));
                    hospedagem.setDescAmenidade(request.getParameter("descricao"));
                    hospedagem.setValorHospedagem(Double.parseDouble(request.getParameter("valor_h")));
                    hospedagem.setValorAdicionais(Double.parseDouble(request.getParameter("valor_a")));
                    
                    dao.atualizar(hospedagem);
                    
                    response.sendRedirect(request.getContextPath()+"/HospedagemServlet");
                    return;
                }else if(request.getParameter("acao").equals("RELATORIO")){
                    List<RelatorioHospedagemDTO> dtos = dao.relatorio();
                    request.setAttribute("relatorioHospedagens", dtos);
                    request.getRequestDispatcher("relatorio.jsp").forward(request, response);
                    return;
                }else if(request.getParameter("acao").equals("FINALIZAR")){
                    Hospedagem hospedagem = new Hospedagem();
                    hospedagem.setId(Integer.parseInt(request.getParameter("id")));
                    hospedagem.setTipo(request.getParameter("tipo")); 
                    hospedagem.setNumeroSuite(Integer.parseInt(request.getParameter("numero")));
                    hospedagem.setNome(request.getParameter("nome"));
                    hospedagem.setCapacidade(Integer.parseInt(request.getParameter("capacidade")));
                    hospedagem.setDescAmenidade(request.getParameter("descricao"));
                    hospedagem.setValorHospedagem(Double.parseDouble(request.getParameter("valor_h")));
                    hospedagem.setValorAdicionais(Double.parseDouble(request.getParameter("valor_a")));
                    hospedagem.setSaida(new Date());
                    
                    dao.finalizar(hospedagem);
                    
                    response.sendRedirect(request.getContextPath()+"/HospedagemServlet");
                    return;                    
                }
                
                
            }else{
                List<Hospedagem> Hospedagems = dao.listarTodos();
                request.setAttribute("hospedagemsDTO", HospedagemDTO.listaDe(Hospedagems));
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
                
            
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }
    
}
