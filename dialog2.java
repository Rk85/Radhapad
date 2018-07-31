import java.awt.Component.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
public class dialog2 extends Dialog implements ActionListener{
		Radhapad r[]=new Radhapad[100];
		Radhapad ra;
	dialog2(Frame parent,String title,String label)
		{
		super(parent,title,true);
		setLayout(new FlowLayout());
		setSize(300,100);
		Button b;
		Radhapad r=new Radhapad("RADHAPAD");
		add(new Label(label));
		Button but=new Button("Yes");
		Button but1=new Button("No");
		Button but2=new Button("Cancel");
		add(but);
		add(but1);
		add(but2);
		but.addActionListener(this);
		but1.addActionListener(this);
		but2.addActionListener(this);
		
 		}
	
public void actionPerformed(ActionEvent ae)
		{
		String str=(String)ae.getActionCommand();
		int flag=0;
		Frame f[]=ra.getFrames();
		for(int i=0;i<f.length;i++)
			{
			r[i]=(Radhapad)f[i];
			}
		if(str.equals("Yes"))
			{
		for(int i=0;i<f.length;i++)
			{
			r[i]=(Radhapad)f[i];
			if(r[i]==(Radhapad)this.getParent())
				{
				try{
						r[i]=(Radhapad)f[i];
						String tit=r[i].getTitle();
						if(tit.equals("Radhapad"))
							{
							FileDialog fd1=new FileDialog(r[i],"Radha_Save",FileDialog.SAVE);
							fd1.setVisible(true);
							r[i].dir=fd1.getDirectory();
							r[i].file=fd1.getFile();
							if(r[i].file!=null)
							    {
								File fil=new File(r[i].dir+r[i].file);
								FileOutputStream fos=new FileOutputStream(fil);
								PrintStream ps=new PrintStream(fos);
								String text=r[i].ta1.getText();
								ps.println(text);
								r[i].setTitle(r[i].file+"-RADHA PAD");
								r[i].setVisible(false);
							    }
							}
						else{
							if(r[i].file!=null)
							    {
								File fil=new File(r[i].dir+r[i].file);
								FileOutputStream fos=new FileOutputStream(fil);
								PrintStream ps=new PrintStream(fos);
								String text=r[i].ta1.getText();
								ps.println(text);
								r[i].setTitle(r[i].file+"-RADHA PAD");
								r[i].setVisible(false);
							    }
	               				   }
				  		}
				   catch(Exception e){}
			    }
			}
		}
		else if(str.equals("No"))
			{
		for(int i=0;i<f.length;i++)
			{
			r[i]=(Radhapad)f[i];
			if(r[i]==(Radhapad)this.getParent())
				{
			 	try{
						String tit1=r[i].getTitle();
						if(!tit1.equals("Radhapad"))
							{
							File fil=new File(r[i].dir+r[i].file);
							FileOutputStream fos=new FileOutputStream(fil);
							PrintStream ps=new PrintStream(fos);
							ps.println(r[i].sb.toString());
							r[i].setTitle(r[i].file+"-RADHA PAD");
							r[i].setVisible(false);
							}
						else{
							r[i].setVisible(false);
						    }
				   }
				   catch(Exception e){}
			     }
			}
		}
		else if(str.equals("Cancel"))
			{
			dispose();
			}
		dispose();
		
		}

}