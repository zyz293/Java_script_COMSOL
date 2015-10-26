public class Const {
	private double TauShift1;
	private double DeltaEpsilonShift1;
	private double TauShift2;
	private double DeltaEpsilonShift2;
	private ConstEpsilonShift;
	private double dimension_to_pixel;
	
	public Const(double a, double b, double c, double d, double e, double f) {
		TauShift1 = a;
		DeltaEpsilonShift1 = b;
		TauShift2 = c;
		DeltaEpsilonShift2 = d;
		ConstEpsilonShift = e;
		dimension_to_pixel = f;
	}
}