package org.hackers.app.idea;

import org.hackers.domain.container.Container;

import java.util.Collection;

public interface RestFacade<DTOType, DomainType> {
	Collection<DomainType> get();
	DomainType get(Long id);
	DomainType put(Long id, Container<DTOType> dtoType);
	DomainType post(Container<DTOType> dtoType);
	void delete(Long id);
}
