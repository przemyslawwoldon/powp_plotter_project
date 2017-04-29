package edu.iis.powp.factory;

import java.util.ArrayList;

import edu.iis.powp.hierarchy.ComplexCommand;
import edu.iis.powp.hierarchy.PlotterCommand;

public class Triangle extends ComplexCommand{

	public Triangle(ArrayList<PlotterCommand> listPlotterCommand) {
		super(listPlotterCommand);
	}
}
