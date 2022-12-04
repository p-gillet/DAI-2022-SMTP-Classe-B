package src.main.tests;

// Junit tests for the app
import org.junit.Test;
import src.main.configs.*;
import src.main.models.*;

import java.io.IOException;
import java.util.Vector;


public class AppTest {

   @Test
   public void testLoadPerson() throws IOException {
      ConfigurationManager config = ConfigurationManager.loadFromFile("src/main/configs/config.txt");
      Person person = Person.loadFromFile(config.getVictimsFilePath(), 2);
      assert(person.getFirstName().equals("Edsel"));
      assert(person.getLastName().equals("Fletcher"));
      assert(person.getEmail().equals("efletcher0@diigo.com"));
   }

   @Test
   public void testLoadGroup() throws IOException {
      ConfigurationManager config = ConfigurationManager.loadFromFile("src/main/configs/config.txt");
      Group group = Group.loadFromFile(config.getVictimsFilePath(), 3, 0);
      assert(group.getPerson(2).getFirstName().equals("Edsel"));
      assert(group.getPerson(2).getLastName().equals("Fletcher"));
      assert(group.getPerson(2).getEmail().equals("efletcher0@diigo.com"));
   }

   @Test
   public void testGeneratePrank() throws IOException {
      ConfigurationManager config = ConfigurationManager.loadFromFile("src/main/configs/config.txt");
      PrankGenerator prankGenerator = new PrankGenerator(config);
      Vector<Group> groupsVictims = Group.loadGroupsFromFile(config.getVictimsFilePath(), config.getNumberOfGroups());
      Prank prank = prankGenerator.generatePrank(groupsVictims.get(0));
      assert(prank.getVictims().getPerson(2).getFirstName().equals("Edsel"));
      assert(prank.getVictims().getPerson(2).getLastName().equals("Fletcher"));
      assert(prank.getVictims().getPerson(2).getEmail().equals("efletcher0" +
         "@diigo.com"));
   }
}
