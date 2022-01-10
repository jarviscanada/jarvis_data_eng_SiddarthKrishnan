package ca.jrvs.practice.codingChallenge;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CompareMapTest {

    @Test
    public void compareMaps() {
        CompareMap a = new CompareMap();
        Map<String, String> x = new HashMap<>();
        Map<String, String> y = new HashMap<>();
        x.put("key1", "val1");
        y.put("key1", "val1");
        x.put("key2", "val2");
        y.put("key2", "val2");
        assertTrue(a.compareMaps(x, y));
    }
}