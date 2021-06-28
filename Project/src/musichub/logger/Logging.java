package musichub.logger;

import musichub.main.main.Main;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {

	private FileHandler fh;
	final static Logger logger = Logger.getLogger(Main.class.getName());
	public Logging() {
		setUpLogger();
	}

	private void setUpLogger(){
		logger.setLevel(Level.ALL);

		logger.setUseParentHandlers(false);
		try {

			fh = new FileHandler(System.getProperty("user.dir")+"\\Project\\files\\jmusichub.log", true);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.info("JMusicHub Started");

		}catch (SecurityException | IOException e){
			logger.severe(e.getMessage());
			close();
		}

	}
	public static void log(String log){
		logger.info(log);
	}

	public static void fatal(String log){
		logger.log(Level.SEVERE, log);
	}

	public void close(){
		fh.close();
	}
}
