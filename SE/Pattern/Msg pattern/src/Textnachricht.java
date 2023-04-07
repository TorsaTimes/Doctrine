public class Textnachricht extends Nachricht {



	private String text;

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Textnachricht(String text) {
		super(text);
		this.text = text;
	}
	
	
	
	
}