package components;

import java.awt.Color;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;

import javax.swing.*;

import train.*;
/**
*
* @author Zemlyanskiy
*
*/
public class DropTargetLabel extends JLabel implements DropTargetListener {


	public DropTargetLabel(String text) {
		super(text);
		new DropTarget(this, this);
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		if (dtde.getTransferable().isDataFlavorSupported(TransferableColor.colorFlavor)) {
			dtde.acceptDrag(DnDConstants.ACTION_COPY);
		} else {
			dtde.acceptDrag(DnDConstants.ACTION_NONE);
		}

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
	}

	@Override
	public void dragExit(DropTargetEvent dte) {
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		try {
			Transferable transferable = dtde.getTransferable();
			if (transferable.isDataFlavorSupported(TransferableColor.colorFlavor)) {
				Color color = (Color) transferable.getTransferData(TransferableColor.colorFlavor);
				setBackground(color);
				ITransport loc=((DropTargetPanel)getLabelFor()).getLoc();
				if (loc != null)
					switch (getText()) {// не ругайся, начальника
					case "Main":
						loc.setMainColor(color);
						break;
					case "Secondary":
						loc.setDopColor(color);
						break;
					case "Chimney":
						if (loc instanceof Heatovoz) {
							((Heatovoz) loc).setChimneyColor(color);
						}
						break;
					}
				if (getLabelFor() instanceof JPanel) {
					((JPanel) getLabelFor()).repaint();
				}

			} else {
				dtde.rejectDrop();
			}
		} catch (Exception e) {
			dtde.rejectDrop();
		}

	}

}
