import java.io.File;
public class test {
	
	
	public static void main(String[] args)  throws Exception{
		try {
			File source = new File("C:/Users/DaTui/Desktop/winter_quarter/research/doing/FEA_code/3D_java_code_v2/1.txt");
			if (source.renameTo(new File("C:/Users/DaTui/Desktop/winter_quarter/research/doing/FEA_code/3D_java_code_v3/" + source.getName()))) {
				System.out.println("File is moved successful");
			} else {
				System.out.println("File is failed to move");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}
