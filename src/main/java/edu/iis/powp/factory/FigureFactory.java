package edu.iis.powp.factory;

public class FigureFactory implements IFigureFactory {

	@Override
	public Square getSquare() {
		// TODO Auto-generated method stub
		return new Square();
	}

	@Override
	public Circle getCircle() {
		// TODO Auto-generated method stub
		return new Circle();
	}

}
