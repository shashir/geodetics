package com.autodidactus.geodetics.euclidean;

import java.lang.Math;

public class Unit {
	private EVector actualPos;
	private EVector perceivedPos;
	public Unit(EVector actualPos, EVector perceivedPos) {
		this.actualPos = actualPos;
		this.perceivedPos = perceivedPos;
	}
	public Unit(EVector actualPos) {
		this.actualPos = actualPos;
		this.perceivedPos = actualPos;
	}
	public EVector getActualPos() {
		return this.actualPos;
	}
	public EVector getPerceivedPos() {
		return this.perceivedPos;
	}
	public void setActualPos(EVector actualPos) {
		this.actualPos = actualPos;
	}
	public void setPerceivedPos(EVector perceivedPos) {
		this.perceivedPos = perceivedPos;
	}
	public String toString() {
		return String.format("%s <-- %s", getActualPos(), getPerceivedPos());
	}
	public void move(Unit ref) {
		EVector actualDiff = ref.getActualPos().sub(actualPos);
		double actualDist = actualDiff.norm();
		EVector perceivedDiff = ref.getPerceivedPos().sub(perceivedPos);
		double perceivedDist = perceivedDiff.norm();
		System.out.println("Perceived: " + perceivedDist + ", Actual: " + actualDist);
		System.out.println("Line of movement: " + perceivedDiff.normalize());
		EVector increment = perceivedDiff.normalize().scale((perceivedDist - actualDist)/1.2);
		System.out.println("Increment norm: " + increment);
		perceivedPos = perceivedPos.add(increment);
	}
}
