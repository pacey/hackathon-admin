package org.hackers.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created with IntelliJ IDEA.
 * User: jamesp
 * Date: 20/09/13
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
public abstract class RestAPI<DomainType, DTOType> {
	public abstract DomainType get(@PathVariable Long id);
	public abstract void put(@RequestBody DTOType dtoType);
	public abstract void delete(@PathVariable Long id);
}
