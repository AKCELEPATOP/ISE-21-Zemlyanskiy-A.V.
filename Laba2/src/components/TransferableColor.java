package components;

import java.awt.Color;
import java.awt.datatransfer.*;
import java.io.*;
/**
*
* @author Zemlyanskiy Alexander
*
*/
public class TransferableColor implements Transferable {

	public final static DataFlavor colorFlavor = new DataFlavor(java.awt.Color.class, "Color");

	private final static DataFlavor[] supportedFlavors = { colorFlavor };

	Color color;

	public TransferableColor(Color color) {
		this.color = color;
	}

	public DataFlavor[] getTransferDataFlavors() {
		return (DataFlavor[])supportedFlavors.clone();
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
		if (flavor.equals(colorFlavor))
			return true;
		return false;
	}

	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals(colorFlavor))
			return color;
		else
			throw new UnsupportedFlavorException(flavor);
	}

}
