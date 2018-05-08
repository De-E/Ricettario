
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.core;

import com.raffaelemancino.ricettario.configuration.Application;
import com.raffaelemancino.ricettario.data.view.IngredientiPerRicetta;
import com.raffaelemancino.ricettario.data.Ingredient;
import com.raffaelemancino.ricettario.data.Recipe;
import com.raffaelemancino.ricettario.data.Recipeingredient;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.TransactionStatus;
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
    private Session session = Application.hibernate.newSession();
    
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
        
        String query = "SELECT qt, unit, i.namei FROM recipe AS r JOIN ( recipeingredient AS ri NATURAL JOIN ingredient AS i) ON r.idr = ri.idr AND r.idr = :idr";
        ret = (List<IngredientiPerRicetta>)this.session.createSQLQuery(query)
                .setInteger("idr", idr)
                .setResultTransformer(Transformers.aliasToBean(IngredientiPerRicetta.class))
                .list();
        return ret;
    }
    
    @RequestMapping(value = "/insertR", method = RequestMethod.POST)
    public Integer ricettaInsert(@RequestBody Recipe recipe)
    {
        this.session = Application.hibernate.newSession();
        Integer i = (Integer)this.session.createSQLQuery("SELECT MAX(idr) FROM recipe").list().get(0);
        recipe.setIdr(i+1);        
        try
        {
            Transaction tx = null;
            tx = this.session.beginTransaction();
            //Recipe r = (Recipe) session.merge(recipe);
            this.session.saveOrUpdate(recipe);
            tx.commit();
            return i+1;
        } catch (Exception e)
        {
            
            return -1;
        }
    }
    
    @RequestMapping(value = "/searchR", method = RequestMethod.GET)
    public List searchRecipe(@RequestParam String param)
    {
        List<Recipe> ret;
        String query = "SELECT * FROM recipe WHERE LOWER(namer) LIKE LOWER('%" + param + "%')";
        ret = this.session.createSQLQuery(query)
                .setResultTransformer(Transformers.aliasToBean(Recipe.class))
                .list();
        
        return ret;
    }
    
    @RequestMapping(value = "/listI", method = RequestMethod.GET)
    public List listIngredients()
    {
        List<Ingredient> ret;
        
        String query = "SELECT * FROM ingredient";
        
        ret = this.session.createSQLQuery(query)
                .setResultTransformer(Transformers.aliasToBean(Ingredient.class))
                .list();
        
        return ret;
    }
    
    @RequestMapping(value = "/insertRI", method = RequestMethod.POST)
    public void insertRecipeInsert(@RequestBody ArrayList<Recipeingredient> recipeIngredients)
    {
        Transaction tx = null;
        tx = this.session.beginTransaction();
        
        try
        {
            for(int i=0; i<recipeIngredients.size(); i++)
            {
                //Recipe r = (Recipe) session.merge(recipe);
                this.session.saveOrUpdate(recipeIngredients.get(i));
                
            }
            tx.commit();
        } catch (Exception ex)
        {
            if(tx != null)
            {
                tx.rollback();
            }
        }
    }
    
    @RequestMapping(value = "/insertI", method = RequestMethod.POST)
    public boolean insertIngredient(@RequestBody Ingredient ingredient)
    {
        //this.session = Application.hibernate.newSession();
        Integer i = (Integer)this.session.createSQLQuery("SELECT MAX(idi) FROM ingredient").list().get(0);
        ingredient.setIdi(i+1);
        try
        {
            Transaction tx = null;
            tx = this.session.beginTransaction();
            //Recipe r = (Recipe) session.merge(recipe);
            this.session.save(ingredient);
            tx.commit();
            return true;
        } catch (Exception e)
        {
            System.out.println(e.toString());
            return false;
        }
    }
}
