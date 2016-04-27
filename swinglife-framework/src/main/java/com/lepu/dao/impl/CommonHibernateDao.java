package com.lepu.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.lepu.dao.HibernateDaoSupport;

public class CommonHibernateDao<T> extends HibernateDaoSupport<T> {

	private static Logger logger = Logger.getLogger(CommonHibernateDao.class);

	public T load(Class<T> clazz, Integer id) {
		T t = null;
		if (session == null) {
			session = sessionFactory.openSession();
		}
		session.beginTransaction();
		t = session.load(clazz, id);
		session.getTransaction().commit();
		return t;
	}

	public T get(Class<T> clazz, Integer id) {
		T t = null;
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		t = session.get(clazz, id);
		session.getTransaction().commit();
		return t;
	}

	public T findObjectByHQL(String HQL) {
		T t = null;
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(HQL);
		query.setMaxResults(1);
		List<T> list = query.list();
		if (list == null && list.size() > 0) {
			return null;
		}
		return list.get(0);
	}

	public List<T> findByHQL(String HQL) {
		List<T> list = null;
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(HQL);
		list = query.list();
		if (list == null && list.size() > 0) {
			return null;
		}
		return list;
	}

	public void save(T t) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}

	public T findObjectByHQL(String HQL, Object[] args) {
		T t = null;
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(HQL);
		query.setMaxResults(1);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		List<T> list = query.list();
		if (list == null && list.size() > 0) {
			return null;
		}
		return list.get(0);
	}

	public List<T> findByHQL(String HQL, Object[] args) {
		List<T> list = null;
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(HQL);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		list = query.list();
		if (list == null && list.size() > 0) {
			return null;
		}
		return list;
	}

	public void update(T t) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
	}

	public void del(T t) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(t);
		session.getTransaction().commit();
	}

	public void cloaseSession() {
		if (session != null && session.isOpen()) {
			logger.info("\nSession:" + session + "\n被手工关闭");
			session.close();
			logger.info("开启的Session数量:" + sessionFactory.getStatistics().getSessionOpenCount());
			logger.info("关闭的Session数量:" + sessionFactory.getStatistics().getSessionCloseCount());
		}
	}

	public void clearSession() {

	}

	public void flushSession() {

	}

}
