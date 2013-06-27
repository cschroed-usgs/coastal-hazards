package gov.usgs.cida.coastalhazards.rest.publish;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author isuftin
 */
@Path("/")
public class PublishResource {

	@GET
	@Path("")
	public Response publishEntryRouter(@Context HttpServletRequest req) throws IOException, URISyntaxException {
		HttpSession session = req.getSession(false);
		URI redir;
		if (session == null
				|| session.getAttribute("oid-info") == null
				|| ((Map<String, String>) session.getAttribute("oid-info")).isEmpty()
				|| StringUtils.isEmpty(((Map<String, String>) session.getAttribute("oid-info")).get("oid-email"))
				|| session.getAttribute("sessionValid") == null
				|| ((Boolean) session.getAttribute("sessionValid")) == false) {
			redir = new URI("../components/OpenID/oid-login.jsp");
		} else {
			redir = new URI("../components/publish/");
		}
		return Response.temporaryRedirect(redir).build();
	}
    
    @POST
    @Path("items")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response publishItems(String items) {
        // do CSW transaction here
        // get Metadata Record ID
        // iterate through items
            // update item with CSW call
            // post item and get posted id
        // return list of added ids
        return Response.serverError().build();
    }
}