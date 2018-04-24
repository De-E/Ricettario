/*
 * Copyright (C) 2018 Raffaele Francesco Mancino
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.raffaelemancino.ricettario.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
        return "com.raffaelemancino.ricettario.data.Ricettaingrediente[ ricettaingredientePK=" + ricettaingredientePK + " ]";
    }
    
}
