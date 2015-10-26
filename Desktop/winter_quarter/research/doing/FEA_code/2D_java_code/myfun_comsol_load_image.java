public class myfun_comsol_load_image {
	private float dimenstionX;
	private float dimenstionY;
	private float DomLength;
	private float ActualLength;
	private float Rescale;
	private float dimension_to_pixel;
	private String ImageType;
	private float sbimagefile;
	private float CutSide;
	private float EllipseMatrix;
	private float NewClusterNo;
	private float NewPosX;
	private float NewPosY;
	private float NewShortAxis;
	private float NewLongAxis;
	private float NewAngle;
	private float CheckOverlap;
	private float GBbr;
	private float GBbs;
	private float isReScale;
	
	public static void myfun_comsol_load_image(imagefile) {
		float RemainSideLength = 1-2*CutSide;
		
		if (ImageType == 'grayscale') {
			Isb = imread(sbimagefile); // what is this?
			float sbarpixellength = max(size(Isb)); // java word for this
			dimension_to_pixel = 100/sbarpixellength;
		}
		
		System.out.println('Ratio of physical length to pixel:'+Float.toString(dimension_to_pixel)+'nm-per-pixel');
		dimensionX = ActualLength*dimension_to_pixel*1e-6;
		dimenstionY = dimensionX;
		
		if (ImageType == 'grayscale') {
			int VFproceed = 1;
			while (VFproceed == 1) {
				I = imread(imagefile); // what is this?
				G = fspecial('gaussian', GBbr, GBbs); // what is this?
				Ig = imfilter(I, G, 'same'); // what is this?
				I_gray = Ig(:, :, 1); // what is this?
				
				float ImageSide = min(size(I_gray));
				
				int RemoveSideLength = 10;
				int[][] I_graysq = int[ImageSide-2*RemoveSideLength][ImageSide-2*RemoveSideLength];
				for (int i = 0; i < ImageSide-2*RemoveSideLength; i++) {
					(for int j = 0; j < ImageSide-2*RemoveSideLength; j++) {
						I_graysq[i][j] = 0;
					}
				}
				System.out.println('Side length (in pixel):'+Float.toString(ImageSide-2*RemoveSideLength));
				
				for (int i = 0; i < ImageSide-2*RemoveSideLength; i++) {
					for (int j = 0 ; j < ImageSide-2*RemoveSideLength; j++) {
						I_graysq[i][j] = I_gray[i+1+RemoveSideLength][1+j+RemoveSideLength];
					}
				}
				
				
				float NewImageSide = ImageSide-2*RemoveSideLength;
				
				
				float AreaCorrectionScale = 1;
				float VFcheck = 100;
				while () {
					if (VFcheck == 1) {
						AreaCorrectionScale = 1.5;
						System.out.println('Increase threshold VF in binarization.');
					} else if (VFcheck == 2) {
						AreaCorrectionScale = 2/3;
						System.out.println('Decrease threshold VF in binarization.');
					}
					
					float vf = AreaCorrectionScale*vf;
					float LengthCorrectionScale = sqrt(AreaCorrectionScale);
					
					
					
					
					
					
					System.out.println('VF after removing single isolated pixels:'+Float.toString(removed_single_vf));
					
					int[][] I_bright = int[image.length()][image.length()];
					for (int i = 0; i < image.length(); i++) {
						for (int j = 0; j < image.length(); j++) {
							if (image[i][j] > 0) {
								I_bright[i][j] = 0;
							} else {
								I_bright[i][j] = 1;
							}
						}
					}
					
					
					
					
					
					
					System.out.println('Now check binarization quality.');
					System.out.println('Please compare Figure 18 and Figure 19 now.');
					System.out.println('Does the binary reconstruction in Figure 19 (black fillers) correspond with dark area in grayscale image, FIgure18?');
					System.out.println('If not, should there be more or less black dots in Figure 19?');
					
					
					if (presult == 0) {
						break;
					} else if (presult == 1) {
						VFcheck = 1;
 					} else if (presult == 2) {
						VFcheck = 2;
					} else {
						System.out.println('Cannot proceed without your response! Answer 0 for good; 1 for more; 2 for less.');
					}
				}
				
				float ClusterNo = max(min(img));
				int[][] Center_list = int[ClusterNo][ClusterNo];
				int[] MajorAxis = int[ClusterNo];
				int[] MinorAxis = int[ClusterNo];
				int[] Angle = int[ClusterNo];
				
				
				
				
				
				for (int ii = 1; ii <= ClusterNo; ii ++) {
					Center_list
					
					
					
					
					
					
					int dist = 0;
					for (int j1 =1; j1 <= PixelNo; j1 ++) {
						for (int j2 = 1; j2 <= PixelNo; j2++) {
							float distnew = 
							if (distnew > dist) {
								dist = distnew;
								
							}
						}
					}
					
					
				}
				MajorAxis = LengthCorrectionScale*MajorAxis/2;
				MinorAxis = LengthCorrectionScale*MinorAxis/2;
				
				
				
				
				
				int[] x0 = int[ClusterNo];
				int[] y0 = int[ClusterNo];
				for (int i = 0; i <ClusterNo; i++) {
					x0[i] = Center_list[i][1];
					y0[i] = Center_list[i][2];
				}
				
				
				System.out.println('Original number of clusters: ', Float.toString(ClusterNo));
				
				float scaling = 0.9*dimensionX/NewImageSide;
				float LongAxis = scaling*MajorAxis;
				float ShortAxis = scaling*MinorAxis;
				float reconstrct_new_vf = 3.14*MajorAxis'*MinorAxis/lenth(image)^2;
				System.out.println('VF after characterization (before removing overlapping fillers, if any): ', Float.toString(reconstrct_new_vf));
				float PosX = 0.05*dimensionX + scaling*x0;
				float PosY = 0.05*dimensionY + scaling*y0;
				
				if (CheckOverlap) {
					float SeedingAreaBot = 0.05*dimensionX;
					float SeedingAreaTop = 0.95*dimensionX;
					float SeedingAreaLeft = 0.05*dimensionY;
					float SeedingAreaRight = 0.95*dimensionY;
					
					int[] MapGridX = int[ClusterNo];
					int[] MapGridY = int[ClusterNo];
					for (int i = 1; i <= ClusterNo; i ++) {
					


					
					}
					
					
					for (int i = 1; i <= ClusterNo; i ++) {
						if () {
							float CurrentGridX = MapGridX[i];
							float CurrentGridY = MapGridY[i];
							
							for (int xx = CurrentGridX - 1; xx <= CurrentGridX + 1; xx ++) {
								for (int yy = CurrentGridY -1 ; yy<CurrentGridY +1; yy++) {
									if (xx > 0 && xx <= 10 && yy > 0 & yy <= 10) {
										for (int k =1; k) {
											if () {
												
											}
										}
									}
								}
							}
							
							for (int j = 1; j < TempCompZMatrix.length(); j ++) {
								float Distance = sqrt(PosX(TempCompZMatrix(j))-P)
								
								if (Distance < Criterion) {
									if (LongAxis) {
										
									}
								}
							}
						}
						
						
						float TempI = 0;
						for (int i = 1; i <= ClusterNo; i ++) {
							TempI ++;
							if () {
								
								
								
							} else {
								TempI --;
							}
						}
						
						NewClusterNo = TempI;
						
						float revised_vf = 3.14*NewLongAxis*NewShortAxis'/
						System.out.println('After axes elongation, if any, revised VF to be loaded into COMSOL: ', Float.toString(revised_vf));
						float VFerror = 100*((revised_vf - vf_expt)/vf_expt);
						System.out.println('Error percentage of VF after reconstruction: ', Float.toString(VFerror)+'%');
						
						
						
						if (presult2) {
							
						}
						if (presult2 == 'y') {
							break;
						} else {
							vf = vf*(1-VFerror/100);
						}
						
						
					} else {
						break
					}
					
				}
				
				
				if (CheckOverlap == 0) {
					NewClusterNo = ClusterNo;
					NewLongAxis = 
					
					
					
				}
				
				int[][] EllipseMatrix = int[NewClusterNo][5];
				for (int i = 0; i < NewClusterNo; i ++) {
					EllipseMatrix[i][1] = NewAngle*180/3.1416;
					EllipseMatrix[i][2] = NewLongAxis;
					EllipseMatrix[i][3] = NewShortAxis;
					EllipseMatrix[i][4] = NewPosX;
					EllipseMatrix[i][5] = NewPosY; 
				}
			}
		} else if (ImageType == 'binary') {
			
			
			
			float ClusterNo = max(min(img));
			int[][] Center_list = int[ClusterNo][ClusterNo];
			int[] MajorAxis = int[ClusterNo];
			int[] MinorAxis = int[ClusterNo];
			int[] Angle = int[ClusterNo];
			
			
			
			
			
			for (int ii = 1; ii <= ClusterNo; ii ++) {
				Center_list
				
				
				
				
				
				
				int dist = 0;
				for (int j1 =1; j1 <= PixelNo; j1 ++) {
					for (int j2 = 1; j2 <= PixelNo; j2++) {
						float distnew = 
						if (distnew > dist) {
							dist = distnew;
							
						}
					}
				}
				
				
			}
			MajorAxis = MajorAxis/2;
			MinorAxis = MinorAxis/2;
			
			
			
			
			int[][] I_bright = int[image.length()][image.length()];
					for (int i = 0; i < image.length(); i++) {
						for (int j = 0; j < image.length(); j++) {
							if (image[i][j] > 0) {
								I_bright[i][j] = 0;
							} else {
								I_bright[i][j] = 1;
							}
						}
					}
					
					
					
					
					
					
					
					
			int[] x0 = int[ClusterNo];
			int[] y0 = int[ClusterNo];
			for (int i = 0; i <ClusterNo; i++) {
				x0[i] = Center_list[i][1];
				y0[i] = Center_list[i][2];
			}
			
			
			System.out.println('Original number of clusters: ', Float.toString(ClusterNo));
			
			float scaling = RemainSideLength*dimensionX/ActualLength;
			float LongAxis = scaling*MajorAxis;
			float ShortAxis = scaling*MinorAxis;
			float PosX = CutSide*dimensionX + scaling*x0;
			float PosY = CutSide*dimensionY + scaling*y0;
			
		
			
			if (CheckOverlap == 0) {
				NewClusterNo = ClusterNo;
				
				
				
				
			}
			
			int[][] EllipseMatrix = int[NewClusterNo][5];
			for (int i = 0; i < NewClusterNo; i ++) {
				EllipseMatrix[i][1] = NewAngle*180/3.1416;
				EllipseMatrix[i][2] = NewLongAxis;
				EllipseMatrix[i][3] = NewShortAxis;
				EllipseMatrix[i][4] = NewPosX;
				EllipseMatrix[i][5] = NewPosY; 
			}
			
			
			
			
			
		} else if (ImageType == 'recon') {
			
			
			
			int[][] EllipseMatrix = int[NewClusterNo][5];
			for (int i = 0; i < NewClusterNo; i ++) {
				EllipseMatrix[i][1] = 
				EllipseMatrix[i][2] =
				EllipseMatrix[i][3] = 
				EllipseMatrix[i][4] = 
				EllipseMatrix[i][5] = 
			}
		}
		
		System.out.println('Number of clusters in FEA geometry: ', Float.toString(NewClusterNo));
		float ActualVF = 3.1416 * EllipseMatrix;
		System.out.println('Actual VF in simulation window: ', Float.toString(ActualVF));
		
		if (isReScale == 1) {
			float ReScale = sqrt(vf_expt/ActualVF);
			for (int i = 0; i < NewClusterNo; i ++) {
				EllipseMatrix[i][2] = EllipseMatrix[i][2] * ReScale;
				EllipseMatrix[i][3] = EllipseMatrix[i][3] * ReScale;
			}
		}

		
		CorrectedVF = 3.1416*
		System.out.println('Corrected VF in simulation window: ', Float.toString(CorrectedVF));
	}
	
}