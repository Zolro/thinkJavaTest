package com.jw.big.problem;

public interface Collector<T> extends UnaryFunction<T, T>{
	T result();
}
