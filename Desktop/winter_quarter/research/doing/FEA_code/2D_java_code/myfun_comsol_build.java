import com.jmatio.io.*;
import com.jmatio.types.*;
import com.comsol.model.*
import com.comsol.model.util.*


public class myfun_comsol_build {
	private double TauShift1;
	private String TimeRange;
	private double DeltaEpsilonShift1;
	private double DomLength;
	private double dimension_to_pixel;
	private double TauShift2;
	private double DeltaEpsilonShift2;
	private double ConstEpsilonShift;
	private double CurrentSource;
	private double Compfreq;
	private double CutSide;
	private boolean isEpsDistribution;
	private double AppliedVoltage;
	private double ActualLength;
	private double dimensionY;
	private double dimensionX;
	private double electrode1X;
	private double electrode3X;
	private double electrode1Y;
	private double electrode3Y;
	private double extra_E_infi;
	private double ACMode;
	private double MatrixConductivity;
	private double FillerConductivity;
	private double FillerRelPerm;
	private double FreqRange;
	private double doubleerfaceRelPerm;
	private double doubleerfaceImagPerm;
	private double ElectrodeConductivity;
	private double ElectrodeRelPerm;
	private double EllipseMatrix;
	private double InterfaceConductivity;
	private double InterfaceRelPerm;
	private double InterfaceImagPerm;
	private double InterfaceThickness1;
	private double InterfaceThickness2;
	private double InitialVoltage;
	private boolean ManualMesh;
	private double MatrixConductivity;
	private double[] epmodel;
	private double NewClusterNo;
	private double rt_electrode1X;
	private double rt_electrode2X;
	private double rt_electrode3X;
	private double rt_electrode1Y;
	private double rt_electrode2Y;
	private double rt_electrode3Y;
	private double ReScale;
	private String ImageType;
	private double sbimagefile;
	private double NewClusterNo;
	private double NewPosX;
	private double NewPosY;
	private double NewShortAxis;
	private double NewLongAxis;
	private double NewAngle;
	private double CheckOverlap;
	private double GBbr;
	private double GBbs;
	private double isReScale;
	private double sbimagefile;
	private double vf_expt;
	private double NewLongAxis;
	private double NewAngle;
	private double isGetSolution;
	
	
	public  myfun_comsol_build(PScoeff, imagefile, savefile) {
		if (ControlMode.toLowerCase() == "pc") {
			addpath('C:\COMSOL42\mli','C:\COMSOL42\mli\startup');
			addpath('D:\COMSOL42\mli','D:\COMSOL42\mli\startup');
			addpath('E:\COMSOL42\mli','E:\COMSOL42\mli\startup');
		} else if (ControlMode.toLowerCase() == "linux") {
			addpath('/home/hzg972/comsol42/mli','/home/hzg972/comsol42/mli/startup');
		} else if (ControlMode.toLowerCase() == "mac") {
			addpath '/Applications/COMSOL42a/mli/startup'; % Mac
			addpath '/Applications/COMSOL42a/mli';
		}
		
		/******myfun_comsol_load_constant();*************/
		if (ACMode == 1) { // not defined
			rt_electrode1X = 0.125/0.3;
			rt_electrode1Y = 0;
			rt_electrode2X = 0.15/0.3;
			rt_electrode2Y = 0.03/0.15;
			rt_electrode3X = 0.175/0.3;
			rt_electrode3Y = 0;
		}
		extra_E_infi         = -0.55;                
		AppliedVoltage    = 1.5e-3;               
		InitialVoltage       = 0.01e-3;              
		CurrentSource     = 2e3;                   
		FreqRange           = 10.^(-3:0.2:6);       
		TimeRange           = 'range(0,0.25,20)';  
		
		MatrixConductivity        = 1e-15;      
		FillerConductivity          = MatrixConductivity;    
		FillerRelPerm                 = 3.9;               
		InterfaceRelPerm          = 2.4;                
		InterfaceImagPerm       = 0.001; 
		InterfaceConductivity    = 1e-11;                
		ElectrodeRelPerm          = 2; 
		ElectrodeConductivity   = 1e6;   
		/********************************************/
		
		/*************myfun_comsol_create_load_epsilon_model(data)*********/
		if (isEpsDistribution) { // not defined
			if (ACMode.toLowerCase() == 1) {
				System.out.println("AC mode is selected. Begin applying dielectric permittivity spectroscopy Prony series to polymer data.");
				MatFileReader matfile = new MatFileReader(binsource);
				double[][] TemPR = ((MLDouble) matfile.getMLArray("data")).getArray();
				double NumOfTerms = TemPR.length();
				
				double[] MTD_Coeff = new double[2*NumOfTerms-1];
				for (int i = 0; i < NumOfTerms-1; i++) {
					MTD_Coeff[2*i] = TemPR[i][2];
					MTD_Coeff[2*i+1] = TemPR[i][1];
				}
				MTD_Coeff[2*NumOfTerms-2] = TemPR[NumOfTerms-1][2] + extra_E_infi;
				
				/**[epmodel.ep, epmodel.epp, epmodel.epint, epmodel.eppint]=MTD_str(MTD_Coeff)**/
				String[] str = new MTD_str(MTD_Coeff);
				
				
				
				
				/********************************************************************/
			} else {
				System.out.println("DC mode is selected. No need to compute complex dielectric permittivity.");
				// epmodel = [] what is the type of epmodel
			}
		}
		/*************************************************************/
	
		myfun_comsol_load_image(imagefile);
		
		mphstart(2036); // what is this?
		
		/*************????????????????????????******************/
		model = ModelUtil.create('Model');
		model.modelNode.create('mod1');
		/****************??????????????????*********************/
		myfun_comsol_create_model(model);
		myfun_comsol_create_structure(model);
		myfun_comsol_create_boundary_selection(model); // indBoundary
		myfun_comsol_create_material(model, ACbreakdown);
		myfun_comsol_create_physics(model, indBoundary);
		myfun_comsol_create_mesh(model5, indBoundary);
		
		
		if (ACMode) { // ????
			double[] SF = double[5];
			SF[0] = TauShift1;
			SF[1] = DeltaEpsilonShift1;
			SF[2] = TauShift2;
			SF[3] = DeltaEpsilonShift2;
			SF[4] = ConstEpsilonShift;
			
			myfun_comsol_create_shifting_factors(model, SF);
		}
		
		myfun_comsol_create_study(model, ACbreakdown);
		
		if (isGetSolution == 1) {
			myfun_comsol_create_solution(model);
			myfun_comsol_create_post_process(model, indBoundary, savefile);
		}
	}
	
