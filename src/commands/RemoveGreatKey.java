package commands;
import organization.Organization;
import collection.CollectionWorker;
import message.Message;

public class RemoveGreatKey implements Command {
    private final Integer id;

    public RemoveGreatKey(Integer id) {
        this.id = id;
    }

    @Override
    public Message execute(CollectionWorker collectionWorker) {
        return collectionWorker.removeGreatKey(id);
    }
}
