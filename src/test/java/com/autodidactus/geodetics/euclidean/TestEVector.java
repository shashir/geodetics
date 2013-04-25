package com.autodidactus.geodetics.euclidean;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestEVector {

	@Test
	public void testToString() {
		EVector vector = new EVector(0.1, 0.7);
		assertTrue(vector.toString().startsWith("(0.100000, 0.700000"));
	}
	
	@Test(expected = IllegalArgumentException.class)  
	public void testZeroVectorNormalize() {
		EVector vector = new EVector(0, 0, 0);
		vector.normalize();
	}
	
	@Test
	public void testNorm() {
		EVector vector = new EVector(1, 1, 1);
		assertTrue(EVector.isZero(Math.sqrt(3) - vector.norm()));
	}
	
	@Test
	public void testNormalize() {
		EVector vector = new EVector(Math.random(), Math.random(), Math.random());
		assertTrue(EVector.isZero(vector.normalize().norm() - 1.0));
	}
	
	@Test
	public void testArithmetic() {
		EVector vector = new EVector(Math.random(), Math.random(), Math.random());
		EVector zero = new EVector(0, 0, 0);
		EVector two = vector.scale(2.0);
		assertTrue(zero.equals(vector.sub(vector)));
		assertTrue(two.equals(vector.add(vector)));
	}
}
