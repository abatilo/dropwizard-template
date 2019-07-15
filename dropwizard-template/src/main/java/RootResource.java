import javax.ws.rs.GET;
import javax.ws.rs.Path;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/")
@RequiredArgsConstructor
public class RootResource {
  @GET
  public String root() {
    log.info("Hello World, structured logging test");
    return "Hello World";
  }
}
