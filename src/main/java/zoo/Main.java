package zoo;

import java.util.Objects;

public class Main {

    public static void main(String[] argv) {
        String configType = null;
        String filePath = null;
        boolean isPathAbsolute = false;
        if (argv.length > 2) throw new IllegalArgumentException();
        for (int i = 0; i < argv.length; i++) {
            if (argv[i].contains("-configtype=")) {
                configType = argv[i].split("=")[1];
            }
            if (argv[i].contains("-configfile=")) {
                filePath = argv[i].split("=")[1];
                isPathAbsolute = true;
            }
        }
        if (filePath == null)
            filePath = argv[configType == null ? 0 : 1];

        filePath = isPathAbsolute ? filePath : Objects.requireNonNull(Main.class.getClassLoader().getResource(filePath)).getPath();

        // Create zoo
        Zoo zoo = new Zoo();
        // Add animals to the zoo
        if (configType != null)
            zoo.setFileType(configType.equals("json") ? FileType.JSON : FileType.XML);
        zoo.addAnimals(filePath);

        // Create user action trigger
        ActionTrigger trigger = new ActionTrigger(zoo);

        AnimalType herbivore = AnimalType.HERBIVORE;
        AnimalType carnivore = AnimalType.CARNIVORE;

        // All of the following actions are up to users choice
        zoo.printAllStates();
        trigger.setMorning();
        zoo.printAllStates();

        trigger.visit(herbivore);
        zoo.printAllStates();
//        trigger.visit(carnivore);
        trigger.feedAnimals(herbivore);
        zoo.printAllStates();

        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();

        trigger.setThunder();
        zoo.printAllStates();
        trigger.feedAnimals(carnivore);
        zoo.printAllStates();

        trigger.feedAnimals(herbivore);
        zoo.printAllStates();
        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();
    }
}