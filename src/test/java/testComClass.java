import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import org.junit.jupiter.api.Test;

public class testComClass {
    @Test
    void testCom(){
        System.out.println("test");

        ActiveXComponent v8App = new ActiveXComponent("V83.14.COMConnector");
        String connectionString = "rvr=\"\"srv-an\"\";Ref=\"\"upn\"\";Usr=\"\"admin\"\";Pwd=\"\"\"\";";

        try {
            Variant isConnected = Dispatch.call(v8App, "Connect", connectionString);



//            Dispatch query = (Dispatch) Dispatch.call(v8App, "NewObject", "Query").getDispatch();
//            Dispatch.put(query, "Text", "SEL ECT Items.Ref, Items.Description FR OM Catalog.Номенклатура AS Items");
//            Dispatch result = Dispatch.call(query, "Execute").toDispatch();
//            Dispatch select = Dispatch.call(result, "Choose").toDispatch();
//
//            String itemDescription = "";
//
//            while (Dispatch.call(select, "Next").getBoolean()) {
//                itemDescription = Dispatch.get(select, "Description").getString();
//                System.out.println(itemDescription);
//            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            Dispatch.call(v8App, "Exit", false);
        }


    }
}
