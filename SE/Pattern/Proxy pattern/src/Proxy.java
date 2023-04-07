
public class Proxy implements Component {

	
	private static Component object;
	
	@Override
	public void process() {
		if(object == null) {
			object = new RealObject();
		}
		object.process();
		
	}

}
