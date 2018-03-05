/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingrediente")
    private Collection<Ricettaingrediente> ricettaingredienteCollection;

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

    @XmlTransient
    public Collection<Ricettaingrediente> getRicettaingredienteCollection()
    {
        return ricettaingredienteCollection;
    }

    public void setRicettaingredienteCollection(Collection<Ricettaingrediente> ricettaingredienteCollection)
    {
        this.ricettaingredienteCollection = ricettaingredienteCollection;
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
        return "com.ricettario.dataxml.Ingrediente[ idi=" + idi + " ]";
    }
    
}
