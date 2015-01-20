package ETL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class WordLadderIITest {
	@Test
	public void tc01() {
		WordLadderII service = new WordLadderII();
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("c");
		dict.add("b");
		List<List<String>> result = service.findLadders(start, end, dict);
		System.out.println(result.size());
	}
}
