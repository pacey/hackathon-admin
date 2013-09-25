package org.hackers.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional(propagation = Propagation.REQUIRED)
public abstract class AbstractHibernateDAO<DomainType> implements DAO<DomainType> {

	protected Class<DomainType> domainClass;
	protected SessionFactory sessionFactory;

	public AbstractHibernateDAO(Class<DomainType> domainClass) {
		this.domainClass = domainClass;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public void saveOrUpdate(DomainType domainType){
		sessionFactory.getCurrentSession().saveOrUpdate(domainType);
	}

	public void delete(DomainType domainType){
		sessionFactory.getCurrentSession().delete(domainType);
	}

	public void delete(Long id){
		delete(get(id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public DomainType get(Long id) {
		return (DomainType)sessionFactory.getCurrentSession().get(domainClass, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<DomainType> getAll() {
		return (Collection<DomainType>)sessionFactory.getCurrentSession().createCriteria(domainClass).list();
	}
}
