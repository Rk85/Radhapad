import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
public class Myitemlistener extends Applet implements ItemListener{
	Radhapad ra;
	Radhapad r[]=new Radhapad[100];
	public Myitemlistener(Radhapad r)
		{
		this.ra=r;
		}
	public void itemStateChanged(ItemEvent ie)
		{
		Frame f[]=ra.getFrames();
		for(int j=0;j<f.length;j++)
			{
			r[j]=(Radhapad)f[j];
			}
		Object i=ie.getItem();
		String str=(String)i.toString();
		for(int j=0;j<f.length;j++)
		{
		if(f[j].isActive())
			{
			r[j]=(Radhapad)f[j];
			
		if(str.equals("Status Bar"))
			{
			int st=ie.getStateChange();
			    if(st==ie.SELECTED)
				{
				 r[j].b1.setVisible(true);
				 
				}
			    else{
				r[j].b1.setVisible(false);
				}
			}
			}
		}
	}
}