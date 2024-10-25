import com.ben.aoc.collection.CircularList;
import com.ben.aoc.collection.Collection;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CollectionTest {

    @Test
    public void slidingStringTest(){
        String input = "abcde";
        List<String> expected = Arrays.asList("ab", "bc", "cd", "de");
        assertEquals(expected, Collection.sliding(input, 2, 1));
        expected = Arrays.asList("ab", "cd", "e");
        assertEquals(expected, Collection.sliding(input, 2, 2));
        expected = Arrays.asList("abc", "de");
        assertEquals(expected, Collection.sliding(input, 3, 3));
    }

    @Test
    public void slidingListTest(){
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 5)
        );
        assertEquals(expected, Collection.sliding(input, 2, 1));
        expected = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                List.of(5)
        );
        assertEquals(expected, Collection.sliding(input, 2, 2));
    }

    @Test
    public void circularListTest(){
        CircularList<Integer> list = new CircularList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals((Integer) 0, list.get(5));
        List<Integer> subList = new CircularList<>();
        subList.add(3);
        subList.add(4);
        subList.add(0);
        assertEquals(subList, list.subList(3, 6));
        assertEquals((Integer) 2, list.getOpposite(0, true));
        assertEquals((Integer) 3, list.getOpposite(0, false));
    }

}
