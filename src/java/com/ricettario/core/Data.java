/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricettario.core;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public class Data
{
    int id;
    String value;

    public Data(int id, String value)
    {
        this.id = id;
        this.value = value;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
