package com.paperscissorsstonegame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class GameSystemTest {
    private GameSystem gs;

    @Before
    public void setUp(){
        gs = new GameSystem();
    }

    @After
    public void tearDown(){
        gs = null;
    }

    @Test
    public void testGameSystem() {
        
    }
}