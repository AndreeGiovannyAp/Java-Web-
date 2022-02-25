/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos;

import controlers.AutomovilJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import modelo.Automovil;

/**
 *
 * @author Andree
 */
@WebServlet(name = "ListarAutos", urlPatterns = {"/ListarAutos"})
public class ListarAutos extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            emf = Persistence.createEntityManagerFactory("cochesPU");
            AutomovilJpaController controlAuto;
            controlAuto = new AutomovilJpaController(utx, emf);
            List<Automovil> lista = controlAuto.findAutomovilEntities();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarTipos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h2>Automovil</h2>");
            out.println("<br>");
            out.println("<table align='center' width='60%' border=1>");
            out.println("<tr>"
                    + "<td class='datos'>ID</td>"
                    + "<td class='datos'>Placa</td>"
                    + "<td class='datos'>Color</td>"
                    + "<td class='datos'>Modelo</td>"
                    + "<td class='datos'>nomVehiculo</td>"
                    + "<td class='datos'>Propietario</td>"
                    + "<td class='datos'>Vigencia</td>"
                    + "<td class='datos'>Servicio</td>"
                    + "<td class='datos'>Editar/Eliminar</td>"
                    + "</tr>");
            int i = 0;
            for (Automovil dato : lista) {
                out.println("<tr>"
                        + "<td class='datos'>" + dato.getIdautomovil() + "</td>"
                        + "<td class='datos'>" + dato.getPlaca() + "</td>"
                        + "<td class='datos'>" + dato.getColor() + "</td>"
                        + "<td class='datos'>" + dato.getModelo() + "</td>"
                        + "<td class='datos'>" + dato.getNomVehiculo() + "</td>"
                        + "<td class='datos'>" + dato.getPropietario() + "</td>"
                        + "<td class='datos'>" + dato.getVigencia() + "</td>"
                        + "<td class='datos'>" + dato.getServicio() + "</td>"
                        + "<td class='datos'><a href=\"editar_auto.jsp?id=" + i + "\"> EDITAR/ELIMINAR </a></td>"
                        + "</tr>");
                System.out.println(i);
                i++;
            }
            out.println("</table>");
            out.println("<br>");
            out.println("<a href=\"agregarAuto.jsp\"> Seguir agregando </a>");
            out.println("<br>");
            out.println("<a href=\"index.jsp\"> Regresar al inicio </a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
