import io.dropwizard.lifecycle.Managed;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SQSPuller implements Managed {

  private final AtomicBoolean isRunning = new AtomicBoolean(false);
  private final SQSProcessor processor;

  @Override
  public void start() {
    isRunning.set(true);
    new Thread(() -> {
      while (isRunning.get()) {
        List<String> pretendMessagesFromSQS = Arrays.asList("Message", "From", "SQS");
        for (String message : pretendMessagesFromSQS) {
          processor.process(message);
        }
        try {
          Thread.sleep(2000);
        } catch (Exception ex) {
          // Intentionally empty
        }
      }
    }).start();
  }

  @Override
  public void stop() {
    isRunning.set(false);
  }
}
