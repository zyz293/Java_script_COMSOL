public class myfun_comsol_create_structure {
	private float InterfaceThickness1;
	private float InterfaceThickness2;
	private float dimensionX;
	private float dimensionY;
	private float EllipseMatrix;
	private float NewClusterNo;
	private float rt_electrode1X;
	private float rt_electrode2X;
	private float rt_electrode3X;
	private float rt_electrode1Y;
	private float rt_electrode2Y;
	private float rt_electrode3Y;
	private int ACMode;
	
	public model myfun_comsol_create_structure(model) {
		System.out.println('Create filler miscrostructure ...');
		
		
		
		
		
		
		for (int i = 1; i <= NewClusterNo; i++) {
			
			
			
			
			
			
			System.out.println('Ellipse'+Integer.toString(i));
		}
		
		
		
		
		for (int i = 1; i <= NewClusterNo; i ++) {
			
			
			
			
			
			
			System.out.println('EllipseIF1-'+Integer.toString(i));
		}
		
		
		
		
		
		
		for (int i = 1; i <= NewClusterNo; i++) {
			
			
			
			
			System.out.println('EllipseIF2-'+Integer.toString(i));
		}
		
		
		
		
		
		
		
		System.out.println('Finished building unions and differences on fillers, interphase, and rectangular simulation block');
		
		if (ACMode == 0) {
			float electrode1X = dimensionX*rt_electrode1X;
			float electrode2X = dimensionX*rt_electrode2X;
			float electrode3X = dimensionX*rt_electrode3X;
			float electrode1Y = dimensionY*rt_electrode1Y;
			float electrode2Y = dimensionY*rt_electrode2Y;
			float electrode3Y = dimensionY*rt_electrode3Y;
			
			
			
			
			
			
			
			
			System.out.println('Finished building electrode.');
		}
	}
}