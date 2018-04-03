/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.br.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author douglas
 */
@WebServlet(name = "PaisesServlet", urlPatterns = {"/PaisesServlet.html"})
public class PaisesServlet extends HttpServlet {

    HashMap<String, String> selects = new HashMap<String, String>();
    HashMap<String, ArrayList<String>> cores = new HashMap<String, ArrayList<String>>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ordenacao = request.getParameter("ordenacao");

        selects.put("Brasil", "Verde");
        selects.put("Argentina", "Azul Claro");
        selects.put("Holanda", "Alaranjado");
        selects.put("França", "Azul");
        selects.put("Inglaterra", "Vermelho");
        selects.put("Italia", "Cinza");
        selects.put("Jamaica", "Cinza");
        selects.put("Japão", "Cinza");

        // maps.put(paises,cores);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PaisServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p> LISTA DE DEFINIÇÃO!!!! </p>");
            out.println("<dl>");
            for (Map.Entry<String, String> entry : selects.entrySet()) {

                out.println("<dt> " + entry.getKey() + "</dt>");
                out.println("<dd> " + entry.getValue() + "</dd>");
            }
            out.println("</dl>");            
            out.println("<h1> Clique para agrupar por cores </h1>");            
            out.println("<dl>");
            out.println("<a href='?ordenacao=a'>Ordenação Cores</a>");
            out.println("<br/>");
            if (ordenacao.equals("a")) {

                for (Map.Entry<String, String> pais : selects.entrySet()) {
                    if (!cores.containsKey(pais.getValue())) {
                        ArrayList<String> colecao = new ArrayList();
                        colecao.add(pais.getKey());
                        cores.put(pais.getValue(), colecao);
                    } else {
                        cores.get(pais.getValue()).add(pais.getKey());
                    }

                }
                out.println("<br/>");
                for (Map.Entry<String, ArrayList<String>> cor : cores.entrySet()) {
                    out.println("<dt>" + cor.getKey() + "</dt>");
                    out.println("<dd>" + cor.getValue() + "</dd>");
                }
            }

            out.println("</dl>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
