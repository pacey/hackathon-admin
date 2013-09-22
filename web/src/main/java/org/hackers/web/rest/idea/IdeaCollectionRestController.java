package org.hackers.web.rest.idea;

import org.hackers.app.idea.RestFacade;
import org.hackers.domain.idea.Idea;
import org.hackers.web.CollectionRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping("/api/idea")
public class IdeaCollectionRestController extends CollectionRestAPI<Idea, IdeaForm> {

	@Autowired
	private RestFacade<Idea> ideaRestFacade;

	@Override
	public @ResponseBody Collection<Idea> get() {
		return ideaRestFacade.get();
	}

	@Override
	public void put(@RequestBody Collection<IdeaForm> ideaForms) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void post(@RequestBody IdeaForm ideaForm) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void delete() {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
