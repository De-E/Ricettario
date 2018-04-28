/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class RecipeingredientPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "idr")
    private int idr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idi")
    private int idi;

    public RecipeingredientPK()
    {
    }

    public RecipeingredientPK(int idr, int idi)
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
        if (!(object instanceof RecipeingredientPK))
        {
            return false;
        }
        RecipeingredientPK other = (RecipeingredientPK) object;
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
        return "com.raffaelemancino.ricettario.data.RecipeingredientPK[ idr=" + idr + ", idi=" + idi + " ]";
    }
    
}
