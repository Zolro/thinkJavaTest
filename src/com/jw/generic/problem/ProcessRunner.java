package com.jw.generic.problem;


import java.util.ArrayList;
import java.util.List;

public class ProcessRunner<T,E extends Exception> extends ArrayList<Processor<T,E>>{
	List<T> processAll() throws E{
		List<T> resultCollector=new ArrayList<T>();
		for(Processor<T,E> proccessor:this)
			proccessor.process(resultCollector);
		return resultCollector;
	}
		
}
