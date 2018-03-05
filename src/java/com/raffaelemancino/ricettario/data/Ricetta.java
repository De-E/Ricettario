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

/**
 *
 * @author Raffaele Francesco Mancino
 */
@Entity
@Table(name = "ricetta")
@NamedQueries(
{
    @NamedQuery(name = "Ricetta.findAll", query = "SELECT r FROM Ricetta r"),
    @NamedQuery(name = "Ricetta.findByIdr", query = "SELECT r FROM Ricetta r WHERE r.idr = :idr"),
    @NamedQuery(name = "Ricetta.findByTempo", query = "SELECT r FROM Ricetta r WHERE r.tempo = :tempo"),
    @NamedQuery(name = "Ricetta.findByTemperatura", query = "SELECT r FROM Ricetta r WHERE r.temperatura = :temperatura"),
    @NamedQuery(name = "Ricetta.findByNome", query = "SELECT r FROM Ricetta r WHERE r.nome = :nome"),
    @NamedQuery(name = "Ricetta.findByDescrizione", query = "SELECT r FROM Ricetta r WHERE r.descrizione = :descrizione")
})
public class Ricetta implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idr")
    private Integer idr;
    @Column(name = "tempo")
    private Integer tempo;
    @Column(name = "temperatura")
    private Integer temperatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descrizione")
    private String descrizione;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ricetta")
    private Collection<Ricettaingrediente> ricettaingredienteCollection;

    public Ricetta()
    {
    }

    public Ricetta(Integer idr)
    {
        this.idr = idr;
    }

    public Ricetta(Integer idr, String nome, String descrizione)
    {
        this.idr = idr;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public Integer getIdr()
    {
        return idr;
    }

    public void setIdr(Integer idr)
    {
        this.idr = idr;
    }

    public Integer getTempo()
    {
        return tempo;
    }

    public void setTempo(Integer tempo)
    {
        this.tempo = tempo;
    }

    public Integer getTemperatura()
    {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura)
    {
        this.temperatura = temperatura;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

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
        return "com.ricettario.dataxml.Ricetta[ idr=" + idr + " ]";
    }
    
}
