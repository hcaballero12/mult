package com.lokiton.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lokiton.entities.Group;
import com.lokiton.entities.Lokiton;

public class TestRelation {
	
	Session session = null;
	SessionFactory sessionFactory = null;
	Transaction tx = null;
	
	public void setup(){
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public static void main(String[] args) {
		
		TestRelation tr = new TestRelation();
		tr.setup();
		
		Set<Lokiton> setL = new HashSet<Lokiton>();
		Set<Group> setg = new HashSet<Group>();
		Lokiton lok1 = new Lokiton();
		Lokiton lok2 = new Lokiton();
		Lokiton lok3 = new Lokiton();
		
		Group group1 = new Group();
		Group group2 = new Group();
		
		lok1.setEmail("someemail@email.com");
		lok1.setUser("someUser");
		lok1.setGroup(setg);
		
		lok2.setEmail("another@email.com");
		lok2.setUser("anotherUser");
		lok2.setGroup(setg);
		
		lok3.setEmail("whoKnowsWhos@email.com");
		lok3.setUser("whocares");
		lok3.setGroup(setg);
		
		group1.setName("group1");
		group1.setLokitons(setL);
		group2.setName("group2");
		group2.setLokitons(setL);
		

		
		lok1.getGroup().add(group1);
		lok1.getGroup().add(group2);

		lok2.getGroup().add(group1);
		
		lok3.getGroup().add(group2);
		
		group1.getLokitons().add(lok1);
		group1.getLokitons().add(lok2);
		group1.setNumOfMembers(group1.getLokitons().size());
		
		group2.getLokitons().add(lok1);
		group2.getLokitons().add(lok3);
		group2.setNumOfMembers(group2.getLokitons().size());
	
		
		

		tr.tx = tr.session.beginTransaction();
		tr.session.save(group1);
		tr.session.save(group2);
		tr.tx.commit();
		tr.session.close();
		
		
		
	}

}
