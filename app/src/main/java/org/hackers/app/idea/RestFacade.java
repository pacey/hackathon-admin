package org.hackers.app.idea;

import org.hackers.domain.container.Container;

import java.util.Collection;

public interface RestFacade<DomainType> {
	Collection<DomainType> get();
	DomainType get(Long id);
	DomainType put(Container<DomainType> dtoType);
	void delete(Long id);
}
