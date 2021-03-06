/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos;

import controlers.AutomovilJpaController;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
 * @author gadge
 */
@WebServlet(name = "AgregarAutos", urlPatterns = {"/AgregarAutos"})
public class AgregarAutos extends HttpServlet {
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
            AutomovilJpaController controlAuto= new AutomovilJpaController(utx, emf);
            Automovil auto = new Automovil();
            //palabra.setPalabra((String)request.getParameter("palabra"));
            auto.setPlaca((String)request.getParameter("placa"));
            auto.setColor((String) request.getParameter("color"));
            auto.setModelo((String)request.getParameter("modelo"));
            auto.setNomVehiculo((String)request.getParameter("nombrev"));
            auto.setPropietario((String)request.getParameter("propietario"));
            auto.setVigencia((String)request.getParameter("vigencia"));
            auto.setServicio((String)request.getParameter("servicio"));
            controlAuto.create(auto);
            response.sendRedirect("index.jsp");
        }catch(Exception e){
            e.printStackTrace();
            out.println("No se pudo conectar");
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
