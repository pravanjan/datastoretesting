package TodoModelServices;



import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TodoDataServicesTest {

    private static final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(
                    new LocalDatastoreServiceTestConfig().setDefaultHighRepJobPolicyUnappliedJobPercentage(0));

    private static final TodoDataServices dataServices = new TodoDataServices();


    @BeforeClass
    public static void setup(){
        helper.setUp();

    }

    @AfterClass
    public static  void done (){
        helper.tearDown();
    }

    @Test
    public void saveTask_test_valid_parameter(){
        Key key = dataServices.saveTask("daily","unique_id343434");
        assertEquals("unique_id343434",key.getName());
    }

    @Test
    public void getTask_test() throws EntityNotFoundException {
         Entity entity = dataServices.getTask("unique_id343434");
        assertEquals("unique_id343434",entity.getKey().getName());
    }


}
