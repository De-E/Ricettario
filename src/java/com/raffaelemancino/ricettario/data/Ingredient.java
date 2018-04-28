/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.data;

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
import javax.validation.constraints.Size;

/**
 *
 * @author Raffaele Francesco Mancino
 */
@Entity
@Table(name = "ingredient")
@NamedQueries(
{
    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i")
})
public class Ingredient implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idi")
    private Integer idi;
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    public Ingredient()
    {
    }

    public Ingredient(Integer idi)
    {
        this.idi = idi;
    }

    public Integer getIdi()
    {
        return idi;
    }

    public void setIdi(Integer idi)
    {
        this.idi = idi;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idi != null ? idi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient))
        {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.idi == null && other.idi != null) || (this.idi != null && !this.idi.equals(other.idi)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.raffaelemancino.ricettario.data.Ingredient[ idi=" + idi + " ]";
    }
    
}
