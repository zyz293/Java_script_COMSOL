public class myfun_comsol_create_boundary_selection {
	private float dimentsionX;
	private float dimentsionY;
	private float electrode1X;
	private float electrode3X;
	private float electrode1Y;
	private float electrode3Y;
	private int ACMode;
	
	
	public model myfun_comsol_create_boundary_selection(model) {
		float selbox1Xgnd = 0;
		float selbox2Xgnd = dimentsionX;
		float selbox1Ygnd = dimentsionY;
		float selbox2Ygnd = dimentsionY;
		
		
		
		if (ACMode == 1) {
			float selbox1Xtmnl = 0;
			float selbox2Xtmnl = dimentsionX;
			float selbox1Ytmnl = 0;
			float selbox2Ytmnl = 0;
			
			
			
		}
		
		float[] selboxpbc11 = float[2];
		selboxpbc11[0] = 0;
		selboxpbc11[1] = 0;
		float[] selboxpbc12 = float[2];
		selboxpbc12[0] = 0;
		selboxpbc12[1] = dimentsionY;
		float[] selboxpbc21 = float[2];
		selboxpbc21[0] = dimentsionX;
		selboxpbc21[1] = 0;
		float[] selboxpbc22 = float[2];
		selboxpbc22[0] = dimentsionX;
		selboxpbc22[1] = dimentsionY;
		
		
		
		
		if (ACMode == 0) {
			float SmallNum = 1e-7;
			float selbox1Xe = electrode1X - SmallNum;
			float selbox2Xe = electrode3X + SmallNum;
			float selbox1Ye = electrode1Y - SmallNum;
			float selbox2Ye = electrode2Y + SmallNum;
		}
		
		System.out.println('Found all boundary indices.');
	}
}