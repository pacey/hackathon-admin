package org.hackers.app.idea;

import java.util.Collection;

public interface CollectionRestFacade<DomainType, DtoType> {
	Collection<DomainType> get();
	void put(Collection<DtoType> dtoTypeCollection);
	void post(DtoType dtoType);
	void delete();
}
