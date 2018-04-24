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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Raffaele Francesco Mancino
 */
@Embeddable
public class RicettaingredientePK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "idr")
    private int idr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idi")
    private int idi;

    public RicettaingredientePK()
    {
    }

    public RicettaingredientePK(int idr, int idi)
    {
        this.idr = idr;
        this.idi = idi;
    }

    public int getIdr()
    {
        return idr;
    }

    public void setIdr(int idr)
    {
        this.idr = idr;
    }

    public int getIdi()
    {
        return idi;
    }

    public void setIdi(int idi)
    {
        this.idi = idi;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idr;
        hash += (int) idi;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RicettaingredientePK))
        {
            return false;
        }
        RicettaingredientePK other = (RicettaingredientePK) object;
        if (this.idr != other.idr)
        {
            return false;
        }
        if (this.idi != other.idi)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.raffaelemancino.ricettario.data.RicettaingredientePK[ idr=" + idr + ", idi=" + idi + " ]";
    }
    
}
