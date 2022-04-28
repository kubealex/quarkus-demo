package org.acme;

import java.time.Duration;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import io.smallrye.health.api.AsyncHealthCheck;
import io.smallrye.mutiny.Uni;
@Readiness
@ApplicationScoped
public class ReadinessHealthCheck implements AsyncHealthCheck {
    @ConfigProperty(name = "readyness.delay", defaultValue = "1")
    private Long readynessDelay;

    @Override
        public Uni<HealthCheckResponse> call() {
            return Uni.createFrom().item(HealthCheckResponse.up("quarkus-rest-reactive"))
                    .onItem().delayIt().by(Duration.ofMillis(readynessDelay));
        }    
    }
