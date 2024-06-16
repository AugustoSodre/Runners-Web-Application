package augusto.github.runners.run;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location
        ){

        public Run {
                if (completedOn.isBefore(startedOn)) {
                        throw new IllegalArgumentException("Completed on must be before startedOn");
                }
        }
}

