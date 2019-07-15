import com.codahale.metrics.health.HealthCheck;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicHealthCheck extends HealthCheck {
  @Override
  protected Result check() {
    return Result.healthy("OK");
  }
}
