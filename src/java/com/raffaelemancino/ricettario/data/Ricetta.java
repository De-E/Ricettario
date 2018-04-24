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
@Table(name = "ricetta")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Ricetta.findAll", query = "SELECT r FROM Ricetta r"),
    @NamedQuery(name = "Ricetta.findByIdr", query = "SELECT r FROM Ricetta r WHERE r.idr = :idr"),
    @NamedQuery(name = "Ricetta.findByTimer", query = "SELECT r FROM Ricetta r WHERE r.timer = :timer"),
    @NamedQuery(name = "Ricetta.findByTemp", query = "SELECT r FROM Ricetta r WHERE r.temp = :temp"),
    @NamedQuery(name = "Ricetta.findByName", query = "SELECT r FROM Ricetta r WHERE r.name = :name"),
    @NamedQuery(name = "Ricetta.findByDesc", query = "SELECT r FROM Ricetta r WHERE r.desc = :desc"),
    @NamedQuery(name = "Ricetta.findByShortdesc", query = "SELECT r FROM Ricetta r WHERE r.shortdesc = :shortdesc")
})
public class Ricetta implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idr")
    private Integer idr;
    @Column(name = "timer")
    private Integer timer;
    @Column(name = "temp")
    private Integer temp;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 250)
    @Column(name = "desc")
    private String desc;
    @Size(max = 50)
    @Column(name = "shortdesc")
    private String shortdesc;

    public Ricetta()
    {
    }

    public Ricetta(Integer idr)
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
        if (!(object instanceof Ricetta))
        {
            return false;
        }
        Ricetta other = (Ricetta) object;
        if ((this.idr == null && other.idr != null) || (this.idr != null && !this.idr.equals(other.idr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.raffaelemancino.ricettario.data.Ricetta[ idr=" + idr + " ]";
    }
    
}
