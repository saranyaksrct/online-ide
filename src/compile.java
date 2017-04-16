import java.io.*;

public class compile {

	public static String compcall(String a[]) {
		String filename = a[0];
		String ch = a[1];
		String file=a[2];
		String sb="";
		System.out.println("entered test"+filename+" "+ch);
		try {
			switch (ch) {
			case "C":
				String command1 = "gcc D:\\prpproject\\server\\" + file;
				//System.out.println(command1);
				ProcessBuilder builder1 = new ProcessBuilder("cmd.exe", "/c",command1, "-o", filename);
				builder1.redirectErrorStream(true);
				Process p1 = builder1.start();
				BufferedReader output1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
				String line1 = "";
				while (true) {
					line1 = output1.readLine();
					if (line1 == null)
						break;
					//sb=sb.append(line1);
					sb=sb+line1;
					System.out.println(line1);
				}
				break;
			case "C++":
				String command2 = "g++ D:\\prpproject\\server\\" + file;
				ProcessBuilder builder2 = new ProcessBuilder("cmd.exe", "/c",command2,"-o",filename);
				builder2.redirectErrorStream(true);
				Process p2=builder2.start();
				BufferedReader output2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
				String line2 = "";
				while (true) {
					line2 = output2.readLine();
					if (line2 == null)
						break;
					//sb=sb.append(line2);
					sb=sb+line2;
					System.out.println(line2);
				}
				break;
			case "JAVA":
				String command3 = "javac D:\\prpproject\\server\\" + file;
				ProcessBuilder builder3 = new ProcessBuilder("cmd.exe","/c",command3);
				builder3.redirectErrorStream(true);
				Process p3 = builder3.start();
				builder3.redirectErrorStream(true);
				BufferedReader output3 = new BufferedReader(new InputStreamReader(p3.getInputStream()));
				String line3 = "";
				while (true) {
					line3 = output3.readLine();
					if (line3 == null)
						break;
					//sb=sb.append(line3);
					sb=sb+line3;
					System.out.println(line3);
				}
				break;
			case "C#":
				String command4 = "C:\\Windows\\Microsoft.NET\\Framework\\v4.0.30319\\csc.exe D:\\prpproject\\server\\"+ file;
				ProcessBuilder builder4 = new ProcessBuilder("cmd.exe", "/c",command4);
				builder4.redirectErrorStream(true);
				Process p4 = builder4.start();
				BufferedReader output4 = new BufferedReader(new InputStreamReader(p4.getInputStream()));
				String line4 = "";
				while (true) {
					line4 = output4.readLine();
					if (line4 == null)
						break;
					//sb=sb.append(line4);
					sb=sb+line4;
					System.out.println(line4);
				}
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb;

	}

}
