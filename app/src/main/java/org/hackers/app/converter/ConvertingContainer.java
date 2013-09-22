package org.hackers.app.converter;

import org.hackers.domain.container.Container;
import org.springframework.core.convert.converter.Converter;

public class ConvertingContainer<S, T> implements Container<T> {
	private Converter<S, T> converter;
	private S source;
	private T target;

	public ConvertingContainer(Converter<S, T> converter, S source) {
		this.converter = converter;
		this.source = source;
	}

	@Override
	public T get() {
		if( target == null ) {
			target = converter.convert(source);
		}
		return target;
	}
}

