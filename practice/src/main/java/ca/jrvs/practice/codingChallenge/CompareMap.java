package ca.jrvs.practice.codingChallenge;

import java.util.Map;

public class CompareMap {
    /**
     * This method to compare maps runs in 0(n) time
     */
    public <K, V> boolean compareMaps(Map<K,V> m1, Map<K,V> m2) {
        return m1.equals(m2);
    }

}
