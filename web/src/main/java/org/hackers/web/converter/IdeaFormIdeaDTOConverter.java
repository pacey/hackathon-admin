package org.hackers.web.converter;

import org.hackers.domain.idea.IdeaDTO;
import org.hackers.web.rest.idea.IdeaForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IdeaFormIdeaDTOConverter implements Converter<IdeaForm, IdeaDTO> {

	@Override
	public IdeaDTO convert(IdeaForm ideaForm) {
		IdeaDTO ideaDTO = new IdeaDTO();
		ideaDTO.setDescription(ideaForm.getDescription());
		ideaDTO.setTitle(ideaForm.getTitle());
		ideaDTO.setId(ideaForm.getId());
		ideaDTO.setCreateDate(ideaForm.getCreateDate());
		ideaDTO.setUpdateDate(ideaForm.getUpdateDate());
		return ideaDTO;
	}

}
