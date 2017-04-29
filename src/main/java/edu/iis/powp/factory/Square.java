package edu.iis.powp.factory;

import java.util.ArrayList;

import edu.iis.powp.hierarchy.ComplexCommand;
import edu.iis.powp.hierarchy.PlotterCommand;

public class Square extends ComplexCommand{
	
	public Square(ArrayList<PlotterCommand> listPlotterCommand) {
		super(listPlotterCommand);
	}

}
