import java.io.*;
import java.lang.ProcessBuilder.Redirect;
public class run {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
    public static String runcall(String b[]){	
	// TODO Auto-generated method stub
		String filename = b[0];
		String ch = b[1];
		System.out.println("entered testing");
		//StringBuffer sb=new StringBuffer();
		String sb="";
		try
		{
			switch(ch)
			{
			case "C":
				ProcessBuilder builder1 = new ProcessBuilder("D:\\eclipse-jee-luna-SR1a-win32\\eclipse\\"+filename+".exe", 
						"D:\\prpproject\\server\\input.txt");
				File input=new File("D:\\prpproject\\server\\input.txt");
				builder1.redirectInput(input);
				builder1.redirectOutput();
				Process p1=builder1.start();		
				BufferedReader input1=new BufferedReader(new InputStreamReader(p1.getInputStream()));
				System.out.println(input1);
				String line1 = "";
				while (true) {
					line1 = input1.readLine();
					if (line1 == null)
						break;
					//sb=sb.append(line1);
					sb=sb+line1;
					System.out.println(line1);
				}
				System.out.println(sb+"buffer");
				break;
			case "C++":
				ProcessBuilder builder2 = new ProcessBuilder("D:\\eclipse-jee-luna-SR1a-win32\\eclipse\\"+filename+".exe", "D:\\prpproject\\server\\input.txt");
				builder2.redirectInput();
				builder2.redirectOutput();
				Process p2=builder2.start();		
				BufferedReader input2=new BufferedReader(new InputStreamReader(p2.getInputStream()));
				System.out.println(input2);
				String line2 = "";
				while (true) {
					line2 = input2.readLine();
					if (line2 == null)
						break;
					//sb=sb.append(line2);
					sb=sb+line2;
					System.out.println(line2);
				}
				System.out.println(sb+"buffer");
				break;
				
			case "JAVA":
				ProcessBuilder builder3 = new ProcessBuilder("java", "-classpath", "D:\\prpproject\\server", filename, "D:\\prpproject\\server\\input.txt");
				builder3.redirectInput();
				builder3.redirectOutput();
				Process p3=builder3.start();		
				BufferedReader input3=new BufferedReader(new InputStreamReader(p3.getInputStream()));
				System.out.println(input3);
				String line3 = "";
				while (true) {
					line3 = input3.readLine();
					if (line3 == null)
						break;
					//sb=sb.append(line3);
					sb=sb+line3;
					System.out.println(line3);
				}
				System.out.println(sb+"buffer");
				break;
          
				case "C#":
				ProcessBuilder builder4 = new ProcessBuilder("D:\\eclipse-jee-luna-SR1a-win32\\eclipse\\"+filename+".exe", "D:\\prpproject\\server\\input.txt");
				builder4.redirectInput();
				builder4.redirectOutput();
				Process p4=builder4.start();
				BufferedReader input4=new BufferedReader(new InputStreamReader(p4.getInputStream()));
				System.out.println(input4);
				String line4 = "";
				while (true) {
					line4 = input4.readLine();
					if (line4 == null)
						break;
					//sb=sb.append(line4);
					sb=sb+line4;
					System.out.println(line4);
				}
			break;
			}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
		

	}

}
