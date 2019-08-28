package applet;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.event.*; 
import javax.swing.tree.*; 
 
/*<applet code="Num" width=400 height=200></applet>*/ 
 
public class Project extends JApplet { 
public void init() {  
try {  
SwingUtilities.invokeAndWait( new Runnable() {  
   public void run() {  
makeGUI();  
   }  
   });  
 }  
 catch (Exception exc){  
  System.out.println("Can't create because of " + exc);  
 }  
} 
private void makeGUI() { 
JTabbedPane jtp = new JTabbedPane();    
jtp.addTab("Personal Details", new social()); 
jtp.addTab("Stream", new sports()); 
jtp.addTab("Flags", new teams()); 
add(jtp); 
}  
} 
class sports extends JPanel { 
public sports() { 
 JTree tree; 
 final JLabel jlab; 
 DefaultMutableTreeNode top=new DefaultMutableTreeNode("Vehicles"); 
 DefaultMutableTreeNode ct=new DefaultMutableTreeNode("Car"); 
 top.add(ct); 
 DefaultMutableTreeNode wc=new DefaultMutableTreeNode("BMW"); 
 ct.add(wc); 
 DefaultMutableTreeNode ipl=new DefaultMutableTreeNode("Audi"); 
 ct.add(ipl); 
 DefaultMutableTreeNode twty=new DefaultMutableTreeNode("Jaguar"); 
 ct.add(twty); 
 DefaultMutableTreeNode twtz=new DefaultMutableTreeNode("Lamborgini"); 
 ct.add(twtz); 
 DefaultMutableTreeNode ft=new DefaultMutableTreeNode("Bike"); 
 top.add(ft); 
 DefaultMutableTreeNode cl=new DefaultMutableTreeNode("Honda"); 
 ft.add(cl); 
 DefaultMutableTreeNode pl=new DefaultMutableTreeNode("TVS"); 
 ft.add(pl); 
 DefaultMutableTreeNode liga=new DefaultMutableTreeNode("KTM"); 
 ft.add(liga); 
 tree=new JTree(top); 
 JScrollPane jsp=new JScrollPane(tree); 
 add(jsp); 
 jlab=new JLabel(); 
 add(jlab,BorderLayout.SOUTH); 
 tree.addTreeSelectionListener(new TreeSelectionListener(){ 
  public void valueChanged(TreeSelectionEvent tse){ 
   jlab.setText("Selection is"+tse.getPath()); 
} 
 });
 final JToggleButton jtb1=new JToggleButton("ON/OFF");    
  final JLabel jb123=new JLabel("");    
  jtb1.addItemListener(new ItemListener(){ 
 public void itemStateChanged(ItemEvent kk){ 
    if(jtb1.isSelected()) 
    	jb123.setText("ON");
    else 
    	jb123.setText("OFF");
   } 
  }); 
  add(jtb1); 
  add(jb123);
  String []colHeads={"ID","Name","Age"}; 
  Object [][]data={ 
   {"1","Madan","20"}, 
   {"2","Ankit","30"}, 
   {"3","Atish","18"}, 
   {"4","Sathvik","19"}, 
   {"5","Akshat","34"}, 
   {"6","Raj","45"}, 
   {"7","Rahul","16"}, 
   {"8","Dhruvil","20"}, 
 }; 
  JTable table=new JTable(data,colHeads); 
  JScrollPane jsp1=new JScrollPane(table); 
 add(jsp1); 
} 
} 
class social extends JPanel implements ItemListener,ActionListener{ 
public social() { 
final JTextField jtf1; 
 JButton btn1=new JButton("Submit");
JLabel labl1=new JLabel("Enter Your name:"); 
 add(labl1); 
 jtf1=new JTextField(8); 
 add(jtf1);
 JLabel lbl6=new JLabel("Gender"); 
 add(lbl6); 
 JRadioButton b1=new JRadioButton("MALE"); 
 b1.addActionListener(this); 
 add(b1); 
 JRadioButton b2=new JRadioButton("FEMALE"); 
 b2.addActionListener(this); 
 add(b2); 
 ButtonGroup bg=new ButtonGroup(); 
 bg.add(b1); 
 bg.add(b2);
 JLabel lbl2=new JLabel("City"); 
 add(lbl2); 
 JComboBox jcb = new JComboBox();  
 jcb.addItem("Mangalore");  
 jcb.addItem("Madikeri");  
 jcb.addItem("Bangalore");  
 jcb.addItem("Mysore"); 
 add(jcb); 
 final JLabel jlab23=new JLabel(""); 
 jcb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String s = (String) jcb.getSelectedItem();
			jlab23.setText("You selected "+s);
		}
	});
 add(jlab23);
 JLabel labl2=new JLabel("Enter your stream:"); 
 add(labl2); 
 JCheckBox cb = new JCheckBox("Computer Science"); 
 cb.addItemListener(this); 
