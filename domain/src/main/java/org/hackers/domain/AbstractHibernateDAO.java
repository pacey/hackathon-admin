package org.hackers.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@SuppressWarnings("unchecked")
	public DomainType get(Long id) {
		return (DomainType)sessionFactory.getCurrentSession().get(domainClass.getClass(), id);
	}

}
