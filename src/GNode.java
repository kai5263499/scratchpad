import java.util.ArrayList;

/**
 * Created by wes on 9/23/14.
 */
public class GNode {
    public String name;
    public ArrayList<GNode> children;

    public String getName() {
        return name;
    }
    public ArrayList<GNode> getChildren() {
        return children;
    }
}
