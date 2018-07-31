import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.io.*;
public class Mykeylistener extends MouseAdapter implements KeyListener{
		
		Radhapad r[]=new Radhapad[100];
		Radhapad ra;
		static int len=0;
		Mykeylistener(Radhapad r)
			{
			}
		public void keyPressed(KeyEvent ke)
			{
			
			}

			
		public void keyReleased(KeyEvent ke)
			{
			}
		public void keyTyped(KeyEvent ke)
			{
			Frame f[]=ra.getFrames();
			for(int i=0;i<f.length;i++)
				{
				if(f[i].isActive())
					{
					r[i]=(Radhapad)f[i];
					String text=r[i].ta1.getText(); 
					char c=ke.getKeyChar();
					if(c!=ke.VK_DELETE)
						{
						len=(int)text.length();
						if(len==0){len++;}
						else if(text.charAt(len-1)!='\t')
							{
							len=len+1;
							}
						String val="THE SPACE OCCUPIED"+"    "+String.valueOf(len)+"    "+"BYTES";
						r[i].b1.setLabel(val);
						}
					if(c==ke.VK_BACK_SPACE)
						{
						len=len-1;
							if(len>=0)
							{
								String val="THE SPACE OCCUPIED"+"    "+String.valueOf(len)+"    "+"BYTES";
								r[i].b1.setLabel(val);
							}
							else{len++;}

						}
					if(c==ke.VK_DELETE)
						{
						if(r[i].ta1.getCaretPosition()<len)
							{
							len=len-1;
							}
							if(len>=0)
							{
								String val="THE SPACE OCCUPIED"+"    "+String.valueOf(len)+"    "+"BYTES";
								r[i].b1.setLabel(val);
							}
							
						}
						
					}
				}
			}
		
}
		