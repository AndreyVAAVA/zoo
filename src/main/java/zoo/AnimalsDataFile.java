package zoo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;

import java.util.List;

/**
 * Class for JSON deserialization.
 * JSON contains information about animals of each type
 */
@Getter
public class AnimalsDataFile {

    /**
     *  List containing info about carnivore type animals
     */
    @JacksonXmlProperty(localName = "carnivoreAnimals")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Carnivore> carnivoreAnimals;
    /**
     * List containing info about herbivore type animals
     */
    @JacksonXmlProperty(localName = "herbivoreAnimals")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Herbivore> herbivoreAnimals;
}

