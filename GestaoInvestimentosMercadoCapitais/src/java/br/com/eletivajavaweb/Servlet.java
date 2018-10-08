package br.com.eletivajavaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            InvestimentoDAO dao = new InvestimentoDAO();
            if(null != request.getParameter("acao")){
                
            }else{
                List<InvestimentoDTO> dtos = InvestimentoDTO.listaDe(dao.listarTodos());
                request.setAttribute("investimentosDTO", dtos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
