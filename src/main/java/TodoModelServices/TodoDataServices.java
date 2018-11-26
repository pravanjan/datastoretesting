package TodoModelServices;

import com.google.appengine.api.datastore.*;

public class TodoDataServices {

    private DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    
    public Key saveTask (String type , String keyString ){
        Entity todo = new Entity("Todo", keyString);
        todo.setProperty("name","pravanjan");
        todo.setProperty("type",type);
        return  datastore.put(todo);
    }

    public Entity getTask (String keyString ) throws EntityNotFoundException {
        Key key = new KeyFactory.Builder("Todo", keyString).getKey();
        Entity entity = datastore.get(key);
        return entity;
    }
}
