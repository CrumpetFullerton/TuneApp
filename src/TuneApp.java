import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class TuneApp extends JFrame
{
	private JPanel panel;
	private JPanel banner;
	private JPanel left;
	private JPanel center;
	private JPanel right;
	private JLabel title;
	private JLabel VehicleWeight;
	private JTextField VWinput;
	private JLabel SpringMax;
	private JTextField SpringMaxinput;
	private JLabel SpringMin;
	private JTextField SpringMininput;
	private JLabel DampeningMax;
	private JComboBox DampMax;
	private JLabel DampeningMin;
	private JComboBox DampMin;
	private JLabel FrontWeight;
	private JTextField FWinput;
	private JLabel Tunechoose;
	private JComboBox TunePick;
	private JButton Process;
	private JLabel Front;
	private JLabel Back;
	private JLabel Blank1;
	private JLabel AntiRollFront;
	private JLabel AntiRollFrontAmount;
	private JLabel SpringFront;
	private JLabel SpringFrontAmount;
	private JLabel ReboundFront;
	private JLabel ReboundFrontAmount;
	private JLabel BumpFront;
	private JLabel BumpFrontAmount;
	private JLabel CamberFront;
	private JLabel CamberFrontAmount;
	private JLabel AntiRollBack;
	private JLabel AntiRollBackAmount;
	private JLabel SpringBack;
	private JLabel SpringBackAmount;
	private JLabel ReboundBack;
	private JLabel ReboundBackAmount;
	private JLabel BumpBack;
	private JLabel BumpBackAmount;
	private JLabel CamberBack;
	private JLabel CamberBackAmount;
	DecimalFormat df = new DecimalFormat("#.#");
	private final int WINDOW_WIDTH = 390;
	private final int WINDOW_HEIGHT = 400;
	String[] dampmaxInts = {"20","10"};
	String[] dampminInts = {"3","1"};
	String[] TuneType = {"Street", "Dirt", "Drift"};
	
	public TuneApp()
	{
		setTitle("TuneApp");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		add(panel);
		setVisible(true);
	}
	
	public void buildPanel()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		title = new JLabel("Tune App", SwingConstants.CENTER);
		
		banner = new JPanel();
		banner.add(title);
		
		left = new JPanel();
		left.setLayout(new GridLayout(16,1));
		
		center = new JPanel();
		center.setLayout(new GridLayout(11,1));
		
		right = new JPanel();
		right.setLayout(new GridLayout(11,1));
		
		Blank1 = new JLabel("");
		VehicleWeight = new JLabel("Vehicle Weight");
		VWinput = new JTextField("");
		SpringMax = new JLabel("Spring Max");
		SpringMaxinput = new JTextField("");
		SpringMin = new JLabel("Spring Min");
		SpringMininput = new JTextField("");
		DampeningMax = new JLabel("Dampening Max");
		DampMax = new JComboBox(dampmaxInts);
		DampeningMin = new JLabel("Dampening Min");
		DampMin = new JComboBox(dampminInts);
		FrontWeight = new JLabel("Front Weight %");
		FWinput = new JTextField("");
		Tunechoose = new JLabel("Pick Type Of Tune");
		TunePick = new  JComboBox(TuneType);
		Process = new JButton("Process Tune");
		Process.addActionListener(new processButtonListener());
		DampMax.addActionListener(new dmActionListener());
		
		Front = new JLabel("Front");
		AntiRollFront = new JLabel("Anti-Roll Bars");
		AntiRollFrontAmount = new JLabel("");
		SpringFront = new JLabel ("Springs");
		SpringFrontAmount = new JLabel("");
		ReboundFront = new JLabel("Rebound");
		ReboundFrontAmount = new JLabel("");
		BumpFront = new JLabel ("Bump");
		BumpFrontAmount = new JLabel("");
		CamberFront = new JLabel("Camber");
		CamberFrontAmount = new JLabel("");
		
		Back = new JLabel("Back");
		AntiRollBack = new JLabel("Anti-Roll Bars");
		AntiRollBackAmount = new JLabel("");
		SpringBack = new JLabel ("Springs");
		SpringBackAmount = new JLabel("");
		ReboundBack = new JLabel("Rebound");
		ReboundBackAmount = new JLabel("");
		BumpBack = new JLabel ("Bump");
		BumpBackAmount = new JLabel("");
		CamberBack = new JLabel("Camber");
		CamberBackAmount = new JLabel("");
		
		left.add(Blank1);
		left.add(VehicleWeight);
		left.add(VWinput);
		left.add(SpringMax);
		left.add(SpringMaxinput);
		left.add(SpringMin);
		left.add(SpringMininput);
		left.add(DampeningMax);
		left.add(DampMax);
		left.add(DampeningMin);
		left.add(DampMin);
		left.add(FrontWeight);
		left.add(FWinput);
		left.add(Tunechoose);
		left.add(TunePick);
		left.add(Process);
		
		center.add(Front);
		center.add(AntiRollFront);
		center.add(AntiRollFrontAmount);
		center.add(SpringFront);
		center.add(SpringFrontAmount);
		center.add(ReboundFront);
		center.add(ReboundFrontAmount);
		center.add(BumpFront);
		center.add(BumpFrontAmount);
		center.add(CamberFront);
		center.add(CamberFrontAmount);
		
		
		right.add(Back);		
		right.add(AntiRollBack);
		right.add(AntiRollBackAmount);
		right.add(SpringBack);
		right.add(SpringBackAmount);
		right.add(ReboundBack);
		right.add(ReboundBackAmount);
		right.add(BumpBack);
		right.add(BumpBackAmount);
		right.add(CamberBack);
		right.add(CamberBackAmount);
		
		panel.add(left, BorderLayout.WEST);
		panel.add(center,BorderLayout.CENTER);
		panel.add(right,BorderLayout.EAST);
	}
	private class processButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			double VWI = Double.parseDouble(VWinput.getText());
			double SMaxI = Double.parseDouble(SpringMaxinput.getText());
			double SMinI = Double.parseDouble(SpringMininput.getText());
			double DMax = Double.parseDouble((String)DampMax.getSelectedItem());
			double DMin = Double.parseDouble((String)DampMin.getSelectedItem());
			double FW = Double.parseDouble(FWinput.getText())/100;
			double BW = 1 - FW;
			double ARBMax = 65;
			double ARBMin = 1;
			double ARBFA;
			double ARBBA = 14;
			double FS;
			double BS;
			double FR;
			double BR;
			double FB;
			double BB;
			double FC;
			double BC;
			double ARBFADirt;
			double ARBBADirt;
			double FSDirt;
			double BSDirt;
			double FRDirt;
			double BRDirt;
			double FBDirt;
			double BBDirt;
			double FCDirt;
			double BCDirt;
			double ARBFADrift;
			double ARBBADrift;
			double FSDrift;
			double BSDrift;
			double FRDrift;
			double BRDrift;
			double FBDrift;
			double BBDrift;
			double FCDrift;
			double BCDrift;
			
			ARBFA = Double.valueOf(df.format(((ARBMax-ARBMin)*FW)+ARBMin));
			FS = Double.valueOf(df.format(((SMaxI-SMinI)*FW)+SMinI));
			BS = Double.valueOf(df.format(((SMaxI-SMinI)*BW)+SMinI));
			FR = Double.valueOf(df.format((DMax-DMin)*FW + DMin));
			BR = Double.valueOf(df.format((DMax - DMin)*BW + DMin));
			FB = Double.valueOf(df.format(FR*0.6));
			BB = Double.valueOf(df.format(BR*0.6));
			FC = Double.valueOf(df.format(0-(((VWI*FW)/FS)/2)));
			BC = Double.valueOf(df.format(0-(((VWI*BW)/BS)/2)));
			if(TunePick.getSelectedItem() == "Street")
			{
				AntiRollFrontAmount.setText(String.valueOf(ARBFA));
				AntiRollBackAmount.setText(String.valueOf(ARBBA));
				SpringFrontAmount.setText(String.valueOf(FS));
				SpringBackAmount.setText(String.valueOf(BS));
				ReboundFrontAmount.setText(String.valueOf(FR));
				ReboundBackAmount.setText(String.valueOf(BR));
				BumpFrontAmount.setText(String.valueOf(FB));
				BumpBackAmount.setText(String.valueOf(BB));
				CamberFrontAmount.setText(String.valueOf(FC));
				CamberBackAmount.setText(String.valueOf(BC));
			}
			else if(TunePick.getSelectedItem() == "Dirt")
			{
				ARBFADirt = Double.valueOf(df.format((ARBFA+ARBMin)/2));
				ARBBADirt = Double.valueOf(df.format((ARBBA+ARBMin)/2));
				FSDirt = Double.valueOf(df.format((FS+SMaxI)/2));
				BSDirt = Double.valueOf(df.format((BS+SMinI)/2));
				FRDirt = Double.valueOf(df.format((FR+DMin)/2));
				BRDirt = Double.valueOf(df.format((BR+DMin)/2));
				FBDirt = Double.valueOf(df.format((FRDirt*0.6)));
				BBDirt = Double.valueOf(df.format((BRDirt*0.6)));
				FCDirt =Double.valueOf(df.format( 0 - ((VWI*FW)/FS)));
				BCDirt =Double.valueOf(df.format( 0 - ((VWI*BW)/BS)));
				AntiRollFrontAmount.setText(String.valueOf(ARBFADirt));
				AntiRollBackAmount.setText(String.valueOf(ARBBADirt));
				SpringFrontAmount.setText(String.valueOf(FSDirt));
				SpringBackAmount.setText(String.valueOf(BSDirt));
				ReboundFrontAmount.setText(String.valueOf(FRDirt));
				ReboundBackAmount.setText(String.valueOf(BRDirt));
				BumpFrontAmount.setText(String.valueOf(FBDirt));
				BumpBackAmount.setText(String.valueOf(BBDirt));
				CamberFrontAmount.setText(String.valueOf(FCDirt));
				CamberBackAmount.setText(String.valueOf(BCDirt));
			}
			else if(TunePick.getSelectedItem() == "Drift")
			{
				ARBFADrift = Double.valueOf(df.format(((ARBMax-ARBFA)/2)+ARBFA));
				ARBBADrift = Double.valueOf(df.format(((ARBMax-ARBBA)/2)+ARBBA));
				FSDrift = Double.valueOf(df.format(((SMaxI-FS)/2)+FS));
				BSDrift = Double.valueOf(df.format(((SMaxI-BS)/2)+BS));
				FRDrift = Double.valueOf(df.format((DMax - FR)/2 + FR));
				BRDrift = Double.valueOf(df.format((DMax - BR)/2 + BR));
				FBDrift = Double.valueOf(df.format(FRDrift*0.6));
				BBDrift =Double.valueOf(df.format( BRDrift*0.6));
				FCDrift =Double.valueOf(df.format( 0-(((VWI*FW)/FS)*2)));
				BCDrift = Double.valueOf(df.format(0-(((VWI*BW)/BS)*2)));
				AntiRollFrontAmount.setText(String.valueOf(ARBFADrift));
				AntiRollBackAmount.setText(String.valueOf(ARBBADrift));
				SpringFrontAmount.setText(String.valueOf(FSDrift));
				SpringBackAmount.setText(String.valueOf(BSDrift));
				ReboundFrontAmount.setText(String.valueOf(FRDrift));
				ReboundBackAmount.setText(String.valueOf(BRDrift));
				BumpFrontAmount.setText(String.valueOf(FBDrift));
				BumpBackAmount.setText(String.valueOf(BBDrift));
				CamberFrontAmount.setText(String.valueOf(FCDrift));
				CamberBackAmount.setText(String.valueOf(BCDrift));
				
			}
			else
			{
				System.out.println("Houston we have an issue");
			}
		}
	}
	
	private class dmActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			
		}
	}
	public static void main(String[] args)
	{
		new TuneApp();
	}
}
