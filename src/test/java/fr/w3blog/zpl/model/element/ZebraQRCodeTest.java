package fr.w3blog.zpl.model.element;

import junit.framework.TestCase;

public class ZebraQRCodeTest extends TestCase
{

   public void testGetZplCode()
   {
      ZebraQRCode qrcode = new ZebraQRCode(70, 130, "3202507230001", 5);
      assertEquals("^FT70,130\n^BQN,2,5,Q,7\n^FDM03202507230001\n^FS\n", qrcode.getZplCode(null));
   }
}