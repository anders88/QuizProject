package no.kamm.quiz;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class QuizTestServer {

	public static void main(String[] args) {
		Server server = new Server(8080);
		
		WebAppContext serverContext = new WebAppContext();
		serverContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		serverContext.setResourceBase("src/main/webapp");
		serverContext.setContextPath("/");
		
		server.setHandler(serverContext);
		
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
