package edu.iis.powp.factory;

import java.util.ArrayList;

import edu.iis.powp.hierarchy.CommandDrawLineToPosition;
import edu.iis.powp.hierarchy.CommandSetPosition;
import edu.iis.powp.hierarchy.ComplexCommand;
import edu.iis.powp.hierarchy.PlotterCommand;

public class FigureFactory implements IFigureFactory {

	@Override
	public ComplexCommand getSquare() {
		// TODO Auto-generated method stub
		ArrayList<PlotterCommand> listPlotterCommand = new ArrayList<>();
		listPlotterCommand.add(new CommandSetPosition(0,0));
		listPlotterCommand.add(new CommandDrawLineToPosition(0,150));
		listPlotterCommand.add(new CommandSetPosition(0,150));
		listPlotterCommand.add(new CommandDrawLineToPosition(150,150));
		listPlotterCommand.add(new CommandSetPosition(150,150));
		listPlotterCommand.add(new CommandDrawLineToPosition(150,0));
		listPlotterCommand.add(new CommandSetPosition(150,0));
		listPlotterCommand.add(new CommandDrawLineToPosition(0,0));
		
		return new Square(listPlotterCommand);
	}

	@Override
	public ComplexCommand getTriangle() {
		// TODO Auto-generated method stub
		ArrayList<PlotterCommand> listPlotterCommand = new ArrayList<>();
		listPlotterCommand.add(new CommandSetPosition(0,0));
		listPlotterCommand.add(new CommandDrawLineToPosition(100,200));	
		listPlotterCommand.add(new CommandSetPosition(100,200));
		listPlotterCommand.add(new CommandDrawLineToPosition(200,0));
		listPlotterCommand.add(new CommandSetPosition(200,0));
		listPlotterCommand.add(new CommandDrawLineToPosition(0,0));
	
		return new Triangle(listPlotterCommand);
	}

}
