import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TBoard extends JFrame{
	public static final int ROWS = 9;
	public static final int COLS = 9;
	public static final int CELL_SIZE = 100; // cell width and height (square)
	public static final int CANVAS_WIDTH = CELL_SIZE * COLS;  // the drawing canvas
	public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
	public static final int GRID_WIDTH = 8;                   // Grid-line's width
	public static final int GRID_WIDTH_HALF = GRID_WIDTH / 2; // Grid-line's half-width
	public static final int CELL_PADDING = CELL_SIZE / 6;
	public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2; // width/height
	public static final int SYMBOL_STROKE_WIDTH = 8;
	
	private Canvas canvas;
	public TBoard(){
		canvas = new Canvas();
	    canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
	    
	    
	}
	
}
