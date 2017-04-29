package edu.iis.powp.factory;

import edu.iis.powp.hierarchy.ComplexCommand;

public interface IFigureFactory {

	public ComplexCommand getSquare();
	
	public ComplexCommand getTriangle();
	
}
