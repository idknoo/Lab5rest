package commands;

import collection.CollectionWorker;
import message.Message;

public class MaxByName implements Command{

    @Override
    public Message execute(CollectionWorker collectionWorker) {
        return collectionWorker.maxByName();
    }
}
