public class EasyString {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name1 = new String("Jan");
		String name2 = name1;
		System.out.println("String names before = " + name1 + "/" + name2);
		name1 += " Plane";
		System.out.println("String names after = " + name1 + "/" + name2);
	}
}
