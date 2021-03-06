/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is2.ventas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findByNroFactura", query = "SELECT v FROM Ventas v WHERE v.nroFactura = :nroFactura"),
    @NamedQuery(name = "Ventas.findByFecha", query = "SELECT v FROM Ventas v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Ventas.findByTotalVenta", query = "SELECT v FROM Ventas v WHERE v.totalVenta = :totalVenta"),
    @NamedQuery(name = "Ventas.findByTotalIva", query = "SELECT v FROM Ventas v WHERE v.totalIva = :totalIva")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_factura")
    private BigDecimal nroFactura;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "total_venta")
    private Integer totalVenta;
    @Column(name = "total_iva")
    private Integer totalIva;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;

    public Ventas() {
    }

    public Ventas(BigDecimal nroFactura) {
        this.nroFactura = nroFactura;
    }

    public BigDecimal getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(BigDecimal nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Integer totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Integer getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Integer totalIva) {
        this.totalIva = totalIva;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroFactura != null ? nroFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.nroFactura == null && other.nroFactura != null) || (this.nroFactura != null && !this.nroFactura.equals(other.nroFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.is2.ventas.Ventas[ nroFactura=" + nroFactura + " ]";
    }
    
}
