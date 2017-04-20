package edu.iis.powp.drawer;

import edu.iis.powp.adapter.PlotterAdapter;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

public class TestComplexCommand {

	
    public static void main(String[] args)
    {
        DrawPanelController controller = new DrawPanelController();
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
        PlotterAdapter pa = new PlotterAdapter(controller);

    }
	
	
	
//	
//	private ArrayList<PlotterCommand> listPlotterCommand = new ArrayList<>();
//	
//	public ComplexCommand(ArrayList<PlotterCommand> listPlotterCommand) {
//		this.listPlotterCommand = listPlotterCommand;
//	}
//
//	@Override
//	public void execute(IPlotter iPlotter) {
//		for(PlotterCommand plotterCommand : listPlotterCommand) {
//			plotterCommand.execute(iPlotter);
//		}
//	}
	
	
}
