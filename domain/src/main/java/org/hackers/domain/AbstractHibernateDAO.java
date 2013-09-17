package org.hackers.domain;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.Collection;

public class AbstractHibernateDAO<DomainType> extends HibernateDaoSupport implements DAO<DomainType> {

	private Class<DomainType> domainClass;

	public AbstractHibernateDAO(Class<DomainType> domainClass) {
		this.domainClass = domainClass;
	}

	public void saveOrUpdate(DomainType domainType){
		getHibernateTemplate().saveOrUpdate(domainType);
	}

	public void delete(DomainType domainType){
		getHibernateTemplate().delete(domainType);
	}

	@Override
	@SuppressWarnings("unchecked")
	public DomainType get(Long id) {
		return (DomainType)getHibernateTemplate().get(domainClass.getClass(), id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<DomainType> getAll() {
		return (Collection<DomainType>)getHibernateTemplate().loadAll(domainClass.getClass());
	}

}
