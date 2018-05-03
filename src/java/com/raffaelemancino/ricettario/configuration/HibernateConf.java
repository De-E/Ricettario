/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public class HibernateConf
{
    
    private Configuration configuration;
    private SessionFactory sessionFactory;
    public Session session;

    public HibernateConf()
    {
        this.configuration = new Configuration().configure("/hibernate.cfg.xml");
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        
        this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        this.session = this.sessionFactory.openSession();
    }
    
    public Session newSession()
    {
        return this.sessionFactory.openSession();
    }
}
