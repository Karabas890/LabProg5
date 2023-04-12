package commands;

import application.CollectionManager;
import data.SpaceMarine;

import java.util.LinkedList;

public class UpdateCommand extends Command {

    public UpdateCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute(int id, SpaceMarine spaceMarine) {
        spaceMarine.setId(id);
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        for (SpaceMarine currentSpaceMarine : collection) {
            if (currentSpaceMarine.getId() == id) {
                collection.remove(currentSpaceMarine);
                collection.add(spaceMarine);
                return "Element has been updated successfully!\n";
            }
        }
        return "Element with this ID does not exists in collection. Impossible to update.\n";
    }

}
