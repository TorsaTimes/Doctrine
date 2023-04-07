
public class PrintVisitor implements GeraeteManagerVisitor {
	public static String space="";

	@Override
	public Object visit(Bauteil b) {

		System.out.println(space + "[-]" + b.getName());
		space = space + "  ";
		for (Component c : b.liste) {
	
			c.visit(this);
		}
		space = "  ";
		return "";
	}

	@Override
	public Object visit(Teil t) {
		System.out.println(space + " -->" + t.name);
		return "";
	}

}
