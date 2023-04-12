package commands;

import application.CollectionManager;
import data.SpaceMarine;

import java.util.LinkedList;

public class RemoveHeadCommand extends Command {

    public RemoveHeadCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute() {
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        if (collection.isEmpty()) {
            return "Collection is empty. There are no first item in it!\n";
        } else {
            SpaceMarine firstItem = collection.get(0);
            collection.remove(0);
            return "First item has been deleted. It's value: " + firstItem.toString();
        }
    }

}
