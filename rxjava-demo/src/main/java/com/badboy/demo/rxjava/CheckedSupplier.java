package com.badboy.demo.rxjava;

/**
 * A {@linkplain java.util.function.Supplier} which may throw.
 *
 * @param <R> the type of results supplied by this supplier
 * @author baojie
 * @since 1.0.0 hello
 */

@FunctionalInterface
public interface CheckedSupplier<R> {    

	/**
	 * Gets a result.
	 *
	 * @return a result
	 * @throws Throwable if an error occurs
	 */
	R get() throws Throwable;
}
