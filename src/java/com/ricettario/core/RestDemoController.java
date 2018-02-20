/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricettario.core;

import com.ricettario.configuration.HibernateConf;
import com.ricettario.data.Ricetta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raffaele Francesco Mancino
 */

@RestController
public class RestDemoController
{
    private List<String> dataList = new ArrayList<String>(Arrays.asList("Spring","Rest","SRC"));
    
    @RequestMapping("/getData")
    public Data getData(@RequestParam(value="id") Integer id)
    {
        return new Data(id, dataList.get(id));
    }
    
    @RequestMapping("/getAllData")
    public List<Data> getData()
    {
        List<Data> list = new ArrayList<>();
        for (int i=0; i<dataList.size(); i++)
        {
            list.add(new Data(i, dataList.get(i)));
        }
        return list;
    }
    
    @RequestMapping("/ricettafindall")
    public Bean ricettaFindAll()
    {
        Session session = new HibernateConf().session;
        //List<Ricetta> ricette= session.createQuery("SELECT r FROM Ricetta r").list();
        List<Ricetta> ricette;
        ricette = session.getNamedQuery("Ricetta.findAll").list();
        
        
        Bean a = new Bean();
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
