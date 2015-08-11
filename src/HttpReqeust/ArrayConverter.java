package HttpReqeust;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayConverter {

	public <T> ArrayList<T> toArrayList(T[] array) {
		System.out.println(array);
		return new ArrayList<T>(Arrays.asList(array));
	}
}
