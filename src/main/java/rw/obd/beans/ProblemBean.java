package rw.obd.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class ProblemBean implements Serializable {

	private static final long serialVersionUID = -839889269544704291L;
	public ProblemBean() {}
	public ProblemBean(int[] values, int solution){
		sequence = new ArrayList<Integer>();
		for (int i : values) {
			sequence.add(i);
		}
		this.solution = solution;
	}
	
	
	private ArrayList<Integer> sequence;
	private int solution;
	public ArrayList<Integer> getSequence() {
		return sequence;
	}
	public void setSequence(ArrayList<Integer> sequence) {
		this.sequence = sequence;
	}
	public int getSolution() {
		return solution;
	}
	public void setSolution(int solution) {
		this.solution = solution;
	}
	
	

}
