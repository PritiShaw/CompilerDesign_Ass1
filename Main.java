import java.util. * ;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	public static String search(String x, int row, int i) throws IOException {
		int len = x.length();
		int col = i - len;
		String toSearch = "";
		String check;
		try (BufferedReader br = new BufferedReader(new FileReader("DataSet.txt"))) {
			while ((check = br.readLine()) != null) {
				if (check.length() > 3) {
					int sc1 = check.indexOf(";");
					int sc2 = check.lastIndexOf(";");
					String word = check.substring(0, sc1);
					if (x.equals(word.toLowerCase())) {
						return check.substring(sc1 + 1, sc2);
					}
					else continue;
				}
				else continue;
			}
		}
		return "";
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader("Input.txt"))) {
			String line;
			String x = "";
			int row = 0;
			System.out.println("-----------------------------------------------------");
			System.out.println("Row\tCol\tWord\t\tToken");
			System.out.println("-----------------------------------------------------");
			while ((line = br.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					if (line.length() == 0) continue;
					char s = line.charAt(i);
					if (s == ',' || s == '.' || s == ':' || s == ';' || s == ' ') {
						String result = search(x, row, i);
						if (result.length() > 0) {
							System.out.println(Integer.toString(row + 1) + "\t" + Integer.toString(i) + "\t" + x + "\t\t" + result);
						}
						x = "";
					}
					else {
						x += s;
					}
				}
				row++;
			}
		}
	}

}