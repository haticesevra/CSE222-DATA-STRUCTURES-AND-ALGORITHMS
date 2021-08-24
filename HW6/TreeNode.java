import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    String val;
    List<TreeNode> children = new LinkedList<>();
    TreeNode(String data) {
        val = data;
    }
    TreeNode(String data, List<TreeNode> child) {
        val = data;
        children = child;
    }
}