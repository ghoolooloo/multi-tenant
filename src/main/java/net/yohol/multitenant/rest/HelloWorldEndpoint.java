package net.yohol.multitenant.rest;

import java.util.Set;
import java.util.Arrays;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.jboss.resteasy.spi.HttpRequest;
import org.keycloak.KeycloakSecurityContext;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {
	@Context
  private HttpRequest httpRequest;

	@GET
	@Produces("text/plain")
	public Response doGet() {
		KeycloakSecurityContext securityContext = (KeycloakSecurityContext) httpRequest.getAttribute(KeycloakSecurityContext.class.getName());
		String realm = securityContext.getRealm();
		String user = securityContext.getIdToken().getPreferredUsername();
		Set<String> roles = securityContext.getToken().getRealmAccess().getRoles();

		return Response.ok("Realm: " + realm + ", User: " + user + ", Roles: " + Arrays.toString(roles.toArray())).build();
	}
}