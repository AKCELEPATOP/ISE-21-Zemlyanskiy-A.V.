package components;

import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;

import javax.swing.*;
/**
*
* @author Zemlyanskiy
*
*/
public class DraggeblePanel extends JPanel implements DragGestureListener, DragSourceListener{
	
	DragSource dragSource;
	
	public DraggeblePanel(){
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
		Transferable transferable = new TransferableColor(getBackground());
		dragSource.startDrag(dge, DragSource.DefaultCopyDrop, transferable, this);
	}

}
