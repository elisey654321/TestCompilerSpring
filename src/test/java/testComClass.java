//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.Dispatch;
//import com.jacob.com.Variant;
//import javafx.css.CssMetaData;
import javafx.css.Styleable;
import org.junit.jupiter.api.Test;

public class testComClass {
//    @Test
//    void testCom(){
////        System.out.println("test");
//
//        System.out.println(System.getProperty("java.library.path"));
////        System.loadLibrary("jacob-1.20-x64.dll");
//
//
//        ActiveXComponent v8App = new ActiveXComponent("V83.ComConnector");
//        String connectionString = "Srvr=\"srv-an\";Ref=\"upn\";Usr=\"admin\";Pwd=\"\";";
//
//        try {
//            Variant isConnected = Dispatch.call(v8App, "Connect", connectionString);
//
//            Dispatch query = (Dispatch) Dispatch.call(v8App, "NewObject", "Query").getDispatch();
//            Dispatch.put(query, "Text", "SELECT Items.Ref,Items.name FROM Catalog.ОбъектыСтроительства AS Items");
//            Dispatch result = Dispatch.call(query, "Execute").toDispatch();
//            Dispatch select = Dispatch.call(result, "Choose").toDispatch();
//
//            String itemDescription = "";
//
//            while (Dispatch.call(select, "Next").getBoolean()) {
//                itemDescription = Dispatch.get(select, "name").getString();
//                System.out.println(itemDescription);
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            Dispatch.call(v8App, "Exit", false);
//        }
//
//
//    }
}
