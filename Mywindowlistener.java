import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Mywindowlistener extends WindowAdapter {
		Radhapad ra;
		static int close=0;
		static Window w;
		Radhapad r[]=new Radhapad[100];
		dialog2 di;
		public Mywindowlistener(Radhapad r1)
			{
			 
			}
		
		
	
	public void windowClosing(WindowEvent we)	
		{
		Frame f[]=ra.getFrames();
		for(int i=0;i<f.length;i++)
			{
			r[i]=(Radhapad)f[i];
			}
		int count=0;
					for(int i=0;i<f.length;i++)
					{
					if(f[i].isActive())
						{
						r[i]=(Radhapad)f[i];
						dialog2 di=new dialog2(r[i],"RADHAPAD","Do u want to save");
						String titl=r[i].getTitle();
						if(titl.equals("Radhapad"))
								{
								di.setVisible(true);
								}
						else
							{
							String text=r[i].sb.toString();
							String text1=r[i].ta1.getText();
							if(text1.equals(text))
								{
								r[i].setVisible(false);
								}
							else{
								
							      di.setVisible(true);
							    }
							}
						}
						
					if(f[i].isVisible())
						{
						count++;
						}
					}
					if(count==0)
						{
						System.exit(0);
						}
		}
}