package fr.w3blog.zpl.model.element;

import junit.framework.TestCase;

public class ZebraQRCodeTest extends TestCase
{

   public void testGetZplCode()
   {
      String expected = "^FT70,130,0\n^BY4,2.0,1\n^BQN,2,5,Q\n^FDM13202507230001^FS\n";
      ZebraQRCode qrcode = new ZebraQRCode(70, 130, "3202507230001", 5);

      assertEquals(expected, qrcode.getZplCode(null));
   }
}