package com.lepu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/****
 * 专门用于单独对Hibernate使用的Dao支持 抽象类
 * 
 * @author Swinglife
 *
 * @param <T>
 */
public abstract class HibernateDaoSupport<T> implements BaseDao<T> {

	protected static SessionFactory sessionFactory;
	protected static StandardServiceRegistry registry;
	public static Session session;

	public HibernateDaoSupport() {
		if (registry == null) {
			registry = new StandardServiceRegistryBuilder().configure().build();
		}
		if (sessionFactory == null) {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
	}

}
