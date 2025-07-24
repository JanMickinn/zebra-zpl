package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.model.PrinterOptions;
import fr.w3blog.zpl.utils.ZplUtils;

/**
 * Element to create a bar code 39
 * 
 * Zpl command : ^B3 and ^BY
 * 
 * @author ttropard
 * 
 */
public class ZebraBarCode39 extends ZebraBarCode<ZebraBarCode39> {

	private boolean checkDigit43 = false;

	public ZebraBarCode39(int positionX, int positionY, String text, int barCodeHeight) {
		super(positionX, positionY, text, barCodeHeight);
	}

	public ZebraBarCode39(int positionX, int positionY, String text, int barCodeHeight, int barCodeWidth, int wideBarRatio) {
		super(positionX, positionY, text, barCodeHeight, barCodeWidth, wideBarRatio);
	}

	public ZebraBarCode39(int positionX, int positionY, String text, int barCodeHeight, int barCodeWidth, int wideBarRatio, boolean checkDigit43) {
		super(positionX, positionY, text, barCodeHeight, barCodeWidth, wideBarRatio);
		this.setCheckDigit43(checkDigit43);
	}

	public ZebraBarCode39(int positionX, int positionY, String text, int barCodeHeight, boolean showTextInterpretation, boolean showTextInterpretationAbove) {
		super(positionX, positionY, text, barCodeHeight, showTextInterpretation, showTextInterpretationAbove);
	}

	@Override
	protected ZebraBarCode39 getThis() {
		return this;
	}

	@Override
	public String getZplCode(PrinterOptions printerOptions) {
		StringBuilder zpl = getStartZplCodeBuilder();
		zpl.append(ZplUtils.zplCommandSautLigne("B3", zebraRotation.getLetter(), barCodeHeight, checkDigit43, showTextInterpretation, showTextInterpretationAbove));
		zpl.append("^FD");
		zpl.append(text);
		zpl.append(ZplUtils.zplCommandSautLigne("FS"));
		return zpl.toString();
	}

	public boolean isCheckDigit43() {
		return checkDigit43;
	}

	public ZebraBarCode39 setCheckDigit43(boolean checkDigit43) {
		this.checkDigit43 = checkDigit43;
		return this;
	}

}
