package org.dean.duck.core.concurrent.container;

public interface Computable<A, V> {
	V compute(A args) throws InterruptedException;
}
