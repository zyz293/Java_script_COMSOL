class tryconvert {
	public static void main(String[] args) throws Exception {
		try {
			matreader a = new matreader("./RoomTempEpoxyYHNew.mat");
			System.out.println(a.TemPR.length);
			matreader b = new matreader("./sample_output_3D_parameter_output.mat");
			System.out.println(b.img_para.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}