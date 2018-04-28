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
@Table(name = "recipe")
@NamedQueries(
{
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r")
})
public class Recipe implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idr")
    private Integer idr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "timer")
    private Float timer;
    @Column(name = "temp")
    private Integer temp;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "desc")
    private String desc;
    @Size(max = 50)
    @Column(name = "shortdesc")
    private String shortdesc;

    public Recipe()
    {
    }

    public Recipe(Integer idr)
    {
        this.idr = idr;
    }

    public Integer getIdr()
    {
        return idr;
    }

    public void setIdr(Integer idr)
    {
        this.idr = idr;
    }

    public Float getTimer()
    {
        return timer;
    }

    public void setTimer(Float timer)
    {
        this.timer = timer;
    }

    public Integer getTemp()
    {
        return temp;
    }

    public void setTemp(Integer temp)
    {
        this.temp = temp;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getShortdesc()
    {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc)
    {
        this.shortdesc = shortdesc;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idr != null ? idr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe))
        {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.idr == null && other.idr != null) || (this.idr != null && !this.idr.equals(other.idr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.raffaelemancino.ricettario.data.Recipe[ idr=" + idr + " ]";
    }
    
}
