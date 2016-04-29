package com.lepu.dao;

import java.util.List;

/***
 * 基础的Dao
 * 
 * @author Xujingxi
 *
 * @param <T>
 */
public interface BaseDao<T> {
	public T load(Class<T> clazz, Integer id);

	public T get(Class<T> clazz, Integer id);

	public T findObjectByHQL(String HQL);

	public List<T> findByHQL(String HQL);

	public void save(T t);

	public T findObjectByHQL(String HQL, Object[] args);

	public List<T> findByHQL(String HQL, Object[] args);

	public void update(T t);

	public void del(T t);
	
	public void isDelete(T t);

	public void cloaseSession();

	public void clearSession();

	public void flushSession();
}
