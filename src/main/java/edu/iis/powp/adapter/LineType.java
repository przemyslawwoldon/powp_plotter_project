package edu.iis.powp.adapter;

import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

public class LineType {
	
	private ILine line = LineFactory.getBasicLine();
	private boolean flag = false;
	
	public LineType(){
	}
	
	public ILine getLine() {
		return line;
	}
	
	public void setLine(ILine line) {
		this.line = line;
	}
	
		public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
