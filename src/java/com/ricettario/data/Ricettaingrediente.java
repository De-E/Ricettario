/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricettario.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raffaele Francesco Mancino
 */
@Entity
@Table(name = "ricettaingrediente")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Ricettaingrediente.findAll", query = "SELECT r FROM Ricettaingrediente r"),
    @NamedQuery(name = "Ricettaingrediente.findByIdr", query = "SELECT r FROM Ricettaingrediente r WHERE r.ricettaingredientePK.idr = :idr"),
    @NamedQuery(name = "Ricettaingrediente.findByIdi", query = "SELECT r FROM Ricettaingrediente r WHERE r.ricettaingredientePK.idi = :idi"),
    @NamedQuery(name = "Ricettaingrediente.findByQt", query = "SELECT r FROM Ricettaingrediente r WHERE r.qt = :qt"),
    @NamedQuery(name = "Ricettaingrediente.findByMisura", query = "SELECT r FROM Ricettaingrediente r WHERE r.misura = :misura")
})
public class Ricettaingrediente implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RicettaingredientePK ricettaingredientePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qt")
    private int qt;
    @Size(max = 50)
    @Column(name = "misura")
    private String misura;
    @JoinColumn(name = "idi", referencedColumnName = "idi", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingrediente ingrediente;
    @JoinColumn(name = "idr", referencedColumnName = "idr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ricetta ricetta;

    public Ricettaingrediente()
    {
    }

    public Ricettaingrediente(RicettaingredientePK ricettaingredientePK)
    {
        this.ricettaingredientePK = ricettaingredientePK;
    }

    public Ricettaingrediente(RicettaingredientePK ricettaingredientePK, int qt)
    {
        this.ricettaingredientePK = ricettaingredientePK;
        this.qt = qt;
    }

    public Ricettaingrediente(int idr, int idi)
    {
        this.ricettaingredientePK = new RicettaingredientePK(idr, idi);
    }

    public RicettaingredientePK getRicettaingredientePK()
    {
        return ricettaingredientePK;
    }

    public void setRicettaingredientePK(RicettaingredientePK ricettaingredientePK)
    {
        this.ricettaingredientePK = ricettaingredientePK;
    }

    public int getQt()
    {
        return qt;
    }

    public void setQt(int qt)
    {
        this.qt = qt;
    }

    public String getMisura()
    {
        return misura;
    }

    public void setMisura(String misura)
    {
        this.misura = misura;
    }

    public Ingrediente getIngrediente()
    {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente)
    {
        this.ingrediente = ingrediente;
    }

    public Ricetta getRicetta()
    {
        return ricetta;
    }

    public void setRicetta(Ricetta ricetta)
    {
        this.ricetta = ricetta;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (ricettaingredientePK != null ? ricettaingredientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ricettaingrediente))
        {
            return false;
        }
        Ricettaingrediente other = (Ricettaingrediente) object;
        if ((this.ricettaingredientePK == null && other.ricettaingredientePK != null) || (this.ricettaingredientePK != null && !this.ricettaingredientePK.equals(other.ricettaingredientePK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "data.Ricettaingrediente[ ricettaingredientePK=" + ricettaingredientePK + " ]";
    }
    
}
