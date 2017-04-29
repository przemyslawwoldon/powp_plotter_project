package edu.iis.powp.hierarchy;

import edu.iis.client.plottermagic.IPlotter;

public class CommandSetPosition implements PlotterCommand{

	private int x;
	private int y;
	
	public CommandSetPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void execute(IPlotter iPlotter) {
		// TODO Auto-generated method stub
		iPlotter.setPosition(this.x, this.y);
	}
	
}