add(cb);  
 cb = new JCheckBox("Mechanical");  
 cb.addItemListener(this); 
 add(cb);  
 cb = new JCheckBox("Electronics");  
 cb.addItemListener(this); 
 add(cb); 
 cb = new JCheckBox("Information Science");  
 cb.addItemListener(this); 
 add(cb); 
 cb = new JCheckBox("Civil");  
 cb.addItemListener(this); 
 add(cb); 
 cb = new JCheckBox("Aeronautical");  
 cb.addItemListener(this); 
 add(cb); 
cb = new JCheckBox("Bio-Tech");  
 cb.addItemListener(this); 
add(cb); 


final String state[]={"Assam","Gujarat","","Rajasthan","Madhya pradesh","Maharashtra","Karnataka","kerala","Tamil Nadu","Goa","Other"}; 
final JList lst=new JList(state); 
lst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
JScrollPane scr=new JScrollPane(lst); 
scr.setPreferredSize(new Dimension(230,150)); 
final JLabel lab24=new JLabel("Choose a state"); 
lst.addListSelectionListener(new ListSelectionListener(){ 
public void valueChanged(ListSelectionEvent aa){ 
 int idx=lst.getSelectedIndex(); 
 if(idx!=-1) 
  lab24.setText("You have Selected  "+state[idx]); 
 else 
  lab24.setText("Choose a state"); 

} 
}); 
add(scr); 
add(lab24);
add(btn1); 
final JLabel lab34=new JLabel ("");
final JLabel lab30=new JLabel("");
btn1.addActionListener(new ActionListener(){
	 public void actionPerformed(ActionEvent bb) {
		 lab34.setText("Sumitted");
		 lab30.setText("Hello "+jtf1.getText());  
	 }
});
add(lab34);
add(lab30);
 } 
JLabel lbl4=new JLabel("Select option"); 
  public void itemStateChanged(ItemEvent ie){ 
   JCheckBox cb=(JCheckBox)ie.getItem(); 
   add(lbl4); 
   if(cb.isSelected()) 
    lbl4.setText(cb.getText()+" is Selected"); 
   else 
    lbl4.setText(cb.getText()+" is deselected"); 
 
   } 
  JLabel lbl7 =new JLabel("");  
  public void actionPerformed(ActionEvent aa) { 
   lbl7.setText(" You Selected "+aa.getActionCommand());  
   add(lbl7); 
  }
  
} 
class teams extends JPanel implements ActionListener { 
public teams() { 
	JButton jb = new JButton("");
	ImageIcon india= new ImageIcon("D:/downloads/india.png");
	jb = new JButton(india);
	jb.setActionCommand("India");
	jb.addActionListener(this);
	add(jb);
	ImageIcon england= new ImageIcon("D:/downloads/england.jpg");
	jb = new JButton(england);
	jb.setActionCommand("England");
	jb.addActionListener(this);
	add(jb);
	ImageIcon italy = new ImageIcon("D:/downloads/italy.png");
	jb = new JButton(italy);
	jb.setActionCommand("Italy");
	jb.addActionListener(this);
	add(jb);
	ImageIcon japan = new ImageIcon("D:/downloads/japan.png");
	jb = new JButton(japan);
	jb.setActionCommand("Japan");
	jb.addActionListener(this);
	add(jb);
	// Create and add the label to content pane.
	JLabel jlab21 = new JLabel("Choose a Flag");
	add(jlab21);
	
}
JLabel jlab25=new JLabel("");
public void actionPerformed(ActionEvent aa) { 
	
 jlab25.setText(" You Selected "+aa.getActionCommand());  
 add(jlab25); 
}

} 

