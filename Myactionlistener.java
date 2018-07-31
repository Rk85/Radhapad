import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.io.*;
public class Myactionlistener implements ActionListener{
		
		Radhapad r[]=new Radhapad[100];
		Radhapad ra;
		static String s1="";
		static String s="";
		StringBuffer sb=new StringBuffer();
		File filename;
	public Myactionlistener(Radhapad r)
		{ 
		
		}
	
	public void actionPerformed(ActionEvent ae)
		{
		String str=(String)ae.getActionCommand();
		Frame f[]=ra.getFrames();
		for(int i=0;i<f.length;i++)
			{
			r[i]=(Radhapad)f[i];
			}
		
		if(str.equals("New"))
				{
				ra=new Radhapad("Radhapad");
				ra.setSize(600,600);
				ra.setVisible(true);
				}
		 
			else if(str.equals("Save as..."))
				{
				for(int i=0;i<f.length;i++)
				{
					if(f[i].isActive())
						{
					try{
						r[i]=(Radhapad)f[i];
						FileDialog fd=new FileDialog(r[i],"Radha_Save",FileDialog.SAVE);
						fd.setVisible(true);
						r[i].dir=fd.getDirectory();
						r[i].file=fd.getFile();
						filename=new File(r[i].dir+r[i].file);
						FileOutputStream fos=new FileOutputStream(filename);
						PrintStream ps=new PrintStream(fos);
						String text=r[i].ta1.getText();
						ps.println(text);
						r[i].setTitle(r[i].file+"-RADHA PAD");
						r[i].sb.insert(0,text);
					   }
					catch(Exception e){}
					   	}

				}
				}
			else if(str.equals("Copy"))
				{
				
				for(int i=0;i<f.length;i++)
				{
					if(f[i].isActive())
					{
					r[i]=(Radhapad)f[i];
					this.s=r[i].ta1.getSelectedText();
					}
					
				     }
				
				}
			else if(str.equals("Paste"))
				{
				 for(int i=0;i<f.length;i++)
				{
					if(f[i].isActive())
					{
				  try{
					int lno=0;
					r[i]=(Radhapad)f[i];
					s1=r[i].ta1.getText();
					int pos=r[i].ta1.getCaretPosition();
				   if(!(s1.equals("\t")))
					{
					sb.insert(0,s1);
					String g7=String.valueOf(s);
					sb.insert(pos,s);
					r[i].ta1.setText(sb.toString());
					for(int c=0;c<=pos;c++)
						{
						if(sb.charAt(c)=='\n')
							{
								pos--;
							}
						}
					r[i].ta1.setCaretPosition(pos);
					sb.delete(0,sb.length());
					}
				  else{
					sb.insert(0,this.s);
					r[i].ta1.setText(sb.toString());
					}
				 
				     }
				catch(Exception e){
					sb.append("\n");          
					sb.append(String.valueOf(sb.length()));
					r[i].ta1.setText(sb.toString());
					sb.delete(0,(sb.length()));
				   		 }
					}
				 
				}
				}





			else if(str.equals("Open..."))
					{
					for(int i=0;i<f.length;i++)
					{
					if(f[i].isActive())
						{
					try {
						r[i]=(Radhapad)f[i];
						FileDialog fd=new FileDialog(r[i],"Radha_Save",FileDialog.LOAD);
						fd.setVisible(true);
						r[i].dir=fd.getDirectory();
						r[i].file=fd.getFile();
						filename=new File(r[i].dir+r[i].file);
						FileInputStream fis=new FileInputStream(filename);
						InputStreamReader isr=new InputStreamReader(fis);
						BufferedReader br=new BufferedReader(isr);
						r[i].ta1.setText("");
						r[i].setTitle(r[i].file+"-RADHAPAD");
						String text=br.readLine();
						while(text!=null)
							{
							r[i].ta1.append(text);
							r[i].ta1.append("\n");
							text=br.readLine();
							}
						String text1=r[i].ta1.getText();
						r[i].sb.insert(0,text1);
					     }
					catch(Exception e){}
						
						}
					}
					}
			else if(str.equals("Close."))
					{
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
		        else if(str.equals("Delete"))
					{
					for(int i=0;i<f.length;i++)
					{
						if(f[i].isActive())
							{
					try{
							r[i]=(Radhapad)f[i];
							int start=r[i].ta1.getSelectionStart();
							int end=r[i].ta1.getSelectionEnd();
							String s1=r[i].ta1.getText();
							sb.insert(0,s1);
							if(start==0)
								{
								sb.delete(start,end);
								}
							else{
								sb.delete((start-1),end);
						   	 	}
							r[i].ta1.setText(sb.toString());
						
						for(int c=0;c<=start;c++)
							{
							if(sb.charAt(c)=='\n')
								{
								start--;
								}
							}
						r[i].ta1.setCaretPosition(start);
						sb.delete(0,sb.length());
					    }
				catch(Exception e){}
					}
					}
					}
				
			else if(str.equals("Replace All"))
				{
				for(int i=0;i<f.length;i++)
					{
						if(f[i].isActive())
						{
						r[i]=(Radhapad)f[i];
						Replace rep=new Replace(r[i],"RADHAPAD",str);
						rep.setVisible(true);
						}
					}
				}
			else if(str.equals("Find"))
				{
				for(int i=0;i<f.length;i++)
					{
						if(f[i].isActive())
						{
						r[i]=(Radhapad)f[i];
						Replace rep=new Replace(r[i],"RADHAPAD",str);
						rep.setVisible(true);
						}
					}
				}
			else if(str.equals("Select All"))
				{
				for(int i=0;i<f.length;i++)
					{
						if(f[i].isActive())
						{
						r[i]=(Radhapad)f[i];
						r[i].ta1.selectAll();
						this.s=r[i].ta1.getText();
						}
					}
				}
			else if(str.equals("Font"))
				{
				for(int i=0;i<f.length;i++)
					{
						if(f[i].isActive())
						{
						r[i]=(Radhapad)f[i];
						Myfont mf=new Myfont(r[i],"RADHA FONT");
						mf.setVisible(true);
						}
					}
				}
			else if(str.equals("Cut"))
					{
					for(int i=0;i<f.length;i++)
					{
						if(f[i].isActive())
							{
					try{
							r[i]=(Radhapad)f[i];
							int start=r[i].ta1.getSelectionStart();
							int end=r[i].ta1.getSelectionEnd();
							this.s=r[i].ta1.getSelectedText();
							String s1=r[i].ta1.getText();
							sb.insert(0,s1);
							if(start==0)
								{
								sb.delete(start,end);
								}
							else{
								sb.delete((start-1),end);
						   	 	}
							r[i].ta1.setText(sb.toString());
						
						for(int c=0;c<=start;c++)
							{
							if(sb.charAt(c)=='\n')
								{
								start--;
								}
							}
						r[i].ta1.setCaretPosition(start);
						sb.delete(0,sb.length());
						
					    }
				catch(Exception e){}
					}
					}
					}
			else if(str.equals("Save"))
				{
				
				for(int i=0;i<f.length;i++)
				{
					if(f[i].isActive())
						{
					try{	r[i]=(Radhapad)f[i];
						String st1=r[i].getTitle();
						if(st1.equals("Radhapad"))
							{
							FileDialog fd=new FileDialog(r[i],"Radha_Save",FileDialog.SAVE);
							fd.setVisible(true);
							r[i].dir=fd.getDirectory();
							r[i].file=fd.getFile();
							if(r[i].file!=null)
								{
								filename=new File(r[i].dir+r[i].file);
								FileOutputStream fos=new FileOutputStream(filename);
								PrintStream ps=new PrintStream(fos);
								String text=r[i].ta1.getText();
								ps.println(text);
								r[i].setTitle(r[i].file+"-RADHA PAD");
								r[i].sb.insert(0,text);
								}
							}
						else{
							filename =new File(r[i].dir+r[i].file);
							FileOutputStream fos=new FileOutputStream(filename);
							PrintStream ps=new PrintStream(fos);
							String text=r[i].ta1.getText();
							ps.println(text);
							r[i].sb.insert(0,text);
						    }
					   }
						
					catch(Exception e){}
					   	}

				}
				}


					
	}


			
}