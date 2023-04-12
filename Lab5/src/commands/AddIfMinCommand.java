package commands;

import application.CollectionManager;
import data.SpaceMarine;

import java.util.LinkedList;

public class AddIfMinCommand extends Command {

    public AddIfMinCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute(SpaceMarine spaceMarine) {
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        for (SpaceMarine spaceMarine2 : collection) {
            int k = spaceMarine.compareTo(spaceMarine2);
            if(k != -1){
                return "New element value is not less than the smallest element.Element has not been added!\n";
            }
        }
        int initialSize = collection.size();
        collection.add(spaceMarine);
        int finalSize =  collection.size();
        if (finalSize - initialSize == 1) {
            return "Element has been added successfully!\n";
        } else {
            return "Element has not been added!\n";
        }
    }


}
