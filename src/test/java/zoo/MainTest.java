package zoo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        Main.main(new String[]{"-configtype=xml", "-configfile=C:\\Users\\volko\\IdeaProjects\\zoo\\src\\main\\resources\\zooAnimalsXML.xml"});
    }
}