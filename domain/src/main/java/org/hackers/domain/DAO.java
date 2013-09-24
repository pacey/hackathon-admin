package org.hackers.domain;

import java.util.Collection;

public interface DAO<DomainType> {
	void saveOrUpdate(DomainType domainType);
	void delete(DomainType domainType);
	void delete(Long id);
	DomainType get(Long id);
	Collection<DomainType> getAll();
}
