/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.core;

import com.raffaelemancino.ricettario.configuration.Application;
import com.raffaelemancino.ricettario.configuration.HibernateConf;
import com.raffaelemancino.ricettario.data.Ricetta;
import java.util.List;
import org.hibernate.Session;
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
    @RequestMapping(value = "/ricettafindall", method = RequestMethod.GET)
    public Bean ricettaFindAll()
    {
        List<Ricetta> ricette;
        ricette = Application.hibernate.session.getNamedQuery("Ricetta.findAll").list();
        
        
        Bean a = new Bean();
        a.setTxt("Il sistema REST funzia");
        a.setValues(ricette);
        return a;
    }
    
    @RequestMapping(value = "/ricettafind", method = RequestMethod.GET)
    public Ricetta ricettaFind(@RequestParam int id)
    {
        Ricetta ricetta = (Ricetta)Application.hibernate.session.getNamedQuery("Ricetta.findByIdr").setInteger("idr", id)
                .list()
                .get(0);
        
        return ricetta;
    }
    
    @RequestMapping(value = "/ricettainsert", method = RequestMethod.GET)
    public boolean ricettaInsert()
    {
        return true;
    }
}
