/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serHelper(root, sb);
        return sb.toString().trim();   
    }
    
    public void serHelper(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }
        sb.append(String.valueOf(node.val)+",");
        serHelper(node.left, sb);
        serHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
        String[] arr = data.split(",");
        List<String> list = new ArrayList<String>(Arrays.asList(arr));
        return desHelper(list);
    }
    
    public TreeNode desHelper(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = desHelper(list);
        root.right = desHelper(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
