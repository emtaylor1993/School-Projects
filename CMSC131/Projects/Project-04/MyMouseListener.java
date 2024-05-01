import java.awt.event.*;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

/**
 * THIS CLASS HAS BEEN WRITTEN FOR YOU -- DO NOT MODIFY IT!
 * 
 * Registers with view to respond to "mouse events".  This class should be 
 * considered the "Controller".
 * 
 * @author Fawzi Emad
 */
public class MyMouseListener implements MouseListener, MouseMotionListener {
	private boolean mouseInUse = false;   // True if user has started dragging
	private boolean mouseWasReleased = false;  // True if mouse was released and view has not been redrawn yet
	private Point mouseDownLocation;    // Position where dragging started
	private Point currentDragLocation;  // Current position
	Rectangle2D.Double model;       // The model of the M-V-C pattern.
	
	/** Standard constructor */
	public MyMouseListener(Rectangle2D.Double model) {
		this.model = model;
		mouseInUse = false;
		mouseDownLocation = new Point(0, 0);
		currentDragLocation = new Point(0, 0);
	}
	
	/** returns true if user is dragging mouse */
	public boolean isMouseInUse() {
		return mouseInUse;
	}
	
	/** returns true if user has released mouse and View has
	 * not been redrawn yet */
	public boolean isMouseReleased() {
		return mouseWasReleased;
	}
	
	public void resetMouseReleaseFlag() {
		mouseWasReleased = false;
	}
	
	/** returns current location of mouse during dragging */
	public Point getMouseLocation() {
		return currentDragLocation;
	}
	
	/** returns location of mouse when dragging began */
	public Point getMouseDownLocation() {
		return mouseDownLocation;
	}
	 
	public void mouseDragged(MouseEvent e) {
		Point mouseLocation = new Point(e.getX(), e.getY());
		View view = (View)e.getSource();
		Rectangle bounds = view.getBounds();
		
		double viewAspectRatio = (double)bounds.height / bounds.width;
		double mouseAspectRatio = (mouseLocation.getY() - mouseDownLocation.getY()) / (mouseLocation.getX() - mouseDownLocation.getX());
		double newX, newY;
		
		if (mouseAspectRatio > viewAspectRatio) {
			newX = mouseDownLocation.getX() + (e.getY() - mouseDownLocation.getY()) / viewAspectRatio;
			newY = e.getY();
		} else {
			newX = e.getX();
			newY = mouseDownLocation.getY() + viewAspectRatio * (e.getX() - mouseDownLocation.getX());
		}
		
		currentDragLocation = new Point((int)newX, (int)newY);
		((View)e.getSource()).updateYourself();   // redraw view
	}
	
	public void mousePressed(MouseEvent e) {
		mouseInUse = true;
		mouseDownLocation = new Point(e.getX(), e.getY());
		currentDragLocation = new Point(e.getX(), e.getY());
		((View)e.getSource()).updateYourself();    // redraw view
	}
	
	public void mouseReleased(MouseEvent e) {
		final int MIN_SIZE = 10;
		
		/* Reference to the view of the M-V-C design */
		View view = (View)e.getSource();
		
		mouseInUse = false;      // User is no longer dragging
		Rectangle bounds = new Rectangle(view.getBounds());
		
		if (!bounds.contains(currentDragLocation)) {  // check if released inside drawing area
			return;
		}
		
		if (Math.abs(mouseDownLocation.getX() - currentDragLocation.getX()) < MIN_SIZE || Math.abs(mouseDownLocation.getY() - currentDragLocation.getY()) < MIN_SIZE) {  // tiny region -- do-over
			//System.out.println("tiny");
			return;
		}
		
		mouseWasReleased = true;
	    /*	
        Point2D.Double c1 = DrawingTools.transform(bounds, model, mouseDownLocation.getX(), mouseDownLocation.getY());
		Point2D.Double c2 = DrawingTools.transform(bounds, model, currentDragLocation.getX(), currentDragLocation.getY());
	    */
		double xRatio = model.width / bounds.width;
		double yRatio = model.height / bounds.height;
		double real = xRatio * (mouseDownLocation.getX() - bounds.getX()) + model.x;
		double imag = yRatio * (mouseDownLocation.getY() - bounds.getY()) + -model.y;
		
		Point2D.Double c1 = new Point2D.Double(real, imag);
		
		real = xRatio * (currentDragLocation.getX() - bounds.getX()) + model.x;
		imag = yRatio * (currentDragLocation.getY() - bounds.getY()) + -model.y;
		Point2D.Double c2 = new Point2D.Double(real, imag);
		
		model.x = Math.min(c1.x, c2.x);
		model.y = -Math.min(c1.y, c2.y);
		model.width = Math.abs(c2.x - c1.x);
		model.height = Math.abs(c2.y - c1.y);
		
		view.updateYourself();  // redraw view
	}
	
	/** Required by MouseMotionListener interface, but not implemented */
	public void mouseMoved(MouseEvent e) {}
	
	/** Required by MouseListener interface, but not implemented */
	public void mouseClicked(MouseEvent e) {}
	
	/** Required by MouseListener interface, but not implemented */
	public void mouseEntered(MouseEvent e) {}
	
	/** Required by MouseListener interface, but not implemented */
	public void mouseExited(MouseEvent e) {}
}