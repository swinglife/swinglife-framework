package com.lepu.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lepu.dao.BaseDao;

/****
 * 公共的Dao
 * 
 * @author Xujingxi
 *
 */
public class CommonDao<T> implements BaseDao<T> {

	private static Logger logger = Logger.getLogger(CommonDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public T load(Class<T> clazz, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public T get(Class<T> clazz, Integer id) {
		logger.info("Get User");
		T t = null;
		t = sessionFactory.getCurrentSession().get(clazz, id);
		return t;
	}

	public T findObjectByHQL(String HQL) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> findByHQL(String HQL) {
		List<T> list = null;
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		list = query.list();
		return list;
	}

	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public T findObjectByHQL(String HQL, Object[] args) {
		T t = null;
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setMaxResults(1);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		List<T> list = query.list();
		if (list != null && list.size() > 0) {
			t = list.get(0);
		}
		return t;
	}

	public List<T> findByHQL(String HQL, Object[] args) {
		List<T> list = null;
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		list = query.list();
		return list;
	}

	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public void del(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	public void cloaseSession() {
		// TODO Auto-generated method stub

	}

	public void clearSession() {
		// TODO Auto-generated method stub

	}

	public void flushSession() {
		// TODO Auto-generated method stub

	}

}
