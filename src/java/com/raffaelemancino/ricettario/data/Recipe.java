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
import javax.persistence.Id;
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
@Table(name = "recipe")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findByIdr", query = "SELECT r FROM Recipe r WHERE r.idr = :idr"),
    @NamedQuery(name = "Recipe.findByNamer", query = "SELECT r FROM Recipe r WHERE r.namer = :namer"),
    @NamedQuery(name = "Recipe.findByTimer", query = "SELECT r FROM Recipe r WHERE r.timer = :timer"),
    @NamedQuery(name = "Recipe.findByTemp", query = "SELECT r FROM Recipe r WHERE r.temp = :temp"),
})
public class Recipe implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idr")
    private Integer idr;
    @Size(max = 45)
    @Column(name = "namer")
    private String namer;
    @Column(name = "timer")
    private Integer timer;
    @Column(name = "temp")
    private Integer temp;
    @Size(max = 500)
    @Column(name = "descr")
    private String descr;
    @Size(max = 45)
    @Column(name = "shortdescr")
    private String shortdescr;

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

    public String getNamer()
    {
        return namer;
    }

    public void setNamer(String namer)
    {
        this.namer = namer;
    }

    public Integer getTimer()
    {
        return timer;
    }

    public void setTimer(Integer timer)
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

    public String getDescr()
    {
        return descr;
    }

    public void setDescr(String descr)
    {
        this.descr = descr;
    }

    public String getShortdescr()
    {
        return shortdescr;
    }

    public void setShortdescr(String shortdescr)
    {
        this.shortdescr = shortdescr;
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
