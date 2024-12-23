import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day1 {

	public static void day1first() {
		FileReader reader = new FileReader();
		ArrayList<String> exampleInput = new ArrayList<>();
		try {
			exampleInput = reader.readFileFromResources("Day1Input");
		} catch (IOException e) {

			e.printStackTrace();
		}
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();
		for (String s : exampleInput) {
			String[] elm = s.split(" +");
			first.add(Integer.parseInt(elm[0]));
			second.add(Integer.parseInt(elm[1]));
			
		}
		first.sort(null);
		second.sort(null);
		int result = 0;
		for (int i = 0; i < first.size(); ++i) {
			result += Math.abs(first.get(i) - second.get(i));
		}
		System.out.println(result);
	}
	
	public static void day1second() {
		FileReader reader = new FileReader();
		ArrayList<String> exampleInput = new ArrayList<>();
		try {
			exampleInput = reader.readFileFromResources("Day1Input");
		} catch (IOException e) {

			e.printStackTrace();
		}
		ArrayList<Integer> first = new ArrayList<>();
		Map<Integer, Integer> second = new HashMap<>();
		for (String s : exampleInput) {
			String[] elm = s.split(" +");
			first.add(Integer.parseInt(elm[0]));
			int num = Integer.parseInt(elm[1]);
			if (second.containsKey(num)) {
				second.put(num, second.get(num) + 1);
			}else {
				second.put(num, 1);
			}	
		}
		first.sort(null);
		int result = 0;
		for (int i = 0; i < first.size(); ++i) {
			if (second.containsKey(first.get(i))) {
				result += first.get(i) * second.get(first.get(i));				
			}
		}
		System.out.println(result);
	}
}
