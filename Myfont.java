import java.awt.Component.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Myfont extends Dialog implements ActionListener{
	List font_name;
	List font_sty;
	List font_size;
	Radhapad ra;
	static List curr;
	String s1="";
	String s2="";
	String s3="";
	int si=0;
	int m=0;
	Radhapad r[]=new Radhapad[100];
	Button b;
	
	Myfont(Frame parent,String title)
		{
		super(parent,title,true);
		setLayout(new BorderLayout());
		setSize(300,300);
		ra=new Radhapad("Teampad");
		font_name=new List(10,false);
		font_sty=new List(3,false);
		font_size=new List(11,false);

		String FontList[];
		GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
		FontList = ge.getAvailableFontFamilyNames();
		for(int i = 0; i < FontList.length; i++)
			{
			font_name.add(FontList[i]);
			}
		
	
		setLayout(new FlowLayout(FlowLayout.LEFT));	
	
		b=new Button("OK");
		b.setSize(10,10);

		font_sty.add("PLAIN");
		font_sty.add("BOLD");
		font_sty.add("ITALIC");
		
		font_size.add("10");
		font_size.add("11");
		font_size.add("12");
		font_size.add("13");
		font_size.add("14");
		font_size.add("15");
		font_size.add("16");
		font_size.add("17");
		font_size.add("18");
		font_size.add("19");
		font_size.add("20");
		
		font_name.select(1);
		font_size.select(1);
		font_sty.select(1);

		font_name.setName("FONT NAME");
		font_name.setName("FONT STYLE");
		font_name.setName("FONT SIZE");
		
		
		add(font_size);
		add(font_name);
		add(font_sty);
		add(b);	
		
		font_name.addActionListener(this);
		font_size.addActionListener(this);
		font_sty.addActionListener(this);
		b.addActionListener(this);
		addWindowListener(new Mywindowlistener(ra));
		
	}
public void actionPerformed(ActionEvent ae)
		{
			
			String str="";
			s1=font_name.getSelectedItem();
			s2=font_size.getSelectedItem();
			s3=font_sty.getSelectedItem();
		
			str=ae.getActionCommand();
			if(str.equals("OK"))
				{
				int k=Integer.parseInt(s2);
				if(s3.equals("PLAIN"))
					{
					m=Font.PLAIN;
					 
					}
				else if(s3.equals("ITALIC"))
					{
					m=Font.ITALIC;
				
					}
				else if(s3.equals("BOLD"))
					{
					m=Font.BOLD;
				
					}
				Frame f[]=ra.getFrames();
				si=Integer.parseInt(s2);
				for( int l=0;l<f.length;l++)
					{
					r[l]=(Radhapad)f[l];
					r[l].fon=new Font(s1,m,si);
					r[l].ta1.setFont(r[l].fon);
					
					}
				dispose();
				}
		}


}
