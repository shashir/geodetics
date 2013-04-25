package com.autodidactus.geodetics.euclidean;

public class EVector {
	private final double[] vector = new double[3];

	private static final double zero = 0.00000001;
	public EVector(double x, double y) {
		vector[0] = x;
		vector[1] = y;
		vector[2] = 0.0;
	}
	
	public EVector(double x, double y, double z) {
		vector[0] = x;
		vector[1] = y;
		vector[2] = z;
	}

	public double getX() {
		return vector[0];
	}
	public double getY() {
		return vector[1];
	}
	public double getZ() {
		return vector[2];
	}
	
	@Override
	public String toString() {
		return String.format("(%f, %f, %f)", getX(), getY(), getZ());
	}

	public EVector sub(EVector other) {
		return new EVector(this.getX() - other.getX(), this.getY() - other.getY(), this.getZ() - other.getZ());
	}
	
	public EVector add(EVector other) {
		return new EVector(this.getX() + other.getX(), this.getY() + other.getY(), this.getZ() + other.getZ());
	}
	
	public double norm() {
		return Math.sqrt(this.dot(this));
	}
	
	public EVector normalize() {
		double normOfA = norm();
		if (isZero(normOfA)) {
			throw new IllegalArgumentException("Can not normalize zero vector, bitch.");
		}
		return new EVector(getX() / normOfA, getY() / normOfA, getZ() / normOfA);
	}
	
	public double dot(EVector other) {
		return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ();
	}
	
	public EVector scale(double s) {
		return new EVector(s * getX(), s * getY(), s * getZ());
	}
	
	public static boolean isZero(double num) {
		return Math.abs(num) <= zero;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this) return true;
		
		if (object == null) return false;
		
		if (!object.getClass().equals(this.getClass())) return false;
		EVector other = (EVector) object;
		return isZero(Math.abs(this.getX() - other.getX()) + Math.abs(this.getY() - other.getY()) + Math.abs(this.getZ() - other.getZ()));
	}
}
