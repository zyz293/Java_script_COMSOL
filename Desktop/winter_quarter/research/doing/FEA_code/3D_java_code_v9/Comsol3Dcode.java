import com.comsol.model.*;
import com.comsol.model.util.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.io.*;
// import java.io.File;

import java.math.BigDecimal;

public class Comsol3Dcode {
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
	private String TimeRange;
	private double CurrentSource;
	private double Compfreq;
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
	private double MatrixConductivity;
	private double FillerConductivity;
	private double FillerRelPerm;
	private double[] FreqRange;
	private double doubleerfaceRelPerm;
	private double doubleerfaceImagPerm;
	private double ElectrodeConductivity;
	private double ElectrodeRelPerm;
	private double[][] EllipseMatrix;
	private double InterfaceConductivity;
	private double InterfaceRelPerm;
	private double InterfaceImagPerm;
	private double InitialVoltage;
	private int NewClusterNo;
	private double rt_electrode1X;
	private double rt_electrode2X;
	private double rt_electrode3X;
	private double rt_electrode1Y;
	private double rt_electrode2Y;
	private double rt_electrode3Y;
	private double ReScale;
	private double sbimagefile;
	private double NewPosX;
	private double NewPosY;
	private double NewShortAxis;
	private double NewLongAxis;
	private double NewAngle;
	private double GBbr;
	private double GBbs;

	
	private double consttL;
	private double consttvf;                        
	private double consttTauShift1;  				
	private double consttDeltaEpsilonShift1 ;       
	private double consttTauShift2;                
	private double consttDeltaEpsilonShift2;       
	private double consttConstEpsilonShift;
	private double constttau;
	private double consttdimension_to_pixel;
	
	private double IF1mode;
	private double IF2;
	private String PScoeff;
	private String binsource;

