import com.jmatio.io.*;
import com.jmatio.types.*;


public class code {
	
	private double vf_expt;
	private double ACMode;
	private double CheckOverlap;
	private String ControlMode;
	private double GBbr; 
	private double GBbs;
	private double DomLength; 
	private double ActualLength;
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
	private double epmodel; // what object type, which file define it?
	private boolean isEpsDIstribution;
	private double isReScale;
	private double isGetSolution;
	private double ACbreakdown;
	private double ManualMesh;
	private double MeshLevel;
	
	
	public static void main(String[] args) {
		const arg = new const(1, 1, 1, 1, 0, 500/523);
		new code().MAIN(args[0], args[1], arg);
	} 
	
	public void MAIN(double TrialNo, String binsource, object const) { // type of this three
		vf_expt = 0.01;
		DomLength = 1000;
		ImageType = 'binary';
		ControlMode = 'linux';
		dimension_to_pixel = (double) const.dimension_to_pixel;
		CutSide = 0.1;
		
		double IP1 = 10;
		double IP2 = 50;
		InterfaceThickness1 = IP1 * 1e-6;
		InterfaceThickness2 = IP2 * 1e-6;
		InterfaceThickness = InterfaceThickness2 + InterfaceThickness1;
		
		isReScale = 1;
		isGetSolution = 1;
		isEpsDIstribution = 1;
		ACMode = 1;
		ACbreakdown = 0;
		CheckOverlap = 0;
		ManualMesh = 0;
		MeshLevel = 5;
/********************************************************/
		InterfaceThickness = InterfaceThickness1 + InterfaceThickness2;
		if (isEpsDIstribution == 0) {
			epmodel.ep = 2; // epmodel contains ep and epp, not a int
		    epmodel.epp = 1e-3;
			
			double epintShift = 0;
			epmodel.epint = epmodel.ep + epintShift;
			double eppintShift = 0;
			epmodel.eppint = epmodel.epp + eppintShift;
		}
/********************************************************/

		String strMode;
		if (ACMode == 1) {
			strMode = 'AC';
		} else if ( ACMode == 0) {
			strMode = 'DC';
		}
		

		GBbr = 25;
		GBbs = 10;
/*******************************************************/
		// load(binsource); // type of this file, how to load
		MatFileReader matfile = new MatFileReader(binsource);
		double[][] image = ((MLDouble) matfile.getMLArray("data")).getArray();
		// String image = img_out; // what is this?
		ActualLength = image.length();
/*******************************************************/	
		DomLength = 1000;
		String savefile = './HZ_2D_comsolbuild_'+strMode+'_'+ImageType+'_'+date+'_IP'+Integer.toString(IP1)+'+'+Integer.toString(IP2)+'_run'+Integer.toString(TriaNo);
		String PScoeff = './RoomTempEposyNew.mat';
		
		String imagefile; // type of this variable
		if (ImageType == 'binary') {
			System.out.prinln('Take input from binary image.');
			imagefile = binsource;
		} else if (ImageType == 'recon') {
			imagefile = 'img_para_'+binsource+'_Trial'+Float.toString(TriaNo)+'.mat';
			System.out.println('Take input from reconstructed microstructure.');
		}
		
		TauShift1 = const.TauShift1;
		DeltaEpsilonShift1 = const.DeltaEpsilonShift1;
		TauShift2 = const.TauShift2;
		DeltaEpsilonShift2 = const.DeltaEpsilonShift2;
		ConstEpsilonShift = const.ConstEpsilonShift;
		
		String savefile = './HZ_2D_comsolbuild_'+strACMode+'_'+ImageType+'_'+date+'_IP'+Float.toString(IP1)+'+'+Float.toString(IP2)+'_run_'+Float.toString(TrialNo);
		myfun_comsol_build model = new myfun_comsol_build(PScoeff, imagefile, savefile);
		
		System.out.println('Job done. Output result to .mph file');
		
		mphsave(model, savefile); // what is this?
		
	 }
	 
	 
	 
}