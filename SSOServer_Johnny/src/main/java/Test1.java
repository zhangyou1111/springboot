
public class Test1 {

	public static void main(String[] args) {
		try {
			System.out.println(1);
			System.out.println(2);
			return;
		}finally {
			System.out.println(3);
			System.out.println(4);			
		}
	}
}
