package commands;

import application.CollectionManager;
import data.SpaceMarine;

import java.util.LinkedList;

public class AddCommand extends Command {

    public AddCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute(SpaceMarine spaceMarine) {
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        int initialSize = collection.size();
        collection.add(spaceMarine);
        int finalSize=  collection.size();
        if (finalSize - initialSize == 1) {
            return "Element has been added successfully!\n";
        }
        return "Element has not been added!\n";
    }

}