	public static void myfun_comsol_load_image(String imagefile) {
		double RemainSide = 1-2*CutSide;
		System.out.println("Ratio of physical length to pixel: "+Double.toString(dimension_to_pixel)+"nm-per-pixel");
		dimensionX = ActualLength*dimension_to_pixel*1e-6;
		dimensionY = dimensionX;
		
		if (ImageType == 'binary') {
			/**************use pakeage convert from matlab**********/
			
			
			
			
			
			
			
			/***************************************************/
		} else if (ImageType == 'recon') {
			MatFileReader matfile = new MatFileReader(imagefile);
			double[][] img_para = ((MLDouble) matfile.getMLArray("data")).getArray();
			NewClusterNo = img_para.length();
			double Nrow = img_para[0].length();
			double[][] EllipseMatrix = double[NewClusterNo][5];
			for (int i = 0; i < NewClusterNo; i++) {
				EllipseMatrix[i][0] = img_para[i][4];
				EllipseMatrix[i][1] = img_para[i][2]/DomLength*RemainSide*dimensionX;
				EllipseMatrix[i][2] = img_para[i][3]/DomLength*RemainSide*dimensionX;
				EllipseMatrix[i][3] = img_para[i][0]/DomLength*RemainSide*dimensionX+CutSide*dimensionX;
				EllipseMatrix[i][4] = img_para[i][1]/DomLength*RemainSide*dimensionY+CutSide*dimensionY;
			}
			System.out.println("Number of clusters in FEA geometry: "+Double.toString(NewClusterNo));
			
			double ActualVF = 3.1416/(dimensionX*dimensionY);
			double matrix1 = 0;
			for (int i = 0; i< NewClusterNo; i++) {
				matrix1 = matrix1 + EllipseMatrix[i][1]*EllipseMatrix[i][2];
			}
			ActualVF = ActualVF * matrix1;
			
			System.out.println("Actual VF in simulation window: "+Double.toString(ActualVF));
			
			if (isReScale == 1) {
				ReScale = sqrt(vf_expt/ActualVF);
				for (int i = 0; i < NewClusterNo; i++) {
					EllipseMatrix[i][1] = EllipseMatrix[i][1]*ReScale;
					EllipseMatrix[i][2] = EllipseMatrix[i][2]*ReScale;
				}
			}
			double CorrectedVF = 3.1416/(dimensionX*dimensionY);
			double matrix2 = 0;
			for (int i = 0; i< NewClusterNo; i++) {
				matrix2 = matrix2 + EllipseMatrix[i][2]*EllipseMatrix[i][1];
			}
			CorrectedVF = CorrectedVF * matrix2;
			System.out.println("Corrected VF in simulation window: "+Double.toString(CorrectedVF));
		}
	}
	
	public String[] MTD_str(double[] x) {
		double NumOfTerms = floor(x.length() / 2.0);
		String str_real = '"';
		String str_imag = '"';
		String str_Intreal = '"';
		String str_Intimag = '"';
		String str_CurrentTermReal;
		String str_CurrentTermImag;
		String str_CurrentIntTermReal;
		String str_CurrentIntTermImag;
		for (int i = 0; i < NumOfTerms; i++) {
			str_CurrentTermReal = String.format("+%.3g/(1+(10^(%.3g)*ec.freq/1[Hz])^2)", x[2*i], x[2*i+1]);
			str_CurrentTermImag = String.format("+%.3g*(10^(%.3g)*ec.freq/1[Hz])/(1+(10^(%.3g)*ec.freq/1[Hz])^2)'", x[2*i], x[2*i+1], x[2*i+1]);
			
			double tau0 = 1;
			
			if (10^x[2*i+1] > tau0) {
				str_CurrentIntTermReal = String.format("+%.3g*DS2/(1+(10^(%.3g)*TS2*ec.freq/1[Hz])^2)", x[2*i], x[2*i+1]);
				str_CurrentIntTermImag = String.format("+%.3g*DS2*(10^(%.3g)*TS2*ec.freq/1[Hz])/(1+(10^(%.3g)*TS2*ec.freq/1[Hz])^2)", x[2*i], x[2*i+1], x[2*i+1]);	
			} else {
				str_CurrentIntTermReal = String.format("+%.3g*DS1/(1+(10^(%.3g)*TS1*ec.freq/1[Hz])^2)", x[2*i], x[2*i+1]);
				str_CurrentIntTermImag = String.format("+%.3g*DS1*(10^(%.3g)*TS1*ec.freq/1[Hz])/(1+(10^(%.3g)*TS1*ec.freq/1[Hz])^2)", x[2*i], x[2*i+1], x[2*i+1]);
			}
			
			str_real = str_real + str_CurrentTermReal;
			str_imag = str_imag + str_CurrentTermImag;
			str_Intreal = str_Intreal + str_CurrentIntTermReal;
			str_Intimag = str_Intimag + str_CurrentIntTermImag;
		}
		
		String rreal = String.format("+%0.3g", x[x.length()-1]);
		String immag = String.format("+%0.3g+const", x[x.length()-1]);
		
		str_real = str_real + rreal;
		str_imag = str_imag + immag;
	}
	
