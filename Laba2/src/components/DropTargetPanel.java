package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import main.Form;
import train.*;
/**
*
* @author Zemlyanskiy Alexander
*
*/
public class DropTargetPanel extends JPanel implements DropTargetListener {
	
	private ITransport loc;//так надо
	

	public DropTargetPanel(){
		new DropTarget(this,this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(loc!=null){
			BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D gr = image.createGraphics();
			gr.setColor(Color.WHITE);
			gr.fillRect(0, 0, image.getWidth(), image.getHeight());
			loc.setPosition(image.getWidth()>>1,image.getHeight()>>1);
			Rotate.imageRotate(gr, loc.Pict(), 0, loc.Center());
			g.drawImage(image, 0, 0, null);
		}
	}
	
	public ITransport getLoc() {
		return loc;
	}

	public void setLoc(ITransport loc) {
		this.loc = loc;
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		if(dtde.getTransferable().isDataFlavorSupported(DataFlavor.stringFlavor)){
			dtde.acceptDrag(DnDConstants.ACTION_COPY);
		}else{
			dtde.acceptDrag(DnDConstants.ACTION_NONE);
		}
		
	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {}

	@Override
	public void dragExit(DropTargetEvent dte) {}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		
		try{
			Transferable transferable = dtde.getTransferable();
			if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {

				switch((String) transferable.getTransferData(DataFlavor.stringFlavor)){
				case "Locomotive":
					loc = new Locomotive(200, 5, 100, 200, Color.green.darker(), Color.gray.brighter());
					Form.logger.info("Выбран новый "+loc.getClass().getName());
					break;
				case "Heatovoz":
					loc = new Heatovoz(200, 5, 100, 200, Color.green.darker(),
							Color.gray.brighter(), true, true, 100, Color.gray.brighter());
					Form.logger.info("Выбран новый "+loc.getClass().getName());
				}
				repaint();
			}else{
				dtde.rejectDrop();
			}
		}catch(Exception e){
			dtde.rejectDrop();
		}
		
	}

}
