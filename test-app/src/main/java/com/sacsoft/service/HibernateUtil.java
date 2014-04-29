package com.sacsoft.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static{
		try{
			Configuration cfg = new Configuration();
			cfg.setProperty("connection.driver_class", "org.h2.Driver" );
			"connection.url","jdbc:h2:tcp://localhost/d:/data/sample;IFEXISTS=TRUE" 
	        <property name="connection.username">sa</property> 
	        <property name="connection.password">123456</property>               
	    
	        <!-- SQL dialect --> 
	        <property name="dialect">org.hibernate.dialect.H2Dialect</property> 

	        <!-- Enable Hibernate's automatic session context management --> 
	        <property name="current_session_context_class">thread</property> 

	        <!-- Disable the second-level cache  --> 
	        <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property> 

	        <!-- Echo all executed SQL to stdout --> 
	        <property name="show_sql">true</property> 
			
			
		}catch(Throwable ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
}
