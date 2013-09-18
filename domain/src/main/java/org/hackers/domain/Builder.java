package org.hackers.domain;

public interface Builder<Buildable> {
	Buildable build();
	void clear();
}
