package app.bugbank.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import io.cucumber.java.Scenario;
import java.util.Objects;

@Getter
@Setter
@ToString
public class ScenarioSupport {
    public String tagsNames;
    public static Scenario scenario;
    private static ScenarioSupport instance;

    private ScenarioSupport(){

    }

    public static ScenarioSupport getInstance(){
        if(Objects.isNull(instance))
            instance = new ScenarioSupport();
        return instance;
    }
}
