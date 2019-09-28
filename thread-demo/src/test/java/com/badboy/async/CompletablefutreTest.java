package com.badboy.async;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;


public class CompletablefutreTest {
	
	@Test
	public void testName() throws Exception {
		    CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
//		        assertTrue("dddddddd",Thread.currentThread().isDaemon());
		        System.out.println("111111");
		        try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println("22222");
		        return s.toUpperCase();
		    });
		    System.out.println("3333");
//		    assertNull("ccccccc",cf.getNow(null));
		    System.out.println("44444");
		    assertEquals("MESSAGE", cf.join());
		    System.out.println("55555");
	}

}
