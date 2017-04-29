package edu.iis.powp.factory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.app.Application;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.hierarchy.PlotterCommand;

public class SelectTestFigureOptionComplexCommand implements ActionListener{

	private PlotterCommand plotterCommand;
	
	public SelectTestFigureOptionComplexCommand(PlotterCommand plotterCommand) {
		super();
		this.plotterCommand = plotterCommand;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		plotterCommand.execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
	}
	
}
