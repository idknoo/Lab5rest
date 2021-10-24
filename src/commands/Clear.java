package commands;

import collection.CollectionWorker;
import message.Message;

public class Clear implements Command {

    @Override
    public Message execute(CollectionWorker collectionWorker) {
        return collectionWorker.clear();
    }
}
