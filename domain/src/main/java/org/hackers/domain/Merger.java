package org.hackers.domain;

public interface Merger<S,T> {

	T merge(S source, T target);

}
