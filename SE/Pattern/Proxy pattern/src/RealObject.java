import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

public class RealObject implements Component {

	
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public RealObject() {
		printRealObject();
	}
	
	
	@Override
	public void process() {
		logger.info("In RealObject in Process");
		
	}
	
	private void printRealObject() {
		logger.info("Loading initial configuration...");
	}

}
