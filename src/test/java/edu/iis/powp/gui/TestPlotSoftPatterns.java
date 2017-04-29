package edu.iis.powp.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.adapter.LinePlotterAdapter;
import edu.iis.powp.adapter.LineType;
import edu.iis.powp.adapter.PlotterAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.appext.ApplicationWithDrawer;
import edu.iis.powp.events.predefine.SelectChangeVisibleOptionListener;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener;
import edu.iis.powp.factory.FigureFactory;
import edu.iis.powp.factory.SelectTestFigureOptionComplexCommand;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.LineFactory;


public class TestPlotSoftPatterns
{
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static LineType lineType = new LineType();
		
    /**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param context Application context.
	 */
	private static void setupPresetTests(Context context) {
	    SelectTestFigureOptionListener selectTestFigureOptionListener1 = new SelectTestFigureOptionListener();
		context.addTest("Figure Joe 1", selectTestFigureOptionListener1);	
		context.addTest("Figure Joe 2", (ActionEvent e) -> {
			FiguresJoe.figureScript2(Application.getComponent(DriverManager.class).getCurrentPlotter());
		});
		
		FigureFactory figureFactory = new FigureFactory();
		SelectTestFigureOptionComplexCommand selectTestFigureOptionComplexCommandListener1 = new SelectTestFigureOptionComplexCommand(figureFactory.getSquare());
		SelectTestFigureOptionComplexCommand selectTestFigureOptionComplexCommandListener2 = new SelectTestFigureOptionComplexCommand(figureFactory.getTriangle());
 		
		context.addTest("Figure Square", selectTestFigureOptionComplexCommandListener1);
		context.addTest("Figure Triangle", selectTestFigureOptionComplexCommandListener2);
	}

	/**
	 * Setup driver manager, and set default IPlotter for application.
	 * 
	 * @param context Application context.
	 */
	private static void setupDrivers(Context context) {
		IPlotter clientPlotter = new ClientPlotter();
		context.addDriver("Client Plotter", clientPlotter);
		Application.getComponent(DriverManager.class).setCurrentPlotter(clientPlotter);
		
		IPlotter plotter1 = new PlotterAdapter(Application.getComponent(DrawPanelController.class), lineType);
		IPlotter plotter2 = new LinePlotterAdapter(Application.getComponent(DrawPanelController.class), lineType);

		context.addDriver("Buggy Simulator PlotterAdapter", plotter1);
		context.addDriver("Buggy Simulator LinePlotterAdapter DottedLine", plotter2);
		
		context.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param context Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Context context) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
		
		context.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility", 
        		new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
        defaultDrawerWindow.setVisible(true);
	}
	
	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param context Application context.
	 */
	private static void setupLogger(Context context) {
		Application.addComponent(Logger.class);
		context.addComponentMenu(Logger.class, "Logger", 0);
		context.addComponentMenuElement(Logger.class, "Clear log", (ActionEvent e) -> context.flushLoggerOutput());
		context.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> LOGGER.setLevel(Level.FINE));
		context.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> LOGGER.setLevel(Level.INFO));
		context.addComponentMenuElement(Logger.class, "Warning level", (ActionEvent e) -> LOGGER.setLevel(Level.WARNING));
		context.addComponentMenuElement(Logger.class, "Severe level", (ActionEvent e) -> LOGGER.setLevel(Level.SEVERE));
		context.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> LOGGER.setLevel(Level.OFF));
	}
		
	private static void setTypeOfLine(Context context) {
		Application.addComponent(LineType.class);
		context.addComponentMenu(LineType.class, "Line Type");
		context.addComponentMenuElement(LineType.class, "Basic Line", (ActionEvent e) -> {
			lineType.setLine(LineFactory.getBasicLine());
			lineType.setFlag(true);
		});
		
		context.addComponentMenuElement(LineType.class, "Dotted Line", (ActionEvent e) -> {
			lineType.setLine(LineFactory.getDottedLine());
			lineType.setFlag(true);
		});
		
		context.addComponentMenuElement(LineType.class, "Special Line", (ActionEvent e) -> {
			lineType.setLine(LineFactory.getSpecialLine());
			lineType.setFlag(true);
		});
	}
	
	
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ApplicationWithDrawer.configureApplication();
                Context context = Application.getComponent(Context.class);

                setupDefaultDrawerVisibilityManagement(context);
                
            	setupDrivers(context);
            	setupPresetTests(context);
            	setupLogger(context);
            	setTypeOfLine(context);
            }
        });
    }

}
