package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.model.PrinterOptions;
import fr.w3blog.zpl.utils.ZplUtils;

/**
 * Element to create a QR code
 *
 * Zpl command : ^BQ
 *
 * @author Jan Mickinn
 *
 */
public class ZebraQRCode extends Zebra2DCode<ZebraQRCode>
{

   /**
    * The QR Code model to use. Valid values are 1 (original) and 2 (enhanced). The default value is model 2 (enhanced). Always use model 2.
    */
   private static final int MODEL = 2;

   /**
    *  The mask pattern to apply to the bar code. Any number between 0 and 7 may be used. The default value is 7. Always use 7.
    */
   private static final int MASK = 7;

   /**
    * The level of error correction to apply. Valid values are H (highest reliability), Q (high reliability), M (medium reliability), and L (lower reliability). The default value is Q (high reliability).
    */
   private static final char ERROR_CORRECTION = 'Q';

   public ZebraQRCode(int positionX, int positionY, String text, int magnification)
   {
      super(positionX, positionY, text, magnification);
   }

   @Override
   protected ZebraQRCode getThis()
   {
      return this;
   }

   @Override
   public String getZplCode(PrinterOptions printerOptions) {
      StringBuilder zpl = getStartZplCodeBuilder();

      zpl.append(ZplUtils.zplCommandSautLigne("BQ", zebraRotation.getLetter(), MODEL, magnification, ERROR_CORRECTION, MASK));
      zpl.append(ZplUtils.zplCommandSautLigne("FDM0", text));
      zpl.append(ZplUtils.zplCommandSautLigne("FS"));
      return zpl.toString();
   }
}
