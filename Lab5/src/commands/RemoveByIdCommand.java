package commands;

import application.CollectionManager;
import data.SpaceMarine;

import java.util.LinkedList;

public class RemoveByIdCommand extends Command {

    public RemoveByIdCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute(int id) {
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        for (SpaceMarine spaceMarine : collection) {
            if (spaceMarine.getId() == id) {
                collection.remove(spaceMarine);
                return "Element has been removed successfully!\n";
            }
        }
        return "Element has not been removed because element with this ID does not exists in collection!\n";
    }

}
