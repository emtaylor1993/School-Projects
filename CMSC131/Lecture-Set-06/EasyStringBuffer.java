public class EasyStringBuffer {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer name1 = new StringBuffer("Jan");
		StringBuffer name2 = name1;
		System.out.println("StringBuffer names before = " + name1 + "/" + name2);
		name1.append(" Plane");
		System.out.println("StringBuffer names after = " + name1 + "/" + name2);
	}
}
