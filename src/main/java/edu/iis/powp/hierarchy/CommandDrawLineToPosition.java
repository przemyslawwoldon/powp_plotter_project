package edu.iis.powp.hierarchy;

import edu.iis.client.plottermagic.IPlotter;

public class CommandDrawLineToPosition implements PlotterCommand{

	private int x;
	private int y;
	
	public CommandDrawLineToPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int setX() {
		return x;
	}

	public int setY() {
		return y;
	}

	@Override
	public void execute(IPlotter iPlotter) {
		// TODO Auto-generated method stub
		iPlotter.drawTo(this.x, this.y);
	}
	
}
