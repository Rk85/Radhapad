import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
public class Radhapad extends Frame implements Serializable{

		String str="";
TextArea ta1;
Button b1;
int wd;
Scrollbar shor,sver;
MenuBar mbar;
static Font fon=new Font("Roman",Font.PLAIN,20);
MenuItem t6,t7,t8,t9;
String dir;
String  file;
StringBuffer sb;
public Radhapad(String title)
 	{
	 
	 super(title);
	 MenuBar mbar=new MenuBar();
	 setMenuBar(mbar);
	 
	 Menu fil=new Menu("File");
	 MenuItem t1,t2,t3,t4,t5,t10,t11,t13,t14;
       	 fil.add(t1=new MenuItem("New"));
	 fil.add(t2=new MenuItem("Open..."));
	 fil.add(t10=new MenuItem("Save"));
	 fil.add(t3=new MenuItem("Save as..."));
	 fil.add(t4=new MenuItem("-"));
	 fil.add(t5=new MenuItem("Close."));
	 mbar.add(fil);
		
	 Menu edit=new Menu("Edit");
	 edit.add(t6=new MenuItem("Cut"));
	 edit.add(t7=new MenuItem("Copy"));
	 edit.add(t8=new MenuItem("Paste"));
	 edit.add(t9=new MenuItem("Delete"));
	 edit.add(new MenuItem("-"));
	 edit.add(t11=new MenuItem("Replace All"));
	 edit.add(t13=new MenuItem("Select All"));
	 edit.add(t14=new MenuItem("Find"));
	 mbar.add(edit);

	 Menu format=new Menu("Format");
	 MenuItem t12;
	 format.add(t12=new MenuItem("Font"));
	 mbar.add(format);
	
	 Menu view=new Menu("View");
	 CheckboxMenuItem cb2;
	 view.add(cb2=new CheckboxMenuItem("Status Bar"));
	 mbar.add(view);
	 t1.addActionListener(new Myactionlistener(this));
 	 t2.addActionListener(new Myactionlistener(this));
	 t3.addActionListener(new Myactionlistener(this));
	 t4.addActionListener(new Myactionlistener(this));
	 t5.addActionListener(new Myactionlistener(this));
	 t6.addActionListener(new Myactionlistener(this));
	 t7.addActionListener(new Myactionlistener(this));
	 t8.addActionListener(new Myactionlistener(this));
	 t9.addActionListener(new Myactionlistener(this));
	 t10.addActionListener(new Myactionlistener(this));
	 t11.addActionListener(new Myactionlistener(this));
	 t12.addActionListener(new Myactionlistener(this));
	 t13.addActionListener(new Myactionlistener(this));
	 t14.addActionListener(new Myactionlistener(this));
	 
	 addWindowListener(new Mywindowlistener(this));
	 
	 cb2.addItemListener(new Myitemlistener(this));
	 
	 cb2.setState(true);
	 requestFocus();
	 wd=getSize().width;
	 int ht=getSize().height;
	 b1=new Button("Status Bar");
	 b1.setSize(15,wd);
	 b1.setLocation(0,(ht-15));
	 b1.setEnabled(false);
	 
	 
	 add(b1,BorderLayout.SOUTH);
	 ta1=new TextArea(str,10,30);
	 add(ta1);
	 ta1.setFont(fon);
	ta1.addKeyListener(new Mykeylistener(this));
	dir="";
	file="";
	sb=new StringBuffer();
	 }
public static void main(String []args) 	{
	
	String title="Radhapad";
	Radhapad r1=new Radhapad(title);
	r1.setSize(500,500);
	r1.setVisible(true);
	}

}