/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Raffaele Francesco Mancino
 */
@Entity
@Table(name = "recipeingredient")
@NamedQueries(
{
    @NamedQuery(name = "Recipeingredient.findAll", query = "SELECT r FROM Recipeingredient r")
})
public class Recipeingredient implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecipeingredientPK recipeingredientPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qt")
    private Float qt;
    @Size(max = 50)
    @Column(name = "unit")
    private String unit;

    public Recipeingredient()
    {
    }

    public Recipeingredient(RecipeingredientPK recipeingredientPK)
    {
        this.recipeingredientPK = recipeingredientPK;
    }

    public Recipeingredient(int idr, int idi)
    {
        this.recipeingredientPK = new RecipeingredientPK(idr, idi);
    }

    public RecipeingredientPK getRecipeingredientPK()
    {
        return recipeingredientPK;
    }

    public void setRecipeingredientPK(RecipeingredientPK recipeingredientPK)
    {
        this.recipeingredientPK = recipeingredientPK;
    }

    public Float getQt()
    {
        return qt;
    }

    public void setQt(Float qt)
    {
        this.qt = qt;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (recipeingredientPK != null ? recipeingredientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipeingredient))
        {
            return false;
        }
        Recipeingredient other = (Recipeingredient) object;
        if ((this.recipeingredientPK == null && other.recipeingredientPK != null) || (this.recipeingredientPK != null && !this.recipeingredientPK.equals(other.recipeingredientPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.raffaelemancino.ricettario.data.Recipeingredient[ recipeingredientPK=" + recipeingredientPK + " ]";
    }
    
}
