package src.main.tests;

// Junit tests for the app
import org.junit.Test;
import src.main.configs.ConfigurationManager;
import src.main.models.Person;

import java.io.IOException;


public class AppTest {

   @Test
   /**
    * Test that a person is loaded correctly
    *
    */
   public void testLoadPerson() throws IOException {
      ConfigurationManager config = ConfigurationManager.loadFromFile("src/main/configs/config.txt");
      Person person = Person.loadFromFile(config.getVictimsFilePath(), 2);
      assert(person.getFirstName().equals("Edsel"));
      assert(person.getLastName().equals("Fletcher"));
      assert(person.getEmail().equals("efletcher0@diigo.com"));
   }

   @Test
   /**
    * Test that a group is loaded correctly
    *
    */
   public void testLoadGroup() throws IOException {
      ConfigurationManager config = ConfigurationManager.loadFromFile("src/main/configs/config.txt");
      Person person = Person.loadFromFile(config.getVictimsFilePath(), 2);
      assert(person.getFirstName().equals("Edsel"));
      assert(person.getLastName().equals("Fletcher"));
      assert(person.getEmail().equals("efletcher0@diigo.com"));
   }
}
