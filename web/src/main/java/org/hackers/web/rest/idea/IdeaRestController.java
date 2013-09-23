package org.hackers.web.rest.idea;

import org.hackers.app.converter.ConvertingContainer;
import org.hackers.app.idea.RestFacade;
import org.hackers.domain.idea.Idea;
import org.hackers.web.RestAPI;
import org.hackers.web.converter.IdeaFormIdeaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;


@Controller
@RequestMapping("/api/idea")
public class IdeaRestController extends RestAPI<Idea,IdeaForm> {

	@Autowired
	private RestFacade<Idea> ideaFacade;

	@Autowired
	private IdeaFormIdeaConverter ideaFormIdeaConverter;

	@Override
	public Idea get(@PathVariable Long id) {
		return ideaFacade.get(id);
	}

	@Override
	public Collection<Idea> get() {
		return ideaFacade.get();
	}

	@Override
	public Idea post(@RequestBody IdeaForm ideaForm) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Idea put(@PathVariable Long id, @RequestBody IdeaForm ideaForm) {
		return ideaFacade.put(new ConvertingContainer<>(ideaFormIdeaConverter, ideaForm));
	}

	@Override
	public void delete(@PathVariable Long id) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
