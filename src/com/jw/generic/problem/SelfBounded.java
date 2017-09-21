package com.jw.generic.problem;

import com.jw.util.Son;

class SelfBounded<T extends SelfBounded<T>>{
    T element;
    SelfBounded<T> set(T arg){
         element=arg;
         return this;
    }
    T get(){
         return element;
    }
    static <T extends SelfBounded<T>> T f(T arg){
    	return arg.set(arg).get();
    }
}