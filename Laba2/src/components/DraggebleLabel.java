package components;

import java.awt.datatransfer.*;
import java.awt.dnd.*;

import javax.swing.JLabel;
/**
 *
 * @author Zemlyanskiy
 *
 */
public class DraggebleLabel extends JLabel implements DragGestureListener, DragSourceListener{
	
	DragSource dragSource;
	
	public DraggebleLabel(String text){
		super(text);
		dragSource=new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {}

	@Override
	public void dragExit(DragSourceEvent dse) {}

	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		Transferable transferable = new StringSelection(getText());
		
		dragSource.startDrag(dge, DragSource.DefaultCopyDrop, transferable, this);

		
	}

}
