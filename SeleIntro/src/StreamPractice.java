import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class StreamPractice {

	public static void main(String[] args) {

	}

	@Test
	public void streamCollect() {
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> sortList = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortList.get(2));
		
	}
}
