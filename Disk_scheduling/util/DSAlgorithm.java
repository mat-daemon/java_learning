package util;

import java.util.ArrayList;

public interface DSAlgorithm {
	public ArrayList<Request> run(int size, int diskHead, ArrayList<Request> queue);
}
