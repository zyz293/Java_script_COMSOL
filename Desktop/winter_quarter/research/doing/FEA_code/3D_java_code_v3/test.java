

import com.jmatio.io.*;
import com.jmatio.types.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test {
	private double vf_expt;
	private double ACMode;
	private double CheckOverlap;
	private double DomLength; 
	private double dimension_to_pixel;
	private String ImageType;
	private double CutSide;
	private double TauShift1;
	private double DeltaEpsilonShift1;
	private double TauShift2;
	private double DeltaEpsilonShift2;
	private double ConstEpsilonShift;
	private double InterfaceThickness1;
	private double InterfaceThickness2;
	private double InterfaceThickness;
	// private Epmodel epmodel; // what object type, which file define it?
	
	private String ep; // it is epmodel.ep
	private String epp; // it is epmodel epp
	private String epint; // it is epmodel.epint
	private String eppint; // it is epmodel eppint
	
	private double isEpsDistribution;
	private double isReScale;
	private double isGetSolution;
	private double ACbreakdown;
	private double ManualMesh;
	private double MeshLevel;
	private String ControlMode;
	private double tau0;
	
	
	
	// private double TauShift1;
	private String TimeRange;
	// private double DeltaEpsilonShift1;
	// private double DomLength;
	// private double dimension_to_pixel;
	// private double TauShift2;
	// private double DeltaEpsilonShift2;
	// private double ConstEpsilonShift;
	private double CurrentSource;
	private double Compfreq;
	// private double CutSide;
	// private boolean isEpsDistribution;
	private double AppliedVoltage;
	private double ActualLength;
	private double dimensionY;
	private double dimensionX;
	private double dimensionZ;
	private double electrode1X;
	private double electrode3X;
	private double electrode1Y;
	private double electrode3Y;
	private double extra_E_infi;
	// private double ACMode;
	private double MatrixConductivity;
	private double FillerConductivity;
	private double FillerRelPerm;
	private double[] FreqRange;
	private double doubleerfaceRelPerm;
	private double doubleerfaceImagPerm;
	private double ElectrodeConductivity;
	private double ElectrodeRelPerm;
	private double EllipseMatrix;
	private double InterfaceConductivity;
	private double InterfaceRelPerm;
	private double InterfaceImagPerm;
	// private double InterfaceThickness1;
	// private double InterfaceThickness2;
	private double InitialVoltage;
	// private boolean ManualMesh;
	// private double[] epmodel;
	private double NewClusterNo;
	private double rt_electrode1X;
	private double rt_electrode2X;
	private double rt_electrode3X;
	private double rt_electrode1Y;
	private double rt_electrode2Y;
	private double rt_electrode3Y;
	private double ReScale;
	// private String ImageType;
	private double sbimagefile;
	private double NewPosX;
	private double NewPosY;
	private double NewShortAxis;
	private double NewLongAxis;
	private double NewAngle;
	// private double CheckOverlap;
	private double GBbr;
	private double GBbs;
	// private double isReScale;
	// private double isGetSolution;
	
	
	// private Constt constt;
	
	public static void main(String[] args) {
		Constt constt = new Constt(600, 1/100, 1, 1, 1, 1, 0, 0.05, 400/240);
		double TrialNo = 1;
		String binsource = "./sample_binary_input_3D_parameter_output";
		new test().MAIN(TrialNo, binsource, constt);
	} 
	
	public void MAIN(double TrialNo, String binsource, Constt constt) {
		
		ImageType = "recon";
		ControlMode = "linux";
		dimension_to_pixel = (double) constt.dimension_to_pixel;
		CutSide = 0.1;
		double IP1 = 5;
		double IP2 = 10;
		InterfaceThickness1 = IP1 * 1e-6;
		InterfaceThickness2 = IP2 * 1e-6;
		
		isReScale = 0;
		isGetSolution = 1;
		isEpsDistribution = 1;
		ACMode = 1;
		ACbreakdown = 0;
		CheckOverlap = 0;
		ManualMesh = 0;
		MeshLevel = 5;
		
		InterfaceThickness = InterfaceThickness1 + InterfaceThickness2;
		
		
		/*******
		if (isEpsDistribution == 0) {  // epmodel's fields are string
			epmodel.ep = 2; // epmodel is a num or a string?
		    epmodel.epp = 1e-3;
			
			double epintShift = 0;
			epmodel.epint = epmodel.ep + epintShift;
			double eppintShift = 0;
			epmodel.eppint = epmodel.epp + eppintShift;
		}
		****/
	
		
		String strACMode;
		if (ACMode == 1) {
			strACMode = "AC";
		} else if ( ACMode == 0) {
			strACMode = "DC";
		} else {
			strACMode = null;
		}
		
		DomLength = (double) constt.L;
		vf_expt       = (double) constt.vf;                        
		TauShift1     = (double) constt.TauShift1;  				
		DeltaEpsilonShift1   = (double) constt.DeltaEpsilonShift1 ;       
		TauShift2   = (double) constt.TauShift2;                
		DeltaEpsilonShift2   = (double) constt.DeltaEpsilonShift2;       
		ConstEpsilonShift   = (double) constt.ConstEpsilonShift;
		tau0   = (double) constt.tau;

		String PScoeff = "./RoomTempEpoxyYHNew.mat";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");
		Date date = Calendar.getInstance().getTime(); 
		
		
		String savefile = "./HZ_3D_comsolbuild_"+strACMode+"_"+ImageType+"_"+dateFormat.format(date)+"_IP"+Double.toString(IP1)+"+"+Double.toString(IP2)+"_run_"+Double.toString(TrialNo);
		
		Model model = myfun_comsol_build(PScoeff, binsource, savefile);
		model.name(savefile + ".mph");
		// model.myfun_comsol_build(PScoeff, imagefile, savefile);

		System.out.println("Job done. Output result to .mph file");
		
		// model.save(savefile);
		// mphsave(model, savefile); // what is this?
	}
	
	public Model myfun_comsol_build(String PScoeff, String binsource, String savefile) throws Exception{
		try {
			ModelUtil.connect("localhost", 2036);
			Model model = ModelUtil.load("base.mph");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}