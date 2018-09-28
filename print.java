package print;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;  
import javax.swing.*;  

public class print {
	
	print(){
		JFrame f=new JFrame("Form");
		
	    JPanel panel=new JPanel();  
	    panel.setBounds(40,80,200,200);    
	    panel.setBackground(Color.gray); 
        
	    JLabel l=new JLabel("Name:");  
	    l.setBounds(50,100,80,30); 
	    l.setBackground(Color.green); 
	    
	    JTextField t1=new JTextField();  
	    t1.setBounds(50,0, 250,50);
	    t1.setBackground(Color.yellow); 
	    
	    
	    JButton Up=new JButton("print");
	    Up.setBounds(100,150,80,30);
	    Up.setBackground(Color.red); 
	    
	    panel.add(l);
	    panel.add(t1);
	    panel.add(Up);
	    
	    
	    f.add(panel);
		
	    f.setSize(500,500);
	    f.setLayout(null);    
	    f.setVisible(true); 
		
	    Up.addActionListener(new ActionListener()
	  		{
	             public void actionPerformed(ActionEvent e)
	             {PrinterJob job = PrinterJob.getPrinterJob();
	             job.setJobName("Print Data");
	             
	             job.setPrintable(new Printable(){
	             public int print(Graphics pg,PageFormat pf, int pageNum){
	                     pf.setOrientation(PageFormat.LANDSCAPE);
	                  if(pageNum>0){
	                     return Printable.NO_SUCH_PAGE;
	                 }
	                 
	                 Graphics2D g2 = (Graphics2D)pg;
	                 g2.translate(pf.getImageableX(), pf.getImageableY());
	                 g2.scale(0.24,0.24);
	                 
	                 panel.paint(g2);
//	           
	                
	                 return Printable.PAGE_EXISTS;
	                          
	                 
	             }
	     });
	          
	         boolean ok = job.printDialog();
	         if(ok){
	         try{
	             
	         job.print();
	         }
	         catch (PrinterException ex){}
	         }
	             }
	  		});
	}
	public static void main(String args[]) {
		new print();
	}
}
