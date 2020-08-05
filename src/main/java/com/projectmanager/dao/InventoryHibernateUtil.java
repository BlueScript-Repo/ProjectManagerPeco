package com.projectmanager.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.ManagedBean;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

@ManagedBean
public class InventoryHibernateUtil {
	   private static StandardServiceRegistry registry;
	   private static SessionFactory sessionFactory;

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory == null) {
	         try {

	            // Create registry builder
	            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

	            // Hibernate settings equivalent to hibernate.cfg.xml's properties
	            Map<String, String> settings = new HashMap<>();
	            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/inventoryMgmt");
	            settings.put(Environment.USER, "admin");
	            settings.put(Environment.PASS, "admin123");
	            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
	    	            
	            // Apply settings
	            registryBuilder.applySettings(settings);
	            // Create registry
	            registry = registryBuilder.build();

	            // Create MetadataSources
	            MetadataSources sources = new MetadataSources(registry);

	            // Create Metadata
	            Metadata metadata = sources.getMetadataBuilder().build();

	            // Create SessionFactory
	            sessionFactory = metadata.getSessionFactoryBuilder().build();
	            
	            
	         } catch (Exception e) {
	        	 
	        	 System.out.println("Exception creating sessionFactor : " + e.getCause()); 
	        	 e.printStackTrace();
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	         }
	      }
	      return sessionFactory;
	   }

	   public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }}
