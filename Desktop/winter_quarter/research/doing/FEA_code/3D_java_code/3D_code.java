import com.comsol.model.*;
import com.comsol.model.util.*;

import com.jmatio.io.*;
import com.jmatio.types.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class 3D_code {
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
	private Epmodel epmodel; // what object type, which file define it?
	private boolean isEpsDIstribution;
	private double isReScale;
	private double isGetSolution;
	private double ACbreakdown;
	private double ManualMesh;
	private double MeshLevel;
	private double ControlMode;
	private double tau0;
	
	public static void main(String[] args) {
		Const const = new Const(600, 1/100, 1, 1, 1, 1, 0, 0.05, 400/240);
		new code().MAIN(1,  './sample_binary_input_3D_parameter_output', const);
	} 
	
	public void MAIN(double TrialNo, String binsource, object const) {
		ImageType = "recon";
		ControlMode = "linux";
		dimension_to_pixel = (double) const.dimension_to_pixel;
		CutSide = 0.1;
		double IP1 = 5;
		double IP2 = 10;
		InterfaceThickness1 = IP1 * 1e-6;
		InterfaceThickness2 = IP2 * 1e-6;
		
		isReScale = 0;
		isGetSolution = 1;
		isEpsDIstribution = 1;
		ACMode = 1;
		ACbreakdown = 0;
		CheckOverlap = 0;
		ManualMesh = 0;
		MeshLevel = 5;
		
		InterfaceThickness = InterfaceThickness1 + InterfaceThickness2;
		if (isEpsDIstribution == 0) {
			epmodel.ep = 2; // epmodel contains ep and epp, not a int
		    epmodel.epp = 1e-3;
			
			double epintShift = 0;
			epmodel.epint = epmodel.ep + epintShift;
			double eppintShift = 0;
			epmodel.eppint = epmodel.epp + eppintShift;
		}
		
		String strMode;
		if (ACMode == 1) {
			strMode = 'AC';
		} else if ( ACMode == 0) {
			strMode = 'DC';
		}
		
		DomLength = const.L;
		vf_expt                              = const.vf;                        
		TauShift1                            = const.TauShift1;  				
		DeltaEpsilonShift1                   = const.DeltaEpsilonShift1 ;       
		TauShift2                            = const.TauShift2;                
		DeltaEpsilonShift2                   = const.DeltaEpsilonShift2;       
		ConstEpsilonShift                    = const.ConstEpsilonShift;
		tau0                                 = const.tau;

		String PScoeff = "./RoomTempEpoxyYHNew.mat";
		
		DateFormat dataFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String savefile = './HZ_3D_comsolbuild_'+strACMode+'_'+ImageType+'_'+dateFormat.format(date)+'_IP'+Double.toString(IP1)+'+'+Double.toString(IP2)+'_run_'+Double.toString(TrialNo)
		
		myfun_comsol_build model = new myfun_comsol_build(PScoeff, imagefile, savefile);

		System.out.println('Job done. Output result to .mph file');
		
		mphsave(model, savefile); // what is this?
	}
}