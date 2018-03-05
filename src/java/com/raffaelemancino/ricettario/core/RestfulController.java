/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.core;

import com.raffaelemancino.ricettario.configuration.HibernateConf;
import com.raffaelemancino.ricettario.data.Ricetta;
import java.util.List;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Raffaele Francesco Mancino
 */

@RestController
public class RestfulController
{
    @RequestMapping("/ricettafindall")
    public Bean ricettaFindAll()
    {
        Session session = new HibernateConf().session;
        //List<Ricetta> ricette= session.createQuery("SELECT r FROM Ricetta r").list();
        List<Ricetta> ricette;
        ricette = session.getNamedQuery("Ricetta.findAll").list();
        
        
        Bean a = new Bean();
        a.setTxt("Test per prova");
        a.setValues(ricette);
        return a;
    }
    
    @RequestMapping("/ricettafind")
    public Ricetta ricettaFind(@RequestParam int id)
    {
        Session session = new HibernateConf().session;
        List<Ricetta> ricette;
        ricette = session.getNamedQuery("Ricetta.findByIdr").setInteger("idr", id).list();
        Ricetta ricetta = ricette.get(0);
        
        return ricetta;
    }
    
}