	public static void myfun_comsol_post_process(model, double[] ind2, String savefile) {
		 if (ACMode == 1) {
			 model.result.create('pg1', 2);
			model.result('pg1').set('data', 'dset1');
			model.result('pg1').feature.create('surf1', 'Surface');
			model.result('pg1').feature('surf1').set('expr', 'ec.normE');
			model.result('pg1').feature('surf1').set('descr', 'Electric field norm');
			model.result('pg1').name('Electric Field Norm (ec)');
			model.result('pg1').run;
			
			String str_EpsilonBulkImag = String.format("real(ec.Jy/%.3g[V])*%.3g[mm]/ec.freq/2/3.14/8.85e-12[F/m]", AppliedVoltage, dimensionY);
			
			model.result.numerical.create('av1', 'AvLine');
			model.result.numerical('av1').selection.set(ind2.Gnd);
			model.result.table.create('tbl1', 'Table');
			model.result.table('tbl1').comments('Line Average 1, Epsilon Double Prime');
			model.result.numerical('av1').set('table', 'tbl1');
			model.result.numerical('av1').set('expr', str_EpsilonBulkImag);
			model.result.numerical('av1').set('descr', 'Epsilon Double Prime');
			model.result.numerical('av1').setResult;
			model.result.create('pg2', 1);
			model.result('pg2').feature.create('tblp1', 'Table');
			model.result('pg2').feature('tblp1').set('table', 'tbl1');
			model.result('pg2').run;
			model.result.export.create('plot1', 'pg2', 'tblp1', 'Plot');
			model.result.export('plot1').set('header', 'off');
			String txtfilenameImag = savefile+'_CompPermImag.csv'];
			System.out.println('Write imaginary composite permittivity to file:'); 
			System.out.println(txtfilenameImag);        
			model.result.export('plot1').set('filename', txtfilenameImag);
			model.result.export('plot1').run;
			
			String str_EpsilonBulkReal = String.format("imag(ec.Jy/%.3g[V])*%.3g[mm]/ec.freq/2/3.14/8.85e-12[F/m]", AppliedVoltage, dimensionY);
			
			model.result.numerical.create('av2', 'AvLine');
			model.result.numerical('av2').selection.set(ind2.Gnd);
			model.result.table.create('tbl2', 'Table');
			model.result.table('tbl2').comments('Line Average 2, Epsilon Prime');
			model.result.numerical('av2').set('table', 'tbl2');
			model.result.numerical('av2').set('expr', str_EpsilonBulkReal);
			model.result.numerical('av2').set('descr', 'Epsilon Prime');
			model.result.numerical('av2').setResult;
			String txtfilenameReal = savefile+'_CompPermReal.csv';
			model.result.create('pg3', 1);
			model.result('pg3').feature.create('tblp2', 'Table');
			model.result('pg3').feature('tblp2').set('table', 'tbl2');
			model.result('pg3').run;
			model.result.export.create('plot2', 'pg3', 'tblp2', 'Plot');
			model.result.export('plot2').set('header', 'off');
			model.result.export('plot2').set('filename', txtfilenameReal);
			System.out.println('Write real composite permittivity to file:'); 
			System.our.println(txtfilenameReal);        
			model.result.export('plot2').run;        
		 } else {
			 model.result.create('pg1', 2);
			model.result('pg1').set('data', 'dset1');
			model.result('pg1').feature.create('surf1', 'Surface');
			
			model.result('pg1').feature('surf1').set('expr', {'V'});
			model.result('pg1').name('Electric Potential (ec)');
			
			model.result.create('pg2', 2);
			model.result('pg2').set('data', 'dset1');
			model.result('pg2').feature.create('surf1', 'Surface');
			model.result('pg2').feature('surf1').set('expr', {'log(ec.sigmaxx)'});
			model.result('pg2').name('Electric Conductivity (ec)');
			
			model.result('pg1').run;
			model.result('pg2').run;
		 }
	 }
	 
	 public static void myfun_comsol_create_boundary_selection(model) {
		double selbox1Xgnd = 0;
		double selbox2Xgnd = dimentsionX;
		double selbox1Ygnd = dimentsionY;
		double selbox2Ygnd = dimentsionY;
		
		indBoundary.Gnd = mphselectbox(model, 'geom1', [selbox1Xgnd,selbox2Xgnd; selbox1Ygnd, selbox2Ygnd], 'boundary','adjnumber',1);
		// what is this 
		
		if (ACMode == 1) {
			double selbox1Xtmnl = 0;
			double selbox2Xtmnl = dimentsionX;
			double selbox1Ytmnl = 0;
			double selbox2Ytmnl = 0;
			
			indBoundary.tmnl = mphselectbox(model, 'geom1', [selbox1Xtmnl,selbox2Xtmnl; selbox1Ytmnl, selbox2Ytmnl], 'boundary','adjnumber',1);
			// what is this?
			
		}
		
		double[] selboxpbc11 = double[2];
		selboxpbc11[0] = 0;
		selboxpbc11[1] = 0;
		double[] selboxpbc12 = double[2];
		selboxpbc12[0] = 0;
		selboxpbc12[1] = dimentsionY;
		double[] selboxpbc21 = double[2];
		selboxpbc21[0] = dimentsionX;
		selboxpbc21[1] = 0;
		double[] selboxpbc22 = double[2];
		selboxpbc22[0] = dimentsionX;
		selboxpbc22[1] = dimentsionY;
		
		indBoundary.pbc1 = mphselectbox(model, 'geom1', [selboxpbc11(1),selboxpbc12(1); selboxpbc11(2),selboxpbc12(2)], 'boundary','adjnumber',1);
		indBoundary.pbc2 = mphselectbox(model, 'geom1', [selboxpbc21(1),selboxpbc22(1); selboxpbc21(2),selboxpbc22(2)], 'boundary','adjnumber',1);

		
		
		if (ACMode == 0) {
			double SmallNum = 1e-7;
			double selbox1Xe = electrode1X - SmallNum;
			double selbox2Xe = electrode3X + SmallNum;
			double selbox1Ye = electrode1Y - SmallNum;
			double selbox2Ye = electrode2Y + SmallNum;
		}
		
		System.out.println('Found all boundary indices.');
	}
	
	public static void myfun_comsol_create_material(model, ACbreakdown) {
		model.material.create('mat1');
		model.material('mat1').selection.named('geom1_UnionFiller_dom');
		model.material('mat1').propertyGroup('def').set('electricconductivity', FillerConductivity);
		model.material('mat1').propertyGroup('def').set('relpermittivity',FillerRelPerm);
		
		if (ACMode == 1) {
			model.material.create('mat2'); 
			model.material('mat2').selection.named('geom1_DiffMatrix_dom');
			model.material.create('mat4'); 
			model.material('mat4').selection.named('geom1_DiffInterface1_dom');
			model.material.create('mat5');
			model.material('mat5').selection.named('geom1_DiffInterface2_dom');
			
			if (ACbreakdown == 1) {
				model.material('mat4').propertyGroup('def').set('relpermittivity', {'ep-j*epp-3.9*MyBoola'});
				model.material('mat2').propertyGroup('def').set('relpermittivity', {'ep-j*epp-MyBoolint*3.9'}); 
				model.material('mat5').propertyGroup('def').set('relpermittivity', {'ep-j*epp-3.9*MyBoola'});
				model.material('mat2').propertyGroup('def').set('electricconductivity', 'MyBoola*1e2+1e-4');
				model.material('mat4').propertyGroup('def').set('electricconductivity', 'MyBoolint*1e2+1e-4'); 
				model.material('mat5').propertyGroup('def').set('electricconductivity', 'MyBoolint*1e2+1e-4');  
			} else {
				model.material('mat2').propertyGroup('def').set('relpermittivity', {'ep-j*epp'});
				model.material('mat2').propertyGroup('def').set('electricconductivity', MatrixConductivity);            
				strInterfacePerm = [num2str(InterfaceRelPerm),'-j*', num2str(InterfaceImagPerm)];
				model.material('mat4').propertyGroup('def').set('relpermittivity', strInterfacePerm);   
				model.material('mat4').propertyGroup('def').set('electricconductivity', InterfaceConductivity);                       
				model.material('mat5').propertyGroup('def').set('relpermittivity', {'epint-j*eppint'});
				model.material('mat5').propertyGroup('def').set('electricconductivity', MatrixConductivity);    
			}
		} else {
			model.material.create('mat2');
			model.material('mat2').selection.named('geom1_DiffMatrix_dom');
			model.material('mat2').propertyGroup('def').set('electricconductivity', {'MyBoola*1e2+1e-4'});
			model.material('mat2').propertyGroup('def').set('relpermittivity', {'5-3.9*MyBoola'});
		
			model.material.create('mat3');
			model.material('mat3').selection.named('geom1_poly1_dom');
			model.material('mat3').propertyGroup('def').set('electricconductivity', ElectrodeConductivity);
			model.material('mat3').propertyGroup('def').set('relpermittivity',ElectrodeRelPerm);
		
			model.material.create('mat4');
			model.material('mat4').selection.named('geom1_DiffInterface1_dom');
			model.material('mat4').propertyGroup('def').set('electricconductivity', {'MyBoolint*1e2+1e-4'});
			model.material('mat4').propertyGroup('def').set('relpermittivity', {'5-MyBoolint*3.9'});
			model.material.create('mat5');
			model.material('mat5').selection.named('geom1_DiffInterface2_dom');
			model.material('mat5').propertyGroup('def').set('electricconductivity', {'MyBoolint*1e2+1e-4'});
			model.material('mat5').propertyGroup('def').set('relpermittivity', {'5-MyBoolint*3.9'});
		}

		System.out.println('Created material.');
	}
	
	public static void myfun_comsol_create_mesh(model, object ind2) {
		model.mesh.create('mesh1', 'geom1');
		
		if (ManualMesh) {
			double hmax = 0.08;
			double hmin = 0.01;
			double hgrad = 1.5;
			double hcurve = 5;
			double hnarrow = 0.2;
			
			if (ACMode == 1) {
			} else {
				model.mesh('mesh1').feature.create('dis1', 'Distribution');
				model.mesh('mesh1').feature.move('dis1', 1);
				model.mesh('mesh1').feature('dis1').selection.set(ind2.Electrode);
				model.mesh('mesh1').feature('dis1').set('numelem', '5');
			}
			model.mesh('mesh1').automatic(false);      
			model.mesh('mesh1').feature('size').set('custom', 'on');   
			model.mesh('mesh1').feature('size').set('hmax', hmax);
			model.mesh('mesh1').feature('size').set('hmin', hmin);
			model.mesh('mesh1').feature('size').set('hgrad', hgrad);
			model.mesh('mesh1').feature('size').set('hcurve', hcurve);
			model.mesh('mesh1').feature('size').set('hnarrow', hnarrow);
		} else {
			model.mesh('mesh1').autoMeshSize(MeshLevel); 
		}
		model.mesh('mesh1').run;
		System.out.println('Finished meshing.');
	}
	
	public static void myfun_comsol_create_model(model) {
		if (ACMode == 1) {
			System.out.println('AC mode: define polymer and interphase dielectric permittivity.');
			model.variable('var1').set('ep',epmodel.ep);
			model.variable('var1').set('epp',epmodel.epp);
			model.variable('var1').set('epint',epmodel.epint);
			model.variable('var1').set('eppint',epmodel.eppint);			
		} else {
			System.out.println('DC mode: No permittivity variable is defined. Instead, define Weibull random breakdown process.'));
			model.func.create('rn1','Random');
			model.func('rn1').model('mod1');
			model.func('rn1').set('nargs','3'); % number of arguments for Random Function
			model.func('rn1').set('mean','0.45');
			model.func('rn1').set('uniformrange','0.75');
			
			double ThrshdNum = 1e-6;
			String str_MyPosU = String.format("if(u>%d,u,0)", ThrshdNum);         
			String str_MyConSwitch = String.format("flc2hs(MyWeibullP-MyRan,%d)", ThrshdNum);
			String str_MyBoola = String.format("if(MyPosU>%d,1,0)", ThrshdNum);
			String str_MyPosU2 = String.format("if(u2>%d,u2,0)", ThrshdNum);
			
			model.variable('var1').set('MyRan','rn1(floor(x/0.001[m]),0.75+floor(y/0.001[m]),floor(t/1[s]))');
			model.variable('var1').set('MyWeibullP','1-exp(-ec.normE/350[V/m])');
			model.variable('var1').set('MySwitch','if(MyRan>MyWeibullP,0,1)');
			model.variable('var1').set('MyConSwitch',str_MyConSwitch);
			model.variable('var1').set('MyPosU',str_MyPosU);
			model.variable('var1').set('MyBool','flc2hs(MyPosU,1e-20)');
			model.variable('var1').set('MyBoola',str_MyBoola);
			model.variable('var1').set('MyPosU2',str_MyPosU2);
			model.variable('var1').set('MyBoolint','if((MyPosU2*0.5-3)>1,1,0)');
			
		}
	}
	
	public static void myfun_comsol_create_physics(model, object ind2) {
		model.physics.create('ec', 'ConductiveMedia', 'geom1');
		
		if (ACMode == 1) {
			model.physics('ec').feature('init1').set('V', 1, InitialVoltage);
			
			model.physics('ec').feature.create('pc1', 'PeriodicCondition', 1);
			double[] Bdryindpbc = doiuble[2];
			Bdryindpbc[0] = (double) ind2.pbc1;
			Bdryindpbc[1] = (double) ind2.pbc2;
			model.physics('ec').feature('pc1').selection.set(Bdryindpbc);
			
			model.physics('ec').feature.create('gnd1', 'Ground', 1);
			model.physics('ec').feature('gnd1').selection.set(ind2.Gnd);
			
			model.physics('ec').feature.create('term1', 'Terminal', 1);
			model.physics('ec').feature('term1').selection.set(ind2.tmnl);
			model.physics('ec').feature('term1').set('TerminalType', 1, 'Voltage');
			model.physics('ec').feature('term1').set('V0', 1, AppliedVoltage);
			
			System.out.println("created EC physics");
		} else if (ACMode == 0) {
			model.physics('ec').feature('init1').set('V', 1, InitialVoltage);
			model.physics('ec').feature.create('cs1', 'CurrentSource', 2);
			
			model.physics('ec').feature('cs1').set('Qj', 1, CurrentSource);
			model.physics('ec').feature.create('pc1', 'PeriodicCondition', 1);
			double[] Bdryindpbc = doiuble[2];
			Bdryindpbc[0] = (double) ind2.pbc1;
			Bdryindpbc[1] = (double) ind2.pbc2;
			model.physics('ec').feature('pc1').selection.set(Bdryindpbc);
			model.physics('ec').feature.create('pot1', 'ElectricPotential', 1);
			
			model.physics('ec').feature.create('gnd1', 'Ground', 1);
			model.physics('ec').feature('gnd1').selection.set(ind2.Gnd);
			model.physics('ec').feature.create('init2', 'init', 2);
			
			model.physics('ec').feature('init2').set('V', 1, AppliedVoltage);
			
			System.out.println("created EC physics");
		}
		
		model.physics.create('dode1', 'DomainODE', 'geom1', {'u'});
		model.physics('dode1').selection.named('geom1_UnionDomODE_dom');
		model.physics('dode1').feature('dode1').set('f', 1, 'MySwitch');
		model.physics.create('dode2', 'DomainODE', 'geom1', {'u2'});
		model.physics('dode2').selection.named('geom1_UnionDomODE_dom');
		model.physics('dode2').feature('dode1').set('f', 1, 'MyBoola');
		model.physics.create('dode3', 'DomainODE', 'geom1', {'u3'});
		model.physics('dode3').selection.named('geom1_UnionDomODE_dom');
		model.physics('dode3').feature('dode1').set('f', 1, 'sqrt(ec.normE*ec.normE)/1[V*m]');

		System.out.println("created DODE physics");
	}
	
	public static void myfun_comsol_create_shifting_factors(model, double[] x) {
		String str_TauShift1 = Double.toString(x[0]);
		String str_DeltaEpsilonShift1      = Double.toString(x[1]);
		String str_TauShift2               = Double.toString(x[2]);
		String str_DeltaEpsilonShift2      = Double.toString(x[3]);
		String str_ConstantC               = Double.toString(x[4]);
		model.variable('var1').set('TS1',str_TauShift1); 
		model.variable('var1').set('DS1',str_DeltaEpsilonShift1);
		model.variable('var1').set('TS2',str_TauShift2); 
		model.variable('var1').set('DS2',str_DeltaEpsilonShift2);
		model.variable('var1').set('const',str_ConstantC);
	}
	
	public static void myfun_comsol_create_structure(model) {
		System.out.println("Use 1-to-1 mapping of filler microstructure ...");
		String[] FeatureName = new String[NewClusterNo];
		String[] FeatureName1 = new String[NewClusterNo];
		String[] FeatureName2 = new String[NewClusterNo];
		
		for (int i = 0; i < NewClusterNo; i++) {
			FeatureName[i] = "Ellipse"+Integer.toString(i);
			model.geom('geom1').feature().create(FeatureName[i],'Ellipse');
			model.geom('geom1').feature(FeatureName[i]).set('pos',[EllipseMatrix[i][4], EllipseMatrix[i][5]]);
			model.geom('geom1').feature(FeatureName[i]).set('semiaxes',[EllipseMatrix[i][2], EllipseMatrix[i][3]]);
			model.geom('geom1').feature(FeatureName[i]).set('rot', EllipseMatrix[i][1]);
			model.geom('geom1').feature(FeatureName[i]).set('createselection','on');
			System.out.println('Ellipse'+Integer.toString(i));
		}
		model.geom('geom1').runAll;
		model.geom('geom1').feature.create('UnionFiller', 'Union');
		model.geom('geom1').feature('UnionFiller').selection('input').set(FeatureName);
		model.geom('geom1').feature('UnionFiller').set('createselection', 'on');
		model.geom('geom1').feature('UnionFiller').set('intbnd', 'off');
		model.geom('geom1').runAll;
		
		for (int i = 0; i < NewClusterNo; i ++) {
			FeatureName1[i] = "EllipseIF1"+Integer.toString(i);
			model.geom('geom1').feature().create(FeatureName1[i],'Ellipse');
			model.geom('geom1').feature(FeatureName1[i]).set('pos',[EllipseMatrix[i][4], EllipseMatrix[i][5]]);
			model.geom('geom1').feature(FeatureName1[i]).set('semiaxes',[EllipseMatrix[i][2]+InterfaceThickness1, EllipseMatrix[i][3]+InterfaceThickness1]);
			model.geom('geom1').feature(FeatureName1[i]).set('rot', EllipseMatrix[i][1]);
			model.geom('geom1').feature(FeatureName1[i]).set('createselection','on');
			System.out.println('EllipseIF1-'+Integer.toString(i));
		}
		model.geom('geom1').runAll;
		model.geom('geom1').feature.create('UnionLargeEllipse1', 'Union');
		model.geom('geom1').feature('UnionLargeEllipse1').selection('input').set(FeatureName1);
		model.geom('geom1').feature('UnionLargeEllipse1').set('createselection', 'on');
		model.geom('geom1').feature('UnionLargeEllipse1').set('intbnd', 'off');
		model.geom('geom1').runAll;

		model.geom('geom1').feature.create('DiffInterface1', 'Difference');
		model.geom('geom1').feature('DiffInterface1').selection('input').set('UnionLargeEllipse1');
		model.geom('geom1').feature('DiffInterface1').selection('input2').set('UnionFiller');
		model.geom('geom1').feature('DiffInterface1').set('keep', 'on');
		model.geom('geom1').feature('DiffInterface1').set('createselection', 'on');
		model.geom('geom1').feature('DiffInterface1').set('intbnd', 'off');
		model.geom('geom1').runAll;
		
		for (int i = 1; i <= NewClusterNo; i++) {
			FeatureName2[i] = "EllipseIF2"+Integer.toString(i);
			model.geom('geom1').feature().create(FeatureName2[i],'Ellipse');
			model.geom('geom1').feature(FeatureName2[i]).set('pos',[EllipseMatrix[i][4], EllipseMatrix[i][5]]);
			model.geom('geom1').feature(FeatureName2[i]).set('semiaxes',[EllipseMatrix[i][2]+InterfaceThickness2, EllipseMatrix[i][3]+InterfaceThickness1+InterfaceThickness2]);
			model.geom('geom1').feature(FeatureName2[i]).set('rot', EllipseMatrix[i][1]);
			model.geom('geom1').feature(FeatureName2[i]).set('createselection','on');
			System.out.println('EllipseIF2-'+Integer.toString(i));
		}
		
		model.geom('geom1').runAll;
		model.geom('geom1').feature.create('UnionLargeEllipse2', 'Union');
		model.geom('geom1').feature('UnionLargeEllipse2').selection('input').set(FeatureName2);
		model.geom('geom1').feature('UnionLargeEllipse2').set('createselection', 'on');
		model.geom('geom1').feature('UnionLargeEllipse2').set('intbnd', 'off');
		model.geom('geom1').runAll;
		
		model.geom('geom1').feature.create('DiffInterface2', 'Difference');
		model.geom('geom1').feature('DiffInterface2').selection('input').set('UnionLargeEllipse2');
		model.geom('geom1').feature('DiffInterface2').selection('input2').set('UnionLargeEllipse1');
		model.geom('geom1').feature('DiffInterface2').set('keep', 'on');
		model.geom('geom1').feature('DiffInterface2').set('createselection', 'on');
		model.geom('geom1').feature('DiffInterface2').set('intbnd', 'off');
		model.geom('geom1').runAll;
		
		model.geom('geom1').feature.create('RectBlock', 'Rectangle');
		model.geom('geom1').feature('RectBlock').set('size', [dimensionX, dimensionY]);
		model.geom('geom1').feature('RectBlock').set('createselection', 'on');
		model.geom('geom1').run('RectBlock');

		model.geom('geom1').feature.create('DiffMatrix', 'Difference');
		model.geom('geom1').feature('DiffMatrix').selection('input').set('RectBlock');
		model.geom('geom1').feature('DiffMatrix').selection('input2').set('UnionLargeEllipse2');
		model.geom('geom1').feature('DiffMatrix').set('keep', 'on');
		model.geom('geom1').feature('DiffMatrix').set('createselection', 'on');
		model.geom('geom1').runAll;
		
		model.geom('geom1').feature.create('UnionDomODE', 'Union');
		model.geom('geom1').feature('UnionDomODE').selection('input').set({'DiffInterface1' 'DiffInterface2' 'DiffMatrix'});
		model.geom('geom1').feature('UnionDomODE').set('keep', 'on');
		model.geom('geom1').feature('UnionDomODE').set('createselection', 'on');
		model.geom('geom1').runAll;
		

		System.out.println('Finished building unions and differences on fillers, interphase, and rectangular simulation block');
		
		if (ACMode == 0) {
			electrode1X = dimensionX*rt_electrode1X;
			electrode2X = dimensionX*rt_electrode2X;
			electrode3X = dimensionX*rt_electrode3X;
			electrode1Y = dimensionY*rt_electrode1Y;
			electrode2Y = dimensionY*rt_electrode2Y;
			electrode3Y = dimensionY*rt_electrode3Y;
			
			model.geom('geom1').feature.create('poly1','Polygon');
			model.geom('geom1').feature('poly1').set('x',[electrode1X,electrode2X,electrode3X]);
			model.geom('geom1').feature('poly1').set('y',[electrode1Y,electrode2Y,electrode3Y]);
			model.geom('geom1').feature('poly1').set('createselection','on');
			model.geom('geom1').runAll;
			model.geom('geom1').feature.create('fil1','Fillet');
			model.geom('geom1').feature('fil1').selection('point').set('poly1',2);
			model.geom('geom1').feature('fil1').set('radius',0.00002);
			model.geom('geom1').feature('fil1').set('createselection','on');
			model.geom('geom1').runAll;

			
			System.out.println('Finished building electrode.');
		}
	}
	
	public static void myfun_comsol_create_solution(model) {
		if (ACMode == 1) {
			model.sol.create('sol1');
			model.sol('sol1').study('std1');
			model.sol('sol1').feature.create('st1', 'StudyStep');
			model.sol('sol1').feature('st1').set('study', 'std1');
			model.sol('sol1').feature('st1').set('studystep', 'freq');
			model.sol('sol1').feature.create('v1', 'Variables');
			model.sol('sol1').feature.create('s1', 'Stationary');
			model.sol('sol1').feature('s1').feature.create('p1', 'Parametric');
			model.sol('sol1').feature('s1').feature.remove('pDef');
			model.sol('sol1').feature('s1').feature('p1').set('pname', 'freq');
			model.sol('sol1').feature('s1').feature('p1').set('plist', FreqRange);
			model.sol('sol1').feature('s1').feature('p1').set('plot', 'off');
			model.sol('sol1').feature('s1').feature('p1').set('probesel', 'all');
			model.sol('sol1').feature('s1').feature('p1').set('probes', {});
			model.sol('sol1').feature('s1').feature('p1').set('control', 'freq');
			model.sol('sol1').feature('s1').set('control', 'freq');
			model.sol('sol1').feature('s1').feature.create('fc1', 'FullyCoupled');
			model.sol('sol1').feature('s1').feature.remove('fcDef');
			model.sol('sol1').attach('std1');
			model.sol('sol1').runAll;
			
			if (ACbreakdown == 1) {
				model.sol.create('sol2');
				model.sol('sol2').study('std2');
				model.sol('sol2').feature.create('st2', 'StudyStep');
				model.sol('sol2').feature('st2').set('study', 'std2');
				model.sol('sol2').feature('st2').set('studystep', 'time');
				model.sol('sol2').feature.create('v1', 'Variables');
				model.sol('sol2').feature.create('t1', 'Time');
				model.sol('sol2').feature('t1').set('tlist', TimeRange);
				model.sol('sol2').feature('t1').set('plot', 'off');
				model.sol('sol2').feature('t1').set('plotfreq', 'tout');
				model.sol('sol2').feature('t1').set('probesel', 'all');
				model.sol('sol2').feature('t1').set('probes', {});
				model.sol('sol2').feature('t1').set('probefreq', 'tsteps');
				model.sol('sol2').feature('t1').set('control', 'time');
				model.sol('sol2').feature('t1').feature.create('fc1', 'FullyCoupled');
				model.sol('sol2').feature('t1').feature.remove('fcDef');
				model.sol('sol2').attach('std2');
				model.sol('sol2').runAll;
			}
		} else {
			model.sol.create('sol1');
			model.sol('sol1').study('std1');
			model.sol('sol1').feature.create('st1', 'StudyStep');
			model.sol('sol1').feature('st1').set('study', 'std1');
			model.sol('sol1').feature('st1').set('studystep', 'time');
			model.sol('sol1').feature.create('v1', 'Variables');
			model.sol('sol1').feature.create('t1', 'Time');
			model.sol('sol1').feature('t1').set('tlist', TimeRange);
			model.sol('sol1').feature('t1').set('plot', 'off');
			model.sol('sol1').feature('t1').set('plotfreq', 'tout');
			model.sol('sol1').feature('t1').set('probesel', 'all');
			model.sol('sol1').feature('t1').set('probes', {});
			model.sol('sol1').feature('t1').set('probefreq', 'tsteps');
			model.sol('sol1').feature('t1').set('control', 'time');
			model.sol('sol1').feature('t1').feature.create('fc1', 'FullyCoupled');
			model.sol('sol1').feature('t1').feature.remove('fcDef');
			model.sol('sol1').attach('std1');
			model.sol('sol1').runAll;
		}
		
		System.out.println('Finished computing solution.');
	}
	
	public static void myfun_comsol_create_study(model, ACbreakdown) {
		if (ACbreakdown == 1) {
			model.study.create('std1');
			model.study('std1').feature.create('freq', 'Frequency');
			model.study('std1').feature('freq').set('geomselection', 'geom1');
			model.study('std1').feature('freq').set('physselection', 'ec');
			model.study('std1').feature('freq').set('plist', FreqRange);
			
			if (ACbreakdown == 1) {
				model.study.create('std2');
				model.study('std2').feature.create('time', 'Transient');
				model.study('std2').feature('time').set('geomselection', 'geom1');
				model.study('std2').feature('time').set('physselection', 'dode3');
				model.study('std2').feature('time').set('probefreq', 'tout');
				model.study('std2').feature('time').set('tlist', TimeRange);
			}
		} else {
			model.study.create('std1');
			model.study('std1').feature.create('time', 'Transient');
			model.study('std1').feature('time').set('geomselection', 'geom1');
			model.study('std1').feature('time').set('physselection', 'dode3');
			model.study('std1').feature('time').set('probefreq', 'tout');
			model.study('std1').feature('time').set('tlist', TimeRange);
		}
		System.out.println('created study.');
	}
	
	public static void myfun_comsol_load_constant() {
		if (ACMode == 1) {
		} else {
			rt_electrode1X = 0.125/0.3;
			rt_electrode1Y = 0;
			rt_electrode2X = 0.15/0.3;
			rt_electrode2Y = 0.03/0.15;
			rt_electrode3X = 0;
			rt_electrode3Y = 0;
		}
		
		AppliedVoltage = 1.5e-3;
		InitialVoltage = 0.01e-3;
		MatrixConductivity = 1e-15;
		CurrentSource = 2e3;
		FillerConductivity = MatrixConductivity;
		FillerRelPerm = 3.9;
		InterfaceRelPerm = 2.4;
		InterfaceImagPerm = 0.001;
		InterfaceConductivity = 1e-11;
		ElectrodeRelPerm = 2;
		ElectrodeConductivity = 1e6;
		FreqRange = 10.0^(-3:0.2:6); // what is this?
		TimeRange = 'range(0,0.25,20)';
	}
}