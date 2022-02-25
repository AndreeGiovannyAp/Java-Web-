<%-- 
    Document   : agregaAuto
    Created on : 22/06/2020, 10:03:20 PM
    Author     : Andree
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agrega Automovil</title>
    </head>
     <body>
        <h3>AGREGAR PALABRA</h3>
        <form id="atipo" action="AgregarAutos">
                      
            <output name="lplaca " value="placa:">Placa </output>
            <input name="placa" type="text" maxlength="20" minlength="4">
            <br/>
            <br/>
            <output name="lcolor " value="color:">Color: </output>
            <input name="color" type="text" maxlength="20" minlength="4">
            <br/>
            <br/>
            <output name="lModelo " value="modelo:">Modelo: </output>
            <input name="modelo" type="text" maxlength="20" minlength="4">
            <br/>
            <br/>
            <output name="lnombreV" value="nombreV:">Nombre Vehiculo </output>
            <input name="nombrev" type="text" maxlength="20" minlength="4">
            <br/>
            <br/>
            <output name="lpropietario " value="propietario:">Propietario </output>
            <input name="propietario" type="text" maxlength="20" minlength="4">
            <br/>
            <br/>
            <output name="lvigencia " value="palaca:">Vigencia </output>
            <input name="vigencia" type="text" maxlength="20" minlength="4">
            <br/>
            <br/>
            <output name="lservicio" value="servicio:">Servicio </output>
            <input name="servicio" type="text" maxlength="20" minlength="4">
            <br/>
            <br/>
                    
            <input type="submit" value="Aceptar">
        </form></body>
</html>
