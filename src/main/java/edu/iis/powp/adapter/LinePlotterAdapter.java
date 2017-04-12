package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.IPlotter;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

public class LinePlotterAdapter implements IPlotter{

	private int startX = 0, startY = 0;
	private DrawPanelController drawPanelController;
	private LineType lineType;
	
    public LinePlotterAdapter() {
	}
    
    public LinePlotterAdapter(DrawPanelController drawPanelController, LineType lineType) {
		this.drawPanelController = drawPanelController;
		this.lineType = lineType;
	}
    
	@Override
    public void setPosition(int x, int y)
    {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void drawTo(int x, int y)
    {
    	ILine line;
    	if(!lineType.isFlag())
    		line = LineFactory.getDottedLine();
    	else
    		line = lineType.getLine();
    	line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        drawPanelController.drawLine(line);
        setPosition(x, y);
    }
    
    @Override
    public String toString()
    {
        return "LinePlotterAdapter";
    }

}
