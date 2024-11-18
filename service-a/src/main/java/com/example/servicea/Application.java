package com.example.servicea;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.common.Attributes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public static class MetricsController {

        private final LongCounter arcadeGameCounter;

        public MetricsController() {
            // Initialize OpenTelemetry Meter and Counter
            Meter meter = GlobalOpenTelemetry.get()
                    .getMeter("instrumentation-library-name");

            arcadeGameCounter = meter
                    .counterBuilder("arcadeGame")
                    .setDescription("arcadeGame Test Custom Metrics")
                    .setUnit("1") // kg, lbs, cm, etc
                    .build();
        }

        @GetMapping("/process")
        public String process() {
            // Increment custom metric with a label
            arcadeGameCounter.add(1, Attributes.builder() // attributes instead of labels
                    .put("type", "endless")
                    .build());

            return "Processed in Service A!";
        }
    }
}