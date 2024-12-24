import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
	public static void dayfirst() {
		FileReader reader = new FileReader();
		ArrayList<String> input = new ArrayList<>();
		try {
			input = reader.readFileFromResources("Day3Input");
		} catch (IOException e) {

			e.printStackTrace();
		}
		int result = 0;
		for (String elm : input) {
			String pattern = "(mul\\()[0-9]+,[0-9]+\\)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(elm);

			while (m.find()) {
			   Pattern pattern2 = Pattern.compile("\\d+");
		        Matcher matcher2 = pattern2.matcher(m.group());
		        int tmp = 1;
		        while (matcher2.find()) {
		            tmp *= (Integer.parseInt(matcher2.group()));
		        }
			   result += tmp;
			}
		}
		System.out.println(result);
	}
	public static void daysecond() {
		FileReader reader = new FileReader();
		ArrayList<String> input = new ArrayList<>();
		try {
			input = reader.readFileFromResources("Day3Input");
		} catch (IOException e) {

			e.printStackTrace();
		}
		String tmp = splitString(String.join("...", input));
		//System.out.println(tmp);
		int result = 0;

			String pattern = "(mul\\()[0-9]+,[0-9]+\\)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(tmp);

			while (m.find()) {
			   Pattern pattern2 = Pattern.compile("\\d+");
		        Matcher matcher2 = pattern2.matcher(m.group());
		        int tmpMul = 1;
		        while (matcher2.find()) {
		        	tmpMul *= (Integer.parseInt(matcher2.group()));
		        }
			   result += tmpMul;
			}
		
		System.out.println(result);
	}
	
	private static String splitString(String s){
		Pattern dopattern = Pattern.compile("do\\(\\)");
		Pattern dontpattern = Pattern.compile("don't\\(\\)");
		Matcher domatcher, dontmatcher;
		String result = "";
		String tmp = s;
		while (true) {
			dontmatcher = dontpattern.matcher(tmp);
			if (dontmatcher.find()) {
				result += "\n" + tmp.substring(0, dontmatcher.start());
				tmp = tmp.substring(dontmatcher.end());
			}else {
				return result + "..." +  tmp;
			}
			domatcher = dopattern.matcher(tmp);
			if (domatcher.find()) {
				tmp = tmp.substring(domatcher.end());
			} else {
				return result;
			}
		}
	}
}
