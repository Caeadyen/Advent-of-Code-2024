import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day2 {
	public static void dayfirst() {
		FileReader reader = new FileReader();
		ArrayList<String> input = new ArrayList<>();
		try {
			input = reader.readFileFromResources("Day2Input");
		} catch (IOException e) {

			e.printStackTrace();
		}
		int result = 0;
		for (String elm : input) {
			String[] parts = elm.split(" ");
			if (Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) > 0) {
				result += checkIncreasing(parts);
			}else if(Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) < 0) {
				result += checkDecreasing(parts);
			}else {
				result += 1;
			}
		}
		System.out.println(input.size() - result);
	}
	
	private static int checkIncreasing(String[] s) {
		for (int i = 1; i < s.length; ++i) {
			int test = Integer.parseInt(s[i]) - Integer.parseInt(s[i - 1]);
			if ( test > 3 || test <= 0) {
				return 1;
			}
		}
		return 0;
	}
	
	private static int checkDecreasing(String[] s) {
		for (int i = 1; i < s.length; ++i) {
			int test = Integer.parseInt(s[i - 1]) - Integer.parseInt(s[i]);
			if ( test > 3 || test <= 0) {
				return 1;
			}
		}
		return 0;
	}
	
	public static void daysecond() {
		FileReader reader = new FileReader();
		ArrayList<String> input = new ArrayList<>();
		try {
			input = reader.readFileFromResources("Day2Input");
		} catch (IOException e) {

			e.printStackTrace();
		}
		int result = 0;
		int tmp = 0;
		for (String elm : input) {
			String[] parts = elm.split(" ");
			if (Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) > 0) {
				tmp = checkIncreasing(parts);
			}else if(Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) < 0) {
				tmp = checkDecreasing(parts);
			}else {
				tmp = 1;
			}
			if (tmp == 1) {
				tmp = tryRemove(parts);
			}
			
			result += tmp;
		}
		System.out.println(input.size() - result);
	}
	
	private static int tryRemove(String[] s) {
		int tmp = 1;
		for (int i = 0; i < s.length; ++i) {
			String[] parts = copyRemove(s, i);
			if (Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) > 0) {
				tmp = checkIncreasing(parts);
			}else if(Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) < 0) {
				tmp = checkDecreasing(parts);
			}
			if (tmp == 0) {
				return tmp;
			}
		}
		return 1;
	}
	
	private static String[] copyRemove(String[] s, int n) {
		String[] result = new String[s.length - 1];
		System.arraycopy(s, 0, result, 0, n);
		System.arraycopy(s, n + 1, result, n, s.length - n - 1);
		
		return result;
	}
}
