/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.core;

import com.raffaelemancino.ricettario.configuration.Application;
import com.raffaelemancino.ricettario.core.view.IngredientiPerRicetta;
import com.raffaelemancino.ricettario.data.Recipe;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
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
        List<Recipe> ret;
        
        String query = "SELECT * FROM recipe LIMIT 100";
        ret = this.session.createSQLQuery(query)
                .setResultTransformer(Transformers.aliasToBean(Recipe.class))
                .list();
        
        return ret;
    }
    
    @RequestMapping(value = "/readR", method = RequestMethod.GET)
    public Recipe ricettaFind(@RequestParam int idr)
    {
        String query = "SELECT * FROM recipe AS i WHERE i.idr = :idr";
        
        Recipe ret = (Recipe)this.session.createSQLQuery(query)
            .setInteger("idr", idr)
            .setResultTransformer(Transformers.aliasToBean(Recipe.class))
            .list()
            .get(0);
        
        return ret;
    }
    
    @RequestMapping(value = "/readIR", method = RequestMethod.GET)
    public List getIngredientsRecipe(@RequestParam int idr)
    {
        List<IngredientiPerRicetta> ret = new ArrayList<>();
        
        String query = "SELECT qt, unit, i.name FROM recipe AS r JOIN ( recipeingredient AS ri NATURAL JOIN ingredient AS i) ON r.idr = ri.idr AND r.idr = :idr";
        ret = (List<IngredientiPerRicetta>)this.session.createSQLQuery(query)
                .setInteger("idr", idr)
                .setResultTransformer(Transformers.aliasToBean(IngredientiPerRicetta.class))
                .list();
        return ret;
    }
    
    @RequestMapping(value = "/insertR", method = RequestMethod.POST)
    public boolean ricettaInsert(@RequestBody Recipe ricetta)
    {
        Integer i = (Integer)this.session.createQuery("SELECT MAX(idr) FROM recipe").list().get(0);
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
    
    @RequestMapping(value = "/searchR", method = RequestMethod.GET)
    public List searchRecipe(@RequestParam String param)
    {
        List<Recipe> ret;
        String query = "SELECT * FROM recipe WHERE LOWER(name) LIKE LOWER('%" + param + "%')";
        ret = this.session.createSQLQuery(query)
                .setResultTransformer(Transformers.aliasToBean(Recipe.class))
                .list();
        
        return ret;
    }
}
