package commands;
import organization.Organization;
import collection.CollectionWorker;
import message.Message;

public class ReplaceIfLowe implements Command {
    private final Organization organization;

    public ReplaceIfLowe(Organization organization) {
        this.organization = organization;
    }

    @Override
    public Message execute(CollectionWorker collectionWorker) {
        return collectionWorker.replaceIfLowe(organization);
    }
}
