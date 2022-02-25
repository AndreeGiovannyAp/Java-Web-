/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andree
 */
@Entity
@Table(name = "AUTOMOVIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automovil.findAll", query = "SELECT a FROM Automovil a")
    , @NamedQuery(name = "Automovil.findByIdautomovil", query = "SELECT a FROM Automovil a WHERE a.idautomovil = :idautomovil")
    , @NamedQuery(name = "Automovil.findByPlaca", query = "SELECT a FROM Automovil a WHERE a.placa = :placa")
    , @NamedQuery(name = "Automovil.findByColor", query = "SELECT a FROM Automovil a WHERE a.color = :color")
    , @NamedQuery(name = "Automovil.findByModelo", query = "SELECT a FROM Automovil a WHERE a.modelo = :modelo")
    , @NamedQuery(name = "Automovil.findByNomVehiculo", query = "SELECT a FROM Automovil a WHERE a.nomVehiculo = :nomVehiculo")
    , @NamedQuery(name = "Automovil.findByPropietario", query = "SELECT a FROM Automovil a WHERE a.propietario = :propietario")
    , @NamedQuery(name = "Automovil.findByVigencia", query = "SELECT a FROM Automovil a WHERE a.vigencia = :vigencia")
    , @NamedQuery(name = "Automovil.findByServicio", query = "SELECT a FROM Automovil a WHERE a.servicio = :servicio")})
public class Automovil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAUTOMOVIL")
    private Integer idautomovil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PLACA")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COLOR")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MODELO")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM_VEHICULO")
    private String nomVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PROPIETARIO")
    private String propietario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VIGENCIA")
    private String vigencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SERVICIO")
    private String servicio;

    public Automovil() {
    }

    public Automovil(Integer idautomovil) {
        this.idautomovil = idautomovil;
    }

    public Automovil(Integer idautomovil, String placa, String color, String modelo, String nomVehiculo, String propietario, String vigencia, String servicio) {
        this.idautomovil = idautomovil;
        this.placa = placa;
        this.color = color;
        this.modelo = modelo;
        this.nomVehiculo = nomVehiculo;
        this.propietario = propietario;
        this.vigencia = vigencia;
        this.servicio = servicio;
    }

    public Integer getIdautomovil() {
        return idautomovil;
    }

    public void setIdautomovil(Integer idautomovil) {
        this.idautomovil = idautomovil;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNomVehiculo() {
        return nomVehiculo;
    }

    public void setNomVehiculo(String nomVehiculo) {
        this.nomVehiculo = nomVehiculo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idautomovil != null ? idautomovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovil)) {
            return false;
        }
        Automovil other = (Automovil) object;
        if ((this.idautomovil == null && other.idautomovil != null) || (this.idautomovil != null && !this.idautomovil.equals(other.idautomovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Automovil[ idautomovil=" + idautomovil + " ]";
    }
    
}
