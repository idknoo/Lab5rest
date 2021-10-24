package commands;

import collection.CollectionWorker;
import message.Message;

public class RemoveKey implements Command {
    private final Integer id;

    public RemoveKey(Integer id) {
        this.id = id;
    }

    @Override
    public Message execute(CollectionWorker collectionWorker) {
        return collectionWorker.removeKey(id);
    }
}
