package org.hackers.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: jamesp
 * Date: 20/09/13
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
public abstract class RestAPI<DomainType, DTOType> {
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public abstract @ResponseBody DomainType get(@PathVariable Long id);

	@RequestMapping(method = RequestMethod.GET)
	public abstract @ResponseBody Collection<DomainType> get();

	@RequestMapping(method = RequestMethod.POST)
	public abstract @ResponseBody DomainType post(@RequestBody DTOType dtoType);

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public abstract @ResponseBody DomainType put(@PathVariable Long id, @RequestBody DTOType dtoType);

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public abstract void delete(@PathVariable Long id);
}
