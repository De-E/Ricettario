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
package com.raffaelemancino.ricettario.core.view;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Raffaele Francesco Mancino
 */
@Entity
@Table
public class IngredientiPerRicetta implements Serializable
{
    @Id
    @Column
    private Integer id;
    @Column
    private Integer qt;
    @Column
    private String misura;
    @Column
    private String nome;

    public Integer getQt()
    {
        return qt;
    }

    public void setQt(Integer qt)
    {
        this.qt = qt;
    }

    public String getMisura()
    {
        return misura;
    }

    public void setMisura(String misura)
    {
        this.misura = misura;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
    
    
}
