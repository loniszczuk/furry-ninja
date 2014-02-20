package ar.com.fn.ai;

import java.util.Random;

/**
 * @author jformoso
 */
public class Bot {
	
	public int[] getMoves() {
		int[] ret = new int[5];
		
	    Random rand = new Random();
		for (int i = 0; i < 5; i++) {
			ret[i] = rand.nextInt((2) + 1);
		}
		
		return ret;
	}

	public String getName() {
		return "Random Bot";
	}
}
