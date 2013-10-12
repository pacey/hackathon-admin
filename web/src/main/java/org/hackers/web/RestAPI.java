package org.hackers.web;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public abstract class RestAPI<DomainType, FormType> {
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public abstract @ResponseBody DomainType get(@PathVariable Long id);

	@RequestMapping(method = RequestMethod.GET)
	public abstract @ResponseBody Collection<DomainType> get();

	@RequestMapping(method = RequestMethod.POST)
	public abstract @ResponseBody DomainType post(@RequestBody FormType formType);

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public abstract @ResponseBody DomainType put(@PathVariable Long id, @RequestBody FormType formType);

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public abstract @ResponseBody Boolean delete(@PathVariable Long id);
}
