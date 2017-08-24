package com.bobbyratliff;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyDemo {

    public static void main(String[] args) throws Exception {
        Server jettyServer = new Server(8080);
        jettyServer.setHandler(getFullHandler());
        jettyServer.start();
        jettyServer.join();
    }

    public static Handler getFullHandler() {
        ServletContainer jerseyContainer = new ServletContainer(new JerseyConfig());
        ServletHolder jerseyServlet = new ServletHolder(jerseyContainer);

        ServletContextHandler restContext = new ServletContextHandler();
        restContext.setContextPath("/api");
        restContext.addServlet(jerseyServlet, "/*");

        ServletContextHandler contentContext = new ServletContextHandler();
        ResourceHandler staticResources = new ResourceHandler();
        staticResources.setResourceBase("my-app/build");
        staticResources.setWelcomeFiles(new String[] { "index.html"});
        contentContext.setContextPath("/");
        contentContext.setHandler(staticResources);

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] {restContext, contentContext});

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] {contexts});
        return handlers;
    }
}
