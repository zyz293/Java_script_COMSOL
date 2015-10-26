import com.jmatio.io.*;
import com.jmatio.types.*;

class matreader {
	public double[][] TemPR;
	public double[][] img_para;
	
	matreader(String data) throws Exception {
		try {
			run(data);
		} catch (Exception e) {}
	}
	
	public void run(String data) throws Exception {
		try {
			if (data == "./RoomTempEpoxyYHNew.mat") {
				MatFileReader matfile = new MatFileReader(data);
				TemPR = ((MLDouble) matfile.getMLArray("TemPR")).getArray();
			} else if (data == "./sample_output_3D_parameter_output.mat") {
				MatFileReader matfile = new MatFileReader(data);
				img_para = ((MLDouble) matfile.getMLArray("img_para")).getArray();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}