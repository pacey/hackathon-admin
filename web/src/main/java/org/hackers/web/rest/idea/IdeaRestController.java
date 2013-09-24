package org.hackers.web.rest.idea;

import org.hackers.app.converter.ConvertingContainer;
import org.hackers.app.idea.RestFacade;
import org.hackers.domain.idea.Idea;
import org.hackers.domain.idea.IdeaDTO;
import org.hackers.web.RestAPI;
import org.hackers.web.converter.IdeaFormIdeaDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;


@Controller
@RequestMapping("/api/idea")
public class IdeaRestController extends RestAPI<Idea, IdeaDTO, IdeaForm> {

	@Autowired
	private RestFacade<IdeaDTO, Idea> ideaFacade;

	@Autowired
	private IdeaFormIdeaDTOConverter ideaFormIdeaDTOConverter;

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
		return ideaFacade.post(new ConvertingContainer<>(ideaFormIdeaDTOConverter, ideaForm));
	}

	@Override
	public Idea put(@PathVariable Long id, @RequestBody IdeaForm ideaForm) {
		return ideaFacade.put(id, new ConvertingContainer<>(ideaFormIdeaDTOConverter, ideaForm));
	}

	@Override
	public void delete(@PathVariable Long id) {
		ideaFacade.delete(id);
	}
}
