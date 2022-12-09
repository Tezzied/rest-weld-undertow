package io.tezzied;

import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.cdi.CdiInjectorFactory;
import org.jboss.resteasy.core.ResteasyDeploymentImpl;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        ResteasyDeployment resteasyDeployment = new ResteasyDeploymentImpl();
        resteasyDeployment.setApplicationClass(MainApplication.class.getName());
        resteasyDeployment.setInjectorFactoryClass("org.jboss.resteasy.cdi.CdiInjectorFactory"); // set CDI injector factory
        DeploymentInfo deploymentInfo=server.undertowDeployment(resteasyDeployment,"/");
        deploymentInfo.setClassLoader(App.class.getClassLoader());
        deploymentInfo.setDeploymentName("Undertow + Resteasy example");
        deploymentInfo.setContextPath("/api");
        deploymentInfo.addListener(Servlets.listener(org.jboss.weld.environment.servlet.Listener.class));
        server.deploy(deploymentInfo);
        server.start(Undertow.builder()
                .addHttpListener(8080, "localhost"));
    }
}
