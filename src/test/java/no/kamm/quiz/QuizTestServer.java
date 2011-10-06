package no.kamm.quiz;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class QuizTestServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		server.setHandler(new WebAppContext("src/main/webapp", "/"));
		server.start();
	}

}
