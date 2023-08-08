import junit.framework.TestCase;
import org.example.Characters;

import java.util.HashMap;
import java.util.Map;

public class TestCharacters extends TestCase {

    public void testCharacters() {
        String test = "@1aaabbiii#iq";

        Map<Character, Integer> map = new HashMap<>();
        Characters.imperative(test, map);


        int a = 0, b = 0, i = 0, q = 0, f = 0;
        if(map.containsKey('a'))
            a = map.get('a');
        if(map.containsKey('b'))
            b = map.get('b');
        if(map.containsKey('i'))
            i = map.get('i');
        if(map.containsKey('q'))
            q = map.get('q');
        if(map.containsKey('f'))
            f = map.get('f');

        assertEquals(3, a);
        assertEquals(2, b);
        assertEquals(4, i);
        assertEquals(1, q);
        assertEquals(0, f);
    }
}
