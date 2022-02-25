<%-- 
    Document   : editar_palabra
    Created on : 4/06/2020, 05:58:42 PM
    Author     : Andree
--%>

<%@page import="modelo.Automovil"%>
<%@page import="controlers.AutomovilJpaController"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="java.util.List"%>
<%@page import="javax.transaction.UserTransaction"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("cochesPU");;
    UserTransaction utx = null;
    AutomovilJpaController controlAutos = new AutomovilJpaController(utx, emf);
    List<Automovil> lista = controlAutos.findAutomovilEntities();   
    int idp = Integer.parseInt(request.getParameter("id"));
    Automovil auto = lista.get(idp);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Automovil</title>
    </head>
    
    <body>
    <center>
        <h3>EDITAR Automovil</h3>
        
        <form  action="EditarAutomovil" method="POST">
            <output name="tid" value="ID">ID: </output>
            <input name="idauto" readonly="readonly" value="<%=auto.getIdautomovil()%>" type="number" />
            <br/>
            <br/>
            <output name="tplaca" value="Placa:">Placa </output>
            <input name="placa" value="<%=auto.getPlaca()%>" type="text" maxlength="20" minlength="4"/>
            <br/>
            <br/>
            <output name="tcolor" value="Color: ">Color </output>
            <input name="color" value="<%=auto.getColor()%>" type="text" maxlength="20" minlength="4"/>  
            <br/>
            <br/>
            <output name="tmodelo" value="Modelo: ">Modelo </output>
            <input name="modelo" value="<%=auto.getModelo()%>" type="text" maxlength="20" minlength="4"/>  
            <br/>
            <br/>
            <output name="tnombrev" value="Nombre vehiculo">Nombre Vehiculo </output>
            <input name="nombrev" value="<%=auto.getNomVehiculo()%>" type="text" maxlength="20" minlength="4"/>  
            <br/>
            <br/>
            <output name="tpropietario" value="Propietario ">Propietario  </output>
            <input name="propietario" value="<%=auto.getPropietario()%>" type="text" maxlength="20" minlength="4"/>  
            <br/>
            <br/>
            <output name="tvigencia" value="Vigencia ">Vigencia  </output>
            <input name="vigencia" value="<%=auto.getVigencia()%>" type="text" maxlength="20" minlength="4"/>  
            <br/>
            <br/>
            <output name="tmodelo" value="Modelo: ">Servicio </output>
            <input name="servicio" value="<%=auto.getServicio()%>" type="text" maxlength="20" minlength="4"/>  
            <br/>
            <br/>
            <input name="action" type="submit" value="EDITAR"/>
            <input name="action" type="submit" value="ELIMINAR"/>
        </form>
                    </center>
    </body>
</html>
