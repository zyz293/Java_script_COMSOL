public class myfun_comsol_load_constant {
	private float rt_electrode1X;
	private float rt_electrode2X;
	private float rt_electrode3X;
	private float rt_electrode1Y;
	private float rt_electrode2Y;
	private float rt_electrode3Y;
	private float AppliedVoltage;
	private float InitialVoltage;
	private float MatrixConductivity;
	private float InterfaceConductivity;
	private float InterfaceRelPerm;
	private float InterfaceImagPerm;
	private float CurrentSource;
	private float FillerConductivity;
	private float FillerRelPerm;
	private float floaterfaceRelPerm;
	private float floaterfaceImagPerm;
	private float ElectrodeConductivity;
	private float ElectrodeRelPerm;
	private float FreqRange;
	private String TimeRange;
	private int ACMode;
	private int Compfreq;
	
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