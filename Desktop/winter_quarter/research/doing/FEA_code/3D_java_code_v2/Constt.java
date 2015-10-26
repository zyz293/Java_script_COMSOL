public class Constt {
	public double TauShift1;
	public double DeltaEpsilonShift1;
	public double TauShift2;
	public double DeltaEpsilonShift2;
	public double ConstEpsilonShift;
	public double dimension_to_pixel;
	public double L;
	public double vf;
	public double tau;
	
	Constt(double a, double b, double c, double d, double e, double f, double g, double h, double i) {
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