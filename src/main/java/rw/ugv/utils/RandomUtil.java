package rw.ugv.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class RandomUtil {
	private final static Random random = new Random(System.currentTimeMillis());
	public static <T> T getRandomFromList(List<T> list) {
		int randomIndex = random.nextInt(list.size());
		return list.get(randomIndex);
	}
		

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Sergej");
		list.add("Artem");
		list.add("Vladimir");
		for (int i =0; i < 20; i++) {
			System.out.print(RandomUtil.getRandomFromList(list) + ", ");
		}
		


	}

}
