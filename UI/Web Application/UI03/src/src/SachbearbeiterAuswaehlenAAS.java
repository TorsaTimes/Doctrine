 package src;

import java.util.HashSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

@ManagedBean(name="sachbearbeiterAuswaehlenAAS")
@RequestScoped
public class SachbearbeiterAuswaehlenAAS {

	String gebuchteFortbildungen  = Fortbildung.druckeFortbildungenStatusReturn(SachbearbeiterEK.gib(SachbearbeiterAuswaehlenAAS.selectedSachbearbeiter));
	
	public static HashSet<String> sachbearbeiterCollectionString = new HashSet<>();

	public static String selectedSachbearbeiter = "-------";

	
	static {
		for (SachbearbeiterEK s : SachbearbeiterEK.sachbearbeiter) {
			sachbearbeiterCollectionString.add(s.getBenutzername());
		}
	}

	public HashSet<String> getSachbearbeiterCollectionString() {
		return sachbearbeiterCollectionString;
	}

	public String getSachbearbeiter() {
		return this.selectedSachbearbeiter;
	}

	public void setSachbearbeiter(String sachbearbeiter) {
		System.out.println(sachbearbeiter);
		this.selectedSachbearbeiter = sachbearbeiter;
	}

	public void valueChangeMethod(ValueChangeEvent e) {
		// assign new value to country
	String hallo = e.getNewValue().toString();
	setGebuchteFortbildungen(hallo);
	}

	
	public String getGebuchteFortbildungen() {
	return gebuchteFortbildungen;
	}

	public void setGebuchteFortbildungen(String gebuchteFortbildungen) {
	this.gebuchteFortbildungen = Fortbildung.druckeFortbildungenStatusReturn(SachbearbeiterEK.gib(gebuchteFortbildungen));
	}
	
	
	
	
	
//	public class SachbearbeiterValueListener implements ValueChangeListener {
//
//		@Override
//		public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
//
//			// access country bean directly
//			SachbearbeiterAuswaehlenAAS country = (SachbearbeiterAuswaehlenAAS) FacesContext.getCurrentInstance()
//					.getExternalContext().getSessionMap().get("country");
//
//			country.setGebuchteFortbildungen(event.getNewValue().toString());
//
//		}
//
//	}
}
