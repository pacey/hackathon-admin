package org.hackers.domain;

public interface DAO<DomainType> {
	void saveOrUpdate(DomainType domainType);
	void delete(DomainType domainType);
	DomainType get(Long id);
}
