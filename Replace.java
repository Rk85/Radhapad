import java.awt.Component.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.util.*;
public class Replace extends Dialog implements ActionListener,TextListener{
		Radhapad ra;
		Radhapad r[]=new Radhapad[100];
		TextField t1;
		TextField t2;
		StringBuffer sb=new StringBuffer();
		StringBuffer sb1=new StringBuffer();
		String text="";
		String find="";
		String repl="";
		String myfind="";
		int flag=0;	
		String b="";	
	Replace(Frame parent,String title,String str)
		{
		super(parent,title,false);
		setSize(400,150);
		ra=(Radhapad)parent;
		Radhapad r=new Radhapad("RADHAPAD");
		Panel p1=new Panel();
		Panel p2=new Panel();
		Panel p3=new Panel();
		if(str.equals("Replace All"))
			{
			Label l1=new Label("Find What");
			Label l2=new Label("Replace What");
			TextField t1=new TextField(10);
			TextField t2=new TextField(10);
			t1.setName("Find");
			t2.setName("Replace");
			p1.add(l1);
			p1.add(t1);
			p3.add(l2);
			p3.add(t2);
			add(p1,BorderLayout.WEST);
			add(p3,BorderLayout.CENTER);
			
			t1.addTextListener(this);
			t2.addTextListener(this);
			
			}
		else	{
			Label l1=new Label("Find What");
			TextField t1=new TextField(10);
			p1.add(l1);
			p1.add(t1);
			add(p1,BorderLayout.NORTH);
			t1.addTextListener(this);
			}
			Button but1=new Button(str);
		
		
		p2.add(but1);
		but1.addActionListener(this);
		add(p2,BorderLayout.SOUTH);
 		}
	
public void actionPerformed(ActionEvent ae)
		{
		String str=(String)ae.getActionCommand();
		Frame f[]=ra.getFrames();
		if(str.equals("Replace All"))
			{
		if(find.length()==repl.length())
			{
			for(int i=0;i<f.length;i++)
				{
				r[i]=(Radhapad)f[i];
				if(r[i]==(Radhapad)this.getParent())
					{
					int len=0;
					String text=r[i].ta1.getText();
					sb1.insert(0,text);
					StringTokenizer stz=new StringTokenizer(text,"\n\r ");
					String myfind=stz.nextToken();
					while(stz.hasMoreTokens())
						{
						if(myfind.equals(find))
							{
							sb.insert(len,repl);
							len=len+repl.length();
							sb.insert(len," ");
							myfind=stz.nextToken();
							len=len+1;
							}
							else{
								sb.insert(len,myfind);
								len=len+myfind.length();
								myfind=stz.nextToken();
								sb.insert(len," ");
								len=len+1;
							    }
								
						}
					sb.insert(len,myfind);
					for(int j=0;j<sb1.length();j++)
						{
						char n;
						n=sb1.charAt(j);
						if(n=='\n' && sb.length()>j)
							{
							sb.insert(j,"\n");
							}
						else{
							sb.append("\n");
						    }
						}
					r[i].ta1.setText(sb.toString());
					}
				}
			dispose();
			}
		else{
			dispose();
		    }
			}	
		else if(str.equals("Find"))
			{
			for(int i=0;i<f.length;i++)
				{
				r[i]=(Radhapad)f[i];
				if(r[i]==(Radhapad)this.getParent())
					{
					int len=0;
					sb1.delete(0,sb1.length());
					String text=r[i].ta1.getText();
					sb1.insert(0,text);
					if(sb1.charAt(sb.length())!='\t')
						{
						sb.append('\t');
						sb1.append("\n");
						}
					
					r[i].ta1.setText(sb1.toString());
					len=b.length();
					int n=0;
					for(int j=0;j<sb1.length()-len;j++)
						{
						myfind=sb1.substring(j,len+j);
						
						if(myfind.equals(b) && (sb1.charAt(len+j)==' '|| sb1.charAt(len+j+1)=='\n'))
						   {
							this.setVisible(false);
							r[i].ta1.select(j-n,j+len-n);
							break;
						    }
						else{
							if(sb1.charAt(j)=='\n')
								{n++;}
						    }
							
						}
						
					}
				}
			
			}
	dispose();
	}
public void textValueChanged(TextEvent te)
		{
		Frame f[]=ra.getFrames();
		for(int i=0;i<f.length;i++)
			{
			if(f[i]==this.getParent())
				{
				TextField t3=(TextField)te.getSource();
				b=t3.getText();
				if(t3.getName().equals("Find"))
					{
					find=b;
					}
				if(t3.getName().equals("Replace"))
					{
					repl=b;
					}
				r[i]=(Radhapad)f[i];
					
				}
			}
		}
	
}