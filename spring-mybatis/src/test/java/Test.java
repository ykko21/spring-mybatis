import java.util.UUID;

public class Test {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(UUID.randomUUID());
		System.out.println(System.currentTimeMillis());
		for(int i=0; i<20; i++) {
			System.out.println(UUID.randomUUID());
		}		
		System.out.println(System.currentTimeMillis());
	}
}
