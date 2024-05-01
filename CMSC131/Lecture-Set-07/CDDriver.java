public class CDDriver {
	/**
	 * Shows the use of the CD and RewritebleCD classes
	 * as well as their owners and collectors
	 */
	public static void main(String[] args) {
		System.out.println("****Regular CD ***");
		CDCollectionOwner p = new CDCollectionOwner();
		System.out.println(" before: " + p);
		CD myFav = new CD("Barry Manilow","One Voice");
		CD[] a = p.getCDsReferenceCopy();
		a[0] = myFav;
		System.out.println("after reference copy:");
		System.out.println(p);
		System.out.println("-------------------");
		CDCollectionOwner newp = new CDCollectionOwner();
		System.out.println(" before: " + newp);
		CD[] newa = newp.getCDsShallowCopy();
		newa[0] = myFav;
		System.out.println("after shallow copy:");
		System.out.println(newp);
		System.out.println("*********************************");
		System.out.println("***Rewritable CD***");
		RewriteableCDCollectionOwner q = new RewriteableCDCollectionOwner();
		System.out.println(" before:" + q);
		RewriteableCD[] b = q.getCDsShallowCopy();
		b[0].rewrite("Barry Manilow","One Voice");
		System.out.println("after shallow copy:");
		System.out.println(q);
		System.out.println("-------------------");
		RewriteableCDCollectionOwner newq = new RewriteableCDCollectionOwner();
		System.out.println(" before:" + newq);
		RewriteableCD[] newb = newq.getCDsDeepCopy();
		newb[0].rewrite("Barry Manilow", "One Voice");
		System.out.println("after deep copy:");
		System.out.println(newq);
	}
}
