import io.dropwizard.setup.Environment;

import com.codahale.metrics.MetricRegistry;

import io.prometheus.client.CollectorRegistry;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;

/**
 * Initialize everything you need here.
 */
@AllArgsConstructor
public class BaseResourceFactory {
  protected final DropwizardConfiguration config;
  protected final Environment env;

  public static class ResourceFactory extends BaseResourceFactory {
    public ResourceFactory(DropwizardConfiguration config,
        Environment env) throws IOException {
      super(config, env);
    }

    @Getter(AccessLevel.PUBLIC)
    private final RootResource rootResource = new RootResource();

    @Getter(AccessLevel.PUBLIC)
    private final CollectorRegistry collectorRegistry = new CollectorRegistry();

    @Getter(AccessLevel.PUBLIC)
    private final BasicHealthCheck basicHealthCheck = new BasicHealthCheck();
  }
}
