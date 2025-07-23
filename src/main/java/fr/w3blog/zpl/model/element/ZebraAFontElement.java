package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.constant.ZebraRotation;
import fr.w3blog.zpl.model.PrinterOptions;
import fr.w3blog.zpl.model.ZebraElement;
import fr.w3blog.zpl.utils.ZplUtils;

/**
 * Element to set a font and size (explain in dot).
 * 
 * This command is apply only on the next element (in zebraElements list).
 * 
 * This command could be use when your font and PPP is not yet implemented
 * 
 * ZPL Command : ^A
 * 
 * @author ttropard
 * 
 */
public class ZebraAFontElement extends ZebraElement<ZebraAFontElement> {

	private ZebraFont zebraFont;

	private int dotHeigth;
	private int dotsWidth;

	/**
	 * Use this constructor if you want to change the font of the next element.
	 * 
	 * @param zebraFont
	 *            zebra font
	 */
	public ZebraAFontElement(ZebraFont zebraFont) {
		super();
		this.zebraFont = zebraFont;
	}

	/**
	 * Constructor to set font and size of the next element
	 * 
	 * @param zebraFont
	 *            font zebra
	 * @param dotHeight
	 *            height explain in dots
	 * @param dotsWidth
	 *            height explain in dots
	 */
	public ZebraAFontElement(ZebraFont zebraFont, int dotHeight, int dotsWidth) {
		super();
		this.zebraFont = zebraFont;
		this.dotHeigth = dotHeight;
		this.dotsWidth = dotsWidth;
	}

	/**
	 * Constructor to use if you want have non-horizontal text.
	 * 
	 * @param zebraFont
	 *            font zebra
	 * @param zebraRotation
	 *            text rotation
	 * @param dotHeight
	 *            height explain in dots
	 * @param dotsWidth
	 *            height explain in dots
	 */
	public ZebraAFontElement(ZebraFont zebraFont, ZebraRotation zebraRotation, int dotHeight, int dotsWidth) {
		super();
		this.zebraFont = zebraFont;
		this.zebraRotation = zebraRotation;
		this.dotHeigth = dotHeight;
		this.dotsWidth = dotsWidth;
	}

	@Override
	protected ZebraAFontElement getThis() {
		return this;
	}

	/* (non-Javadoc)
	 * @see fr.w3blog.zpl.model.ZebraElement#getZplCode(fr.w3blog.zpl.model.PrinterOptions)
	 */
	@Override
	public String getZplCode(PrinterOptions printerOptions) {
		return ZplUtils.zplCommandSautLigne(String.format("A%s", zebraFont.getLetter()), zebraRotation.getLetter(), dotHeigth, dotsWidth).toString();
	}
}
