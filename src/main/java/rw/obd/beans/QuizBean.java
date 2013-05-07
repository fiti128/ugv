package rw.obd.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



@Named
@SessionScoped
public class QuizBean implements Serializable {
	private ArrayList<ProblemBean> problems;
	private int currentIndex;
	private int score;
	
	private static final long serialVersionUID = -6915541293642367446L;
	public QuizBean() {
		problems = new ArrayList<ProblemBean>();
		problems.add(new ProblemBean(new int[] {3,1,4,1,5},9));
		problems.add(new ProblemBean(new int[] {1,1,2,3,5},8));
		problems.add(new ProblemBean(new int[] {1,4,9,16,25},36));
		problems.add(new ProblemBean(new int[] {2,3,5,7,11},13));
		problems.add(new ProblemBean(new int[] {1,2,4,8,16},32));
		
	}
	public int getScore() {
		return score;
	}
	public ProblemBean getCurrent() {
		return problems.get(currentIndex);
	}
	public String getAnswer() {
		return "";
	}
	public void setAnswer(String newValue) {
		
			int answer = Integer.parseInt(newValue.trim());
			if (getCurrent().getSolution() == answer) {
				score ++;
			}
			currentIndex = (currentIndex +1);
			if (currentIndex == problems.size()) {
				currentIndex = 0;
			}
	}
	
}
