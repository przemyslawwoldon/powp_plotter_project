package edu.iis.powp.hierarchy;

import java.util.ArrayList;

import edu.iis.client.plottermagic.IPlotter;

public class ComplexCommand implements PlotterCommand{
	
	private ArrayList<PlotterCommand> listPlotterCommand = new ArrayList<>();
	
	public ComplexCommand(ArrayList<PlotterCommand> listPlotterCommand) {
		this.listPlotterCommand = listPlotterCommand;
	}

	@Override
	public void execute(IPlotter iPlotter) {
		for(PlotterCommand plotterCommand : listPlotterCommand) {
			plotterCommand.execute(iPlotter);
		}
	}
	
}
