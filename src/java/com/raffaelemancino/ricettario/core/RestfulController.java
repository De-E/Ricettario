/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.core;

import com.raffaelemancino.ricettario.core.view.IngredientiPerRicetta;
import com.raffaelemancino.ricettario.configuration.Application;
import com.raffaelemancino.ricettario.data.Ricetta;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Raffaele Francesco Mancino
 */

@RestController
public class RestfulController
{
    private Session session = Application.hibernate.session;
    
    @RequestMapping(value = "/listR", method = RequestMethod.GET)
    public List ricettaFindAll()
    {
        List<Ricetta> ricette;
        ricette = this.session.getNamedQuery("Ricetta.findAll").list();
        
        return ricette;
    }
    
    @RequestMapping(value = "/readR", method = RequestMethod.GET)
    public Ricetta ricettaFind(@RequestParam int id)
    {
        Ricetta ricetta = (Ricetta)this.session.getNamedQuery("Ricetta.findByIdr")
            .setInteger("idr", id)
            .list()
            .get(0);
        
        return ricetta;
    }
    
    @RequestMapping(value = "/readI", method = RequestMethod.GET)
    public ArrayList<IngredientiPerRicetta> getIngredients(@RequestParam int idr)
    {
        ArrayList<IngredientiPerRicetta> ret = new ArrayList<>();
        String query = "SELECT qt, misura, ing.nome FROM ricetta JOIN ( ricettaingrediente NATURAL JOIN ingrediente AS ing) ON ricetta.idr = ricettaingrediente.idr AND ricetta.idr = :idr";
        ret = (ArrayList<IngredientiPerRicetta>)this.session.createSQLQuery(query)
                .setInteger("idr", idr)
                .list();
        return ret;
    }
    
    @RequestMapping(value = "/insertR", method = RequestMethod.POST)
    public boolean ricettaInsert(@RequestBody Ricetta ricetta)
    {
        Integer i = (Integer)this.session.createQuery("SELECT MAX(idr) FROM Ricetta").list().get(0);
        ricetta.setIdr(i+1);
        
        try
        {
            this.session.beginTransaction();
            this.session.save(ricetta);
            this.session.getTransaction().commit();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}
