package com.autodidactus.geodetics.euclidean;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;
import org.math.plot.*;

public class TestUnit {

	/*@Test
	public void testToString() {
		Unit unit = new Unit(new EVector(0.1, 0.7));
		assertTrue(unit.toString().startsWith("(0.100000, 0.700000"));
	}*/
	
	@Test
	public void testMove() {
		
		// Unit mover = new Unit(new EVector((Math.random() - 0.5)*200, (Math.random() - 0.5)*200),
		//		new EVector((Math.random() - 0.5)*200, (Math.random() - 0.5)*200));
		/*
		Unit refOne = new Unit(new EVector((Math.random() - 0.5)*200, (Math.random() - 0.5)*200));
		Unit refTwo = new Unit(new EVector((Math.random() - 0.5)*200, (Math.random() - 0.5)*200));
		Unit refThree = new Unit(new EVector((Math.random() - 0.5)*200, (Math.random() - 0.5)*200));
		*/
		// Unit mover = new Unit(new EVector(-60.117037, 21.187969), new EVector(-11.614502, -48.258201));
		Unit mover = new Unit(new EVector(-60.117037, 21.187969), new EVector((Math.random() - 0.5)*200, (Math.random() - 0.5)*200));
		Unit refOne = new Unit(new EVector(-38.676720, -47.183376));
		Unit refTwo = new Unit(new EVector(1.389904, 89.472145));
		Unit refThree = new Unit(new EVector(51.338141, 29.301183));
		System.out.println(refOne + "\n" + refTwo + "\n" + refThree);
		
		double[] refX = {refOne.getActualPos().getX(), refTwo.getActualPos().getX(), refThree.getActualPos().getX()};
		double[] refY = {refOne.getActualPos().getY(), refTwo.getActualPos().getY(), refThree.getActualPos().getY()};
		double[] moverX = {mover.getActualPos().getX()};
		double[] moverY = {mover.getActualPos().getY()};
		
		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plot = new Plot2DPanel();
		// add a line plot to the PlotPanel
		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("a plot panel");
		frame.setContentPane(plot);
		frame.setSize(500, 500);
		frame.setVisible(true);
		plot.addScatterPlot("refs", refX, refY);
		plot.addScatterPlot("movers", moverX, moverY);
		int counter = 0;
		while (true) {
			if (counter % 3 == 0) { mover.move(refOne); }
			else if (counter % 3 == 1) { mover.move(refTwo); } 
			else if (counter % 3 == 2) { mover.move(refThree); }
			counter ++;
			System.out.println(mover);
			System.out.println("There yet? " + mover.getActualPos().sub(mover.getPerceivedPos()).norm());
			//System.out.println("Actual distance: " + ref.getActualPos().sub(mover.getActualPos()).norm());
			//System.out.println("Perceived distance: " + ref.getPerceivedPos().sub(mover.getPerceivedPos()).norm());
			double[] moverPX = {mover.getPerceivedPos().getX()};
			double[] moverPY = {mover.getPerceivedPos().getY()};
			plot.addScatterPlot("mover perceived", moverPX, moverPY);
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}
}
