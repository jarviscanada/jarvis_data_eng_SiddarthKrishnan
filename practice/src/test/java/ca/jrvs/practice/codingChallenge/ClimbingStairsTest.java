package ca.jrvs.practice.codingChallenge;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingStairsTest {

    @Test
    public void findSteps() {
        ClimbingStairs cs = new ClimbingStairs();
        assertEquals(3, cs.findSteps(3));
        assertEquals(5, cs.findSteps(4));
    }

    @Test
    public void findStepsDym() {
        ClimbingStairs cs = new ClimbingStairs();
        assertEquals(3, cs.findStepsDym(3));
        assertEquals(5, cs.findStepsDym(4));
    }
}