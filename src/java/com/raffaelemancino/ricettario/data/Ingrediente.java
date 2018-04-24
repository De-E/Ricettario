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
@Table(name = "ingrediente")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Ingrediente.findAll", query = "SELECT i FROM Ingrediente i"),
    @NamedQuery(name = "Ingrediente.findByIdi", query = "SELECT i FROM Ingrediente i WHERE i.idi = :idi"),
    @NamedQuery(name = "Ingrediente.findByNome", query = "SELECT i FROM Ingrediente i WHERE i.nome = :nome")
})
public class Ingrediente implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idi")
    private Integer idi;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;

    public Ingrediente()
    {
    }

    public Ingrediente(Integer idi)
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

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
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
        if (!(object instanceof Ingrediente))
        {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.idi == null && other.idi != null) || (this.idi != null && !this.idi.equals(other.idi)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.raffaelemancino.ricettario.data.Ingrediente[ idi=" + idi + " ]";
    }
    
}
