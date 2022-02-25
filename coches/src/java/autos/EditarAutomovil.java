/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos;

import controlers.AutomovilJpaController;
import controlers.exceptions.RollbackFailureException;
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
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import modelo.Automovil;


/**
 *
 * @author Andree
 */
@WebServlet(name = "EditarAutomovil", urlPatterns = {"/EditarAutomovil"})
public class EditarAutomovil extends HttpServlet {

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
            AutomovilJpaController Autocontroller = new AutomovilJpaController(utx, emf);
            
            String action = request.getParameter("action");
            System.out.println(request.getParameter("idauto"));
            int idauto = Integer.parseInt(request.getParameter("idauto"));
            System.out.println(action+"   "+idauto);
            if(action.equals("ELIMINAR")){
                Autocontroller.destroy(idauto);
                response.sendRedirect("index.jsp");
            }
            else{
                Automovil auto =Autocontroller.findAutomovil(idauto);
                if(auto != null){
                    String placa = request.getParameter("placa");
                    String color = request.getParameter("color");
                    String modelo = request.getParameter("modelo");
                    String nombreV = request.getParameter("nombrev");
                    String propietario = request.getParameter("propietario");
                    String vigencia = request.getParameter("vigencia");
                    String servicio = request.getParameter("servicio");
                    auto.setPlaca(placa);
                    auto.setColor(color);
                    auto.setModelo(modelo);
                    auto.setNomVehiculo(nombreV);
                    auto.setPropietario(propietario);
                    auto.setVigencia(vigencia);
                    auto.setServicio(servicio);
                    Autocontroller.edit(auto);
                }
                response.sendRedirect("index.jsp");
            }
        } catch (RollbackFailureException ex) {
    } catch (Exception ex) {
        
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
