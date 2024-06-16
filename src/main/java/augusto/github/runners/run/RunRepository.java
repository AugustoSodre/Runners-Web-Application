package augusto.github.runners.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> runOptional = findById(id);
        if (runOptional.isPresent()){
            runs.set(runs.indexOf(runOptional.get()), run);
        }
    }

    void delete(Integer id){
        Optional<Run> runOptional = findById(id);
        if (runOptional.isPresent()){
            runs.remove(runOptional.get());
        }
    }

    @PostConstruct
    private void init(){
        //Starts the class with a few runs already
        runs.add(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                6,
                Location.INDOOR));

        runs.add(new Run(2,
                "Wednesday Evening Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                2,
                Location.OUTDOOR));
    }
}
