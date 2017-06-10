package com.data.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.data.dao.api.StoreDao;
import com.data.dao.vo.Store;

public class StoreDaoImpl implements StoreDao{

	 @PersistenceContext(unitName = "store") 
	 private EntityManager em;

		public Store addStore(Store store) {
			System.out.println("Annotated Entity Manager::" + em);
			ClassLoader previous = Thread.currentThread().getContextClassLoader();
			try
			{
				
				if (em == null) {
					Map<String, String> props = new HashMap<String, String>();
					Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
					EntityManagerFactory emf = Persistence.createEntityManagerFactory("store", props);
					em = emf.createEntityManager();
		
					System.out.println("Created Entiry Manager::" + em);
				}
		
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.persist(store);
				em.flush();
				tx.commit();
				return store;
			}catch(Exception e)
			{
				Thread.currentThread().setContextClassLoader(previous);
				e.printStackTrace();
			}
			return null;
		}
}
