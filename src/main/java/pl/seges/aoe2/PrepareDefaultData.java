package pl.seges.aoe2;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.seges.aoe2.domain.unit.UnitRepository;
import pl.seges.aoe2.external.unit.UnitData;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
@Log
@Component
public class PrepareDefaultData implements CommandLineRunner {

    private final ObjectMapper objectMapper;
    private final UnitRepository unitRepository;

    @Override
    public void run(String... args) throws Exception {

        UnitData unitData;
        try {

            unitData = objectMapper.readValue(readData(), UnitData.class);
            unitData.getUnits().forEach( unit -> {
                unitRepository.save(unit);
                log.info(unit.toString());
                }
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private File readData() throws IOException {
        return new ClassPathResource("data/units.json").getFile();
    }
}
