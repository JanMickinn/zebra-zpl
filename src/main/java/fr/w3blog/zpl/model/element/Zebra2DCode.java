package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.model.ZebraElement;
/**
 * Abstract Zebra element to represent a 2D code instruction
 *
 * @author Jan Mickinn
 *
 */
public abstract class Zebra2DCode<T extends Zebra2DCode<T>> extends ZebraBarCode<T>
{

   protected int magnification;

   public Zebra2DCode(int positionX, int positionY, String text, int barCodeHeight)
   {
      super(positionX, positionY, text, barCodeHeight);
   }

   public Zebra2DCode(int positionX, int positionY, String text)
   {
      super(positionX, positionY, text);
   }
}