	private static final int DEF_DIV_SCALE = 10;

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();	
	}

	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}
	
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static void main(String[] args) throws Exception {
		try {	
		ModelUtil.connect("localhost", 2041);	
		new Comsol3Dcode().run();
		} catch (Exception e) {}
	} 
	
	public Model run() throws Exception {
		try{
		/*****************runmain();***********************/
		double TrialNo = 1;
		consttL = 600;
		/*
		String binsource = "./sample_binary_input_3D_parameter_output.txt";
		
		consttvf = 1/100;                        
		consttTauShift1 = 1;  				
		consttDeltaEpsilonShift1 = 1;       
		consttTauShift2 = 1;                
		consttDeltaEpsilonShift2 = 1;       
		consttConstEpsilonShift = 0;
		constttau = 0.05;
		consttdimension_to_pixel = 400/240;
		*/
		
		BufferedReader workingfile = new BufferedReader(new FileReader("./workingdir.str"));
		String wdir = workingfile.readLine();
		
		
		BufferedReader polymerfile = new BufferedReader(new FileReader("./polymer.word"));
		String polymer = polymerfile.readLine();
		
		PScoeff = "./RoomTempEpoxyYHNew.txt";
		MatrixConductivity = 1e-15;
		/****
		java 6 does not support string case of switch-case, you can use if-else if more polymer 
		is added, and so does particle and graft
		
		switch(polymer) {
			// case "epoxy":
			default:
				PScoeff = "./RoomTempEpoxyYHNew.txt";
				MatrixConductivity = 1e-15;
		}
		*****/
		BufferedReader particlefile = new BufferedReader(new FileReader("./particle.word"));
		String particle = particlefile.readLine();
		
		
		FillerConductivity = 1e-15;
		FillerRelPerm = 3.9;
		/***
		switch(particle) {
			// case "SiO2":
			default:
				FillerConductivity = 1e-15;
				FillerRelPerm = 3.9;
		}
		****/
		
		BufferedReader graftfile = new BufferedReader(new FileReader("./graft.word"));
		String graft = graftfile.readLine();
		// System.out.println(graft);
		if (graft.equals("monoPGMA")) {
				IF1mode = 0;
					
				InterfaceRelPerm = 0;
				InterfaceImagPerm = 0;
				InterfaceConductivity = 0;
				
				consttTauShift1 = 1;
				consttDeltaEpsilonShift1 = 1;
				consttTauShift2 = 1;
				consttDeltaEpsilonShift2 = 1;
				consttConstEpsilonShift = 0;
				binsource = "./crop_PGMA_2wt%_3D_structure_output.txt";
				consttdimension_to_pixel = div(400, 240); // 1.6667; // 400/240;
				consttdimension_to_pixel = div(200, 432); // 0.4630; // 200/432;
		} else if (graft.equals("ferroPGMA")) {
				IF1mode = 1;
				InterfaceRelPerm = 4;
				InterfaceImagPerm = 0.24;
				InterfaceConductivity = 1e-12;
				consttTauShift1 = 1;
				consttDeltaEpsilonShift1 = 1;
				consttTauShift2 = 1;
				consttDeltaEpsilonShift2 = 1;
				consttConstEpsilonShift = 0;
				binsource = "./crop_ferroPGMA_2wt%_2_3D_structure_output.txt";
				consttdimension_to_pixel = div(200, 432); // 0.4630; // 200/432;
		} else if (graft.equals("terthiophenePGMA")) {
				IF1mode = 1;
				InterfaceRelPerm = 2.4;
				InterfaceImagPerm = 0.001;
				InterfaceConductivity = 1e-11;
				consttTauShift1 = 1;
				consttDeltaEpsilonShift1 = 1;
				consttTauShift2 = 1;
				consttDeltaEpsilonShift2 = 1;
				consttConstEpsilonShift = 0;
				// binsource = "./crop_terthiophenePGMA_2wt%_3D_structure_output.txt";
				binsource = "./sample_output_3D_parameter_output.txt";
				consttdimension_to_pixel = div(500, 523); // 0.9560; // 500/ 523;
				// System.out.println(consttdimension_to_pixel);
		} else if (graft.equals("monothiophenePGMA")) {
				IF1mode = 1;
				InterfaceRelPerm = 2.4;
				InterfaceImagPerm = 0.001;
				InterfaceConductivity = 1e-11;
				consttTauShift1 = 1;
				consttDeltaEpsilonShift1 = 1;
				consttTauShift2 = 1;
				consttDeltaEpsilonShift2 = 1;
				consttConstEpsilonShift = 0;
				binsource = "./crop_monothiophenePGMA_2wt%_3D_structure_output.txt";
				consttdimension_to_pixel = div(500, 523); // 0.9560; // 500/ 523;
		} else if (graft.equals("anthraenePGMA")) {
				IF1mode = 1;
				InterfaceRelPerm = 3.1;
				InterfaceImagPerm = 0.05;
				InterfaceConductivity = 1e-15;
				consttTauShift1 = 1;
				consttDeltaEpsilonShift1 = 1;
				consttTauShift2 = 1;
				consttDeltaEpsilonShift2 = 1;
				consttConstEpsilonShift = 0;
				binsource = "./crop_anthracenePGMA_2wt%_3D_structure_output.txt";
				consttdimension_to_pixel = div(400, 240); // 1.6667; // 400/240;
		} else { // "bare"
				IF1mode = 0;
				
				InterfaceRelPerm = 0;
				InterfaceImagPerm = 0;
				InterfaceConductivity = 0;
				
				consttTauShift1 = 1;
				consttDeltaEpsilonShift1 = 1;
				consttTauShift2 = 1;
				consttDeltaEpsilonShift2 = 1;
				consttConstEpsilonShift = 0;
				binsource = "./crop_BS_1wt%_3D_structure_output.txt";
				consttdimension_to_pixel = div(500, 523); // 0.9560; // 500/ 523;
		}
			
		BufferedReader vffile = new BufferedReader(new FileReader("./vf.word"));
		String vf = vffile.readLine();
		consttvf = Double.parseDouble(vf);
		
		BufferedReader ipthickfile = new BufferedReader(new FileReader("./ipthick.word"));
		String ipthick = ipthickfile.readLine();
		double IP2 = Double.parseDouble(ipthick);
		
		constttau = 0.1;
		/************************************************/
		
		ImageType = "recon";
		ControlMode = "linux";
		dimension_to_pixel = consttdimension_to_pixel;
		// System.out.println(dimension_to_pixel);
		CutSide = 0.1;
		double IP1 = 5;
		// double IP2 = 10;
		InterfaceThickness1 = mul(IP1, 1e-6);
		InterfaceThickness2 = mul(IP2, 1e-6);
		
		isReScale = 0;
		isGetSolution = 1;
		isEpsDistribution = 1;
		ACMode = 1;
		ACbreakdown = 0;
		CheckOverlap = 0;
		ManualMesh = 0;
		MeshLevel = 5;
		InterfaceThickness = add(InterfaceThickness1, InterfaceThickness2);
		
		String strACMode;
		if (ACMode == 1) {
			strACMode = "AC";
		} else if ( ACMode == 0) {
			strACMode = "DC";
		} else {
			strACMode = null;
		}
		
		DomLength = consttL;
		vf_expt       = consttvf;                        
		TauShift1     = consttTauShift1;  				
		DeltaEpsilonShift1   = consttDeltaEpsilonShift1 ;       
		TauShift2   = consttTauShift2;                
		DeltaEpsilonShift2   = consttDeltaEpsilonShift2;       
		ConstEpsilonShift   = consttConstEpsilonShift;
		tau0   = constttau;

		// String PScoeff = "./RoomTempEpoxyYHNew.txt";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");
		Date date = Calendar.getInstance().getTime(); 
		
		
		String savefile = "./HZ_3D_comsolbuild_"+strACMode+"_"+ImageType+"_"+dateFormat.format(date)+"_IP"+Double.toString(IP1)+"+"+Double.toString(IP2)+"_run_"+Double.toString(TrialNo);

			/**************model.myfun_comsol_load_constant();*******************/
			extra_E_infi         = -0.55;                
			AppliedVoltage    = 1.5e-3;               
			InitialVoltage       = 0.01e-3;              
			CurrentSource     = 2e3;    
			FreqRange = new double[46];
			for (int i = 0; i <46; i++) {
				FreqRange[i] = Math.pow(10.0, -3+i*0.2);
			}     
			TimeRange           = "range(0,0.25,20)";  
			
			// MatrixConductivity        = 1e-15;      
			// FillerConductivity          = MatrixConductivity;    
			// FillerRelPerm                 = 3.9;         
			
			
/* Move variables below to the beginning of file as material selection, polymer, particle, graft, vf, ipthick */			
			// InterfaceRelPerm          = 2.4;                
			// InterfaceImagPerm       = 0.001; 
			// InterfaceConductivity    = 1e-11;   



			
			ElectrodeRelPerm          = 2; 
			ElectrodeConductivity   = 1e6;   
			/*************************************************************/
			
			if (isEpsDistribution == 1) { 
				if (ACMode == 1) {
					System.out.println("AC mode is selected. Begin applying dielectric permittivity spectroscopy Prony series to polymer data.");
					
					
					BufferedReader Te = new BufferedReader(new FileReader(PScoeff));
					int row1 = Integer.parseInt(Te.readLine());
					int col1 = Integer.parseInt(Te.readLine());
					double[][] TemPR = new double[row1][col1];
					String line1 = Te.readLine();
					int m = 0;
					String[] str1;
					while (line1 != null) {
						str1 = line1.split(",");
						for (int j = 0; j <str1.length; j++) {
							TemPR[m][j] = Double.parseDouble(str1[j]);
						}
						m ++;
						line1 = Te.readLine();
					}	
					
					// matreader a = new matreader(PScoeff);
					// double[][] TemPR = a.TemPR;
					int NumOfTerms = TemPR.length;


					double[] MTD_Coeff = new double[2* NumOfTerms-1];
					for (int i = 0; i < NumOfTerms-1; i++) {
						MTD_Coeff[2*i] = TemPR[i][1];
						MTD_Coeff[2*i+1] = TemPR[i][0];
					}

					MTD_Coeff[2*NumOfTerms-2] = add(TemPR[NumOfTerms-1][1], extra_E_infi);
					

					NumOfTerms = (int) div(MTD_Coeff.length, 2);
					// NumOfTerms = (int) NumOfTerms;

					String str_real = "";
					String str_imag = "";
					String str_Intreal = "";
					String str_Intimag = "";
					String str_CurrentTermImag = "";
					String str_CurrentTermReal = "";
					String str_CurrentIntTermImag = "";
					String str_CurrentIntTermReal = "";

					for (int i = 0; i < NumOfTerms; i++) {
						str_CurrentTermReal = String.format("+%.3f/(1+(10^(%.3f)*ec.freq/1[Hz])^2)", MTD_Coeff[2*i], MTD_Coeff[2*i+1]);
						str_CurrentTermImag = String.format("+%.3f*(10^(%.3f)*ec.freq/1[Hz])/(1+(10^(%.3f)*ec.freq/1[Hz])^2)", MTD_Coeff[2*i], MTD_Coeff[2*i+1], MTD_Coeff[2*i+1]);
						
						if (Math.pow(10.0, MTD_Coeff[2*i+1]) > tau0) {
							str_CurrentIntTermReal = String.format("+%.3f*DS2/(1+(10^(%.3f)*TS2*ec.freq/1[Hz])^2)", MTD_Coeff[2*i], MTD_Coeff[2*i+1]);
							str_CurrentIntTermImag = String.format("+%.3f*DS2*(10^(%.3f)*TS2*ec.freq/1[Hz])/(1+(10^(%.3f)*TS2*ec.freq/1[Hz])^2)", MTD_Coeff[2*i], MTD_Coeff[2*i+1], MTD_Coeff[2*i+1]);	
						} else {
							str_CurrentIntTermReal = String.format("+%.3f*DS1/(1+(10^(%.3f)*TS1*ec.freq/1[Hz])^2)", MTD_Coeff[2*i], MTD_Coeff[2*i+1]);
							str_CurrentIntTermImag = String.format("+%.3f*DS1*(10^(%.3f)*TS1*ec.freq/1[Hz])/(1+(10^(%.3f)*TS1*ec.freq/1[Hz])^2)", MTD_Coeff[2*i], MTD_Coeff[2*i+1], MTD_Coeff[2*i+1]);
						}
						
						str_real = str_real + str_CurrentTermReal;
						str_imag = str_imag + str_CurrentTermImag;
						str_Intreal = str_Intreal + str_CurrentIntTermReal;
						str_Intimag = str_Intimag + str_CurrentIntTermImag;
					}
					
					String rreal = String.format("+%.3f", MTD_Coeff[MTD_Coeff.length -1]);
					String immag = String.format("+%.3f+const", MTD_Coeff[MTD_Coeff.length - 1]);
					
					str_real = str_real + rreal;
					str_imag = str_imag + immag;
					
					ep = str_real;
					epp = str_imag;
					epint = str_Intimag;
					eppint = str_Intreal;
					
					

					/********************************************************************/
				} else {
					System.out.println("DC mode is selected. No need to compute complex dielectric permittivity.");
					ep = null;
					epp = null;
					epint = null;
					eppint = null;
				}
				/*************************************************************************/
			}


			/***************model.myfun_comsol_load_image(imagefile);************************/
			double RemainSide = sub(1, mul(2, CutSide));
			System.out.println("Ratio of physical length to pixel: "+Double.toString(dimension_to_pixel)+"nm-per-pixel");
			dimensionX = mul(DomLength, mul(dimension_to_pixel, 1e-6));
			// System.out.println(dimensionX);
			dimensionY = dimensionX;
			dimensionZ = dimensionX;
			
			if (ImageType.equals("recon")) {
				
				// System.out.println(binsource);
				BufferedReader Im = new BufferedReader(new FileReader(binsource));
				int row2 = Integer.parseInt(Im.readLine());
				// System.out.println(row2);
				int col2 = Integer.parseInt(Im.readLine());
				double[][] img_para = new double[row2][col2];
				String line2 = Im.readLine();
				int n = 0;
				String[] str2;
				while (line2 != null) {
					str2 = line2.split(",");
					for (int j = 0; j <str2.length; j++) {
						img_para[n][j] = Double.parseDouble(str2[j]);
					}
					n ++;
					line2 = Im.readLine();
				}	
				
				
				
				
				// matreader b = new matreader(binsource);
				// double[][] img_para = b.img_para;
				// NewClusterNo = (int) img_para.length;
				NewClusterNo = (int) row2;
				// System.out.println(NewClusterNo);
				EllipseMatrix = new double[NewClusterNo][7];
				for (int i = 0; i < NewClusterNo; i++) {
					EllipseMatrix[i][0] = add(mul(mul(div(img_para[i][0], DomLength),RemainSide), dimensionX), mul(CutSide, dimensionX));
					EllipseMatrix[i][1] = add(mul(mul(div(img_para[i][1], DomLength),RemainSide), dimensionY), mul(CutSide, dimensionY));
					EllipseMatrix[i][2] = add(mul(mul(div(img_para[i][2], DomLength),RemainSide), dimensionZ), mul(CutSide, dimensionZ));
					EllipseMatrix[i][3] = mul(mul(div(img_para[i][3], DomLength),RemainSide), dimensionX);
					EllipseMatrix[i][4] = mul(mul(div(img_para[i][4], DomLength),RemainSide), dimensionX);
					EllipseMatrix[i][5] = img_para[i][5];
					EllipseMatrix[i][6] = img_para[i][6];
				}
				System.out.println("Number of clusters in FEA geometry: "+Integer.toString(NewClusterNo));
				double[] ShortSq = new double[NewClusterNo];
				for (int i = 0; i < NewClusterNo; i++) {
					ShortSq[i] = Math.pow(EllipseMatrix[i][4], 2);
				}
				
				double ActualVF = div(mul(div(4.0,3.0),3.1416), mul(mul(dimensionX, dimensionY), dimensionZ));
				// System.out.println(ActualVF);
				double matrix1 = 0;
				for (int i = 0; i< NewClusterNo; i++) {
					matrix1 = add(matrix1, mul(EllipseMatrix[i][3], ShortSq[i]));
				}
				ActualVF = mul(ActualVF, matrix1);
				
				System.out.println("VF before scaling: "+Double.toString(ActualVF));
				
				if (isReScale == 1) {
					ReScale = Math.pow(vf_expt/ActualVF, 1/3);
					for (int i = 0; i < NewClusterNo; i++) {
						EllipseMatrix[i][3] = mul(EllipseMatrix[i][3], ReScale);
						EllipseMatrix[i][4] = mul(EllipseMatrix[i][4], ReScale);
					}
				}
				
				for (int i = 0; i < NewClusterNo; i++) {
					ShortSq[i] = Math.pow(EllipseMatrix[i][4], 2);
				}
				
				double CorrectedVF = div(mul(div(4,3),3.1416), mul(mul(dimensionX,dimensionY), dimensionZ));
				double matrix2 = 0;
				for (int i = 0; i< NewClusterNo; i++) {
					matrix2 = add(matrix2, mul(EllipseMatrix[i][3], ShortSq[i]));
				}
				CorrectedVF = mul(CorrectedVF, matrix2);
				System.out.println("Corrected VF in simulation window: "+Double.toString(CorrectedVF));
			}
			
			/**************************************************************************/

/************************start to build the model**************************/
			
			
			
			
			
			/*****Model model = ModelUtil.load("model","base.mph");**************/
			Model model = ModelUtil.create("Model");

			// model.modelPath("/home/zyz293/javacode/3D_java_code_v5");

			model.modelNode().create("mod1");

			model.geom().create("geom1", 3);
			model.geom("geom1").lengthUnit("mm");
			model.variable().create("var1");
			model.variable("var1").model("mod1");
			if (ACMode == 1) {
				System.out.println("AC mode: define polymer and interphase dielectric permittivity.");
				model.variable("var1").set("ep",ep);
				model.variable("var1").set("epp",epp);
				model.variable("var1").set("epint",epint);
				model.variable("var1").set("eppint",eppint);       
			}			
			System.out.println("Load cluster geometry...");

			String[] FeatureName = new String[NewClusterNo];
			String[] FeatureName1 = new String[NewClusterNo];
			String[] FeatureName2 = new String[NewClusterNo];

			model.geom("geom1").feature().create("blk1", "Block");
			model.geom("geom1").run("blk1");

			model.geom("geom1").feature("blk1").set("size", new double[] {dimensionX, dimensionY, dimensionZ});
			model.geom("geom1").feature("blk1").set("createselection", "on");
			// model.geom("geom1").runAll();

			for (int i = 0; i < NewClusterNo; i++) {
				FeatureName[i] = "Ellipse"+Integer.toString(i);
				model.geom("geom1").feature().create(FeatureName[i],"Ellipsoid");	
				model.geom("geom1").feature(FeatureName[i]).set("pos", new double[]{EllipseMatrix[i][0], EllipseMatrix[i][1], EllipseMatrix[i][2]});
				model.geom("geom1").feature(FeatureName[i]).set("semiaxes", new double[]{EllipseMatrix[i][3], EllipseMatrix[i][4], EllipseMatrix[i][4]});
				model.geom("geom1").feature(FeatureName[i]).set("rot", EllipseMatrix[i][5]);
				model.geom("geom1").feature(FeatureName[i]).set("createselection","on");
				System.out.println("Ellipse"+Integer.toString(i));
			}
			// model.geom("geom1").runAll(); // problem!!!!!!!!!!!!!!!!!!			
			

			
			// model.geom("geom1").feature().create("blk1", "Block");

			// model.geom("geom1").run("blk1");
			/******************model.myfun_comsol_create_model();**************************/
			// model.geom("geom1").lengthUnit("mm");
			// model.variable().create("var1");
			// model.variable("var1").model("mod1");
			/*
			if (ACMode == 1) {
				System.out.println("AC mode: define polymer and interphase dielectric permittivity.");
				model.variable("var1").set("ep",ep);
				model.variable("var1").set("epp",epp);
				model.variable("var1").set("epint",epint);
				model.variable("var1").set("eppint",eppint);       
			}
			*/
			/**************************************************************************/


/******************model.myfun_comsol_create_structure();************************/
			/*
			System.out.println("Load cluster geometry...");
			String[] FeatureName = new String[NewClusterNo];
			String[] FeatureName1 = new String[NewClusterNo];
			String[] FeatureName2 = new String[NewClusterNo];
			
			model.geom("geom1").feature("blk1").set("size", new double[] {dimensionX, dimensionY, dimensionZ});
			model.geom("geom1").feature("blk1").set("createselection", "on");
			model.geom("geom1").runAll();

			for (int i = 0; i < NewClusterNo; i++) {
				FeatureName[i] = "Ellipse"+Integer.toString(i);
				model.geom("geom1").feature().create(FeatureName[i],"Ellipsoid");	
				model.geom("geom1").feature(FeatureName[i]).set("pos", new double[]{EllipseMatrix[i][0], EllipseMatrix[i][1], EllipseMatrix[i][2]});
				model.geom("geom1").feature(FeatureName[i]).set("semiaxes", new double[]{EllipseMatrix[i][3], EllipseMatrix[i][4], EllipseMatrix[i][4]});
				model.geom("geom1").feature(FeatureName[i]).set("rot", EllipseMatrix[i][5]);
				model.geom("geom1").feature(FeatureName[i]).set("createselection","on");
				System.out.println("Ellipse"+Integer.toString(i));
			}
			model.geom("geom1").runAll(); // problem!!!!!!!!!!!!!!!!!!
			*/
			model.geom("geom1").feature().create("UnionFiller", "Union");
			model.geom("geom1").feature("UnionFiller").selection("input").set(FeatureName);
			model.geom("geom1").feature("UnionFiller").set("createselection", "on");
			model.geom("geom1").feature("UnionFiller").set("intbnd", "off");
			// model.geom("geom1").runAll(); // problem !!!!!!!!!!!!!!!!!!!!!!!!!!

			for (int i = 0; i < NewClusterNo; i ++) {
				FeatureName1[i] = "EllipseIF1"+Integer.toString(i);
				model.geom("geom1").feature().create(FeatureName1[i],"Ellipsoid");
				model.geom("geom1").feature(FeatureName1[i]).set("pos", new double[]{EllipseMatrix[i][0], EllipseMatrix[i][1], EllipseMatrix[i][2]});
				model.geom("geom1").feature(FeatureName1[i]).set("semiaxes", new double[]{add(EllipseMatrix[i][3], InterfaceThickness1), add(EllipseMatrix[i][4], InterfaceThickness1), add(EllipseMatrix[i][4], InterfaceThickness1)});

				model.geom("geom1").feature(FeatureName1[i]).set("rot", EllipseMatrix[i][5]);
				model.geom("geom1").feature(FeatureName1[i]).set("createselection","on");
				System.out.println("EllipseIF1-"+Integer.toString(i));
				
			}

			model.geom("geom1").runCurrent(); // problem !!!!!!!!!!!!!!!!!!!!!!
			
			model.geom("geom1").feature().create("UnionLargeEllipse1", "Union");
			model.geom("geom1").feature("UnionLargeEllipse1").selection("input").set(FeatureName1);
			model.geom("geom1").feature("UnionLargeEllipse1").set("createselection", "on");
			model.geom("geom1").feature("UnionLargeEllipse1").set("intbnd", "off");
			// mphsave(model,"test_mid1");
			// model.name("test_mid1.mph");			
			// model.geom("geom1").runAll();  // problem !!!!!!!!!!!!!!!

			model.geom("geom1").feature().create("DiffInterface1", "Difference");
			model.geom("geom1").feature("DiffInterface1").selection("input").set("UnionLargeEllipse1");
			model.geom("geom1").feature("DiffInterface1").selection("input2").set("UnionFiller");
			model.geom("geom1").feature("DiffInterface1").set("keep", "on");
			model.geom("geom1").feature("DiffInterface1").set("createselection", "on");
			model.geom("geom1").feature("DiffInterface1").set("intbnd", "off");
			
			model.geom("geom1").runCurrent(); // problem !!!!!!!!!!!!!!!!!!!!!!

			for (int i = 0; i < NewClusterNo; i++) {
				FeatureName2[i] = "EllipseIF2"+Integer.toString(i);
				model.geom("geom1").feature().create(FeatureName2[i],"Ellipsoid");
				model.geom("geom1").feature(FeatureName2[i]).set("pos", new double[]{EllipseMatrix[i][0], EllipseMatrix[i][1], EllipseMatrix[i][2]});
				model.geom("geom1").feature(FeatureName2[i]).set("semiaxes", new double[]{EllipseMatrix[i][3]+InterfaceThickness1+InterfaceThickness2, EllipseMatrix[i][4]+InterfaceThickness1+InterfaceThickness2, EllipseMatrix[i][4]+InterfaceThickness1+InterfaceThickness2});
				model.geom("geom1").feature(FeatureName2[i]).set("rot", EllipseMatrix[i][5]);
				model.geom("geom1").feature(FeatureName2[i]).set("createselection","on");
				System.out.println("EllipseIF2-"+Integer.toString(i));
			}
			
			// model.geom("geom1").runAll(); // problem!!!!!!!!!!!!!!!!!!!!!!
			model.geom("geom1").feature().create("UnionLargeEllipse2", "Union");
			model.geom("geom1").feature("UnionLargeEllipse2").selection("input").set(FeatureName2);
			model.geom("geom1").feature("UnionLargeEllipse2").set("createselection", "on");
			model.geom("geom1").feature("UnionLargeEllipse2").set("intbnd", "off");
			// model.geom("geom1").runAll(); // problem !!!!!!!!!!!!!!!!!!!!!!
																								System.out.println("safsafdasfsadfsafsasa\n");		

			model.geom("geom1").feature().create("DiffInterface2", "Difference");
			model.geom("geom1").feature("DiffInterface2").selection("input").set(new String[] {"UnionLargeEllipse2"});
			model.geom("geom1").feature("DiffInterface2").selection("input2").set(new String[] {"UnionLargeEllipse1"});
			model.geom("geom1").feature("DiffInterface2").set("keep", "on");
			model.geom("geom1").feature("DiffInterface2").set("createselection", "on");
			model.geom("geom1").feature("DiffInterface2").set("intbnd", "off");
			// model.geom("geom1").runAll(); // problem !!!!!!!!!!!!!!!!!!!
			
					
			model.geom("geom1").feature().create("DiffMatrix", "Difference");
			model.geom("geom1").feature("DiffMatrix").selection("input").set(new String[] {"blk1"});
			model.geom("geom1").feature("DiffMatrix").selection("input2").set(new String[] {"UnionLargeEllipse2"});
			model.geom("geom1").feature("DiffMatrix").set("keep", "on");
			model.geom("geom1").feature("DiffMatrix").set("createselection", "on");
			// model.geom("geom1").runAll();  problem !!!!!!!!!!!!!!
			
			System.out.println("Finished building unions and differences on fillers, interphase, and rectangular simulation block.");
			
			/***************************************************************************/










			model.mesh().create("mesh1", "geom1");
			// model.physics().create("ec", "ConductiveMedia", "geom1"); // problem!!!!!!!!


			// model.geom("geom1").run(); // problem!!!!!!!!


			// model.material().create("mat1");
		        // model.material("mat1").propertyGroup("def").set("electricconductivity", new String[]{"1E-12"});
		        // model.material("mat1").propertyGroup("def").set("relpermittivity", new String[]{"4"});

		        model.physics("ec").feature("init1").set("V", 1, "1E-5");
		        model.physics("ec").feature().create("gnd1", "Ground", 2);
		        model.physics("ec").feature("gnd1").selection().set(new int[]{4});
		        model.physics("ec").feature().create("pc1", "PeriodicCondition", 2);
		        model.physics("ec").feature("pc1").selection().set(new int[]{1, 6});
		        model.physics("ec").feature().create("term1", "Terminal", 2);
		        model.physics("ec").feature("term1").selection().set(new int[]{3});
		        model.physics("ec").feature("term1").set("TerminalType", 1, "Voltage");
		        model.physics("ec").feature("term1").set("V0", 1, "0.1");

		        // model.material().remove("mat1");

			/********************************************************************/		
			



			

	
	

			// model.name(savefile + ".mph");
			System.out.println("Job done. Output result to .mph file");
			
			File source = new File("./" + savefile + ".mph");
			source.renameTo(new File(wdir +"/" + source.getName()));
			
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
