package com.jw.generic.problem;

public interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
	void set(T arg);
}
