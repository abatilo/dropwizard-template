import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import io.prometheus.client.dropwizard.DropwizardExports;
import io.prometheus.client.exporter.MetricsServlet;

import lombok.SneakyThrows;

public class DropwizardApplication
  extends Application<DropwizardConfiguration> {

  @Override
  public void run(DropwizardConfiguration config, Environment env)
    throws Exception {
    BaseResourceFactory.ResourceFactory resources =
      new BaseResourceFactory.ResourceFactory(config, env);

    env.healthChecks().register("BasicHealthCheck", resources.getBasicHealthCheck());

    env.jersey().register(resources.getRootResource());

    resources.getCollectorRegistry().register(new DropwizardExports(env.metrics()));
    env.admin().addServlet("Prometheus metrics", new
        MetricsServlet(resources.getCollectorRegistry()))
      .addMapping("/metrics-text");
  }

  @SneakyThrows
  public static void main(String[] args) {
    new DropwizardApplication().run(args);
  }
}
