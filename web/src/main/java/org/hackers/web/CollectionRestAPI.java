package org.hackers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

public abstract class CollectionRestAPI<DomainType, DTOType> {

	@RequestMapping(method = RequestMethod.GET)
	public abstract @ResponseBody Collection<DomainType> get();

	@RequestMapping(method = RequestMethod.PUT)
	public abstract void put(@RequestBody Collection<DTOType> dtoTypeCollection);

	@RequestMapping(method = RequestMethod.POST)
	public abstract void post(@RequestBody DTOType dtoType);

	@RequestMapping(method = RequestMethod.DELETE)
	public abstract void delete();
}
