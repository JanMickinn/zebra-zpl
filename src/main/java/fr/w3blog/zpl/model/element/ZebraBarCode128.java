package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.model.PrinterOptions;
import fr.w3blog.zpl.utils.ZplUtils;

/**
 * Element to create a bar code 128 subset B (default subset)
 * <p>
 * Zpl command : ^BC
 * <p>
 * @author matthiasvets
 *
 */
public class ZebraBarCode128 extends ZebraBarCode<ZebraBarCode128> {

	private boolean checkDigit43 = false;

	public ZebraBarCode128(int positionX, int positionY, String text) {
		super(positionX, positionY, text);
	}

	public ZebraBarCode128(int positionX, int positionY, String text, int barCodeHeight) {
		super(positionX, positionY, text, barCodeHeight);
	}

	public ZebraBarCode128(int positionX, int positionY, String text, int barCodeHeight, int barCodeWidth, int wideBarRatio) {
		super(positionX, positionY, text, barCodeHeight, barCodeWidth, wideBarRatio);
	}

	public ZebraBarCode128(int positionX, int positionY, String text, int barCodeHeight, boolean showTextInterpretation, int barCodeWidth, int wideBarRatio) {
		super(positionX, positionY, text, barCodeHeight, showTextInterpretation, barCodeWidth, wideBarRatio);
	}

	public ZebraBarCode128(int positionX, int positionY, String text, int barCodeHeight, int barCodeWidth, int wideBarRatio, boolean checkDigit43) {
		super(positionX, positionY, text, barCodeHeight, barCodeWidth, wideBarRatio);
		this.setCheckDigit43(checkDigit43);
	}

	public ZebraBarCode128(int positionX, int positionY, String text, int barCodeHeight, boolean showTextInterpretation, boolean showTextInterpretationAbove) {
		super(positionX, positionY, text, barCodeHeight, showTextInterpretation, showTextInterpretationAbove);
	}

	@Override
	protected ZebraBarCode128 getThis() {
		return this;
	}

	@Override
	public String getZplCode(PrinterOptions printerOptions) {
		StringBuilder zpl = getStartZplCodeBuilder();
		zpl.append(ZplUtils.zplCommandSautLigne("BC", zebraRotation.getLetter(), barCodeHeigth, showTextInterpretation, showTextInterpretationAbove, checkDigit43));
		zpl.append("^FD");
		zpl.append(text);
		zpl.append(ZplUtils.zplCommandSautLigne("FS"));
		return zpl.toString();
	}

	public boolean isCheckDigit43() {
		return checkDigit43;
	}

	public ZebraBarCode128 setCheckDigit43(boolean checkDigit43) {
		this.checkDigit43 = checkDigit43;
		return this;
	}

}
