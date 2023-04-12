package commands;

import application.CollectionManager;

public abstract class Command {

    protected CollectionManager collectionManager;

    public Command(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}
