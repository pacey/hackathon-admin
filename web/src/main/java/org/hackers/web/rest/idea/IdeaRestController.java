package org.hackers.web.rest.idea;

import org.hackers.app.converter.ConvertingContainer;
import org.hackers.app.idea.IdeaFacade;
import org.hackers.app.idea.RestFacade;
import org.hackers.domain.idea.Idea;
import org.hackers.web.RestAPI;
import org.hackers.web.converter.IdeaFormIdeaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/idea/{id}")
public class IdeaRestController extends RestAPI<Idea,IdeaForm> {

	@Autowired
	private RestFacade<Idea> ideaFacade;

	@Autowired
	private IdeaFormIdeaConverter ideaFormIdeaConverter;

	@Override
	public Idea get(@PathVariable Long id) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void put(@RequestBody IdeaForm ideaForm) {
		ideaFacade.put(new ConvertingContainer<>(ideaFormIdeaConverter, ideaForm));
	}

	@Override
	public void delete(@PathVariable Long id) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
