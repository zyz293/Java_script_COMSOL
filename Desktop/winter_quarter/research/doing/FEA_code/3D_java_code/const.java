public class Const {
	private double TauShift1;
	private double DeltaEpsilonShift1;
	private double TauShift2;
	private double DeltaEpsilonShift2;
	private ConstEpsilonShift;
	private double dimension_to_pixel;
	private double L;
	
	public Const(double a, double b, double c, double d, double e, double f, double g, double h, double i) {
		TauShift1 = c;
		DeltaEpsilonShift1 = d;
		TauShift2 = e;
		DeltaEpsilonShift2 = f;
		ConstEpsilonShift = g;
		dimension_to_pixel = i;
		L = a;
		vf = b;
		tau = h;
	}
}