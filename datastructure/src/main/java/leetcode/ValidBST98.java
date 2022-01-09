package leetcode;


public class ValidBST98 {
    /**
     * @param root
     * @return
     */

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        validBST(root,null,null);

        return true;
    }

    public boolean validBST(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (max != null && val > max.intValue()) {
            return false;
        }
        if (min != null && val < min.intValue()) {
            return false;
        }
        if(root.left != null){
            validBST(root.left,val,min);
        }
        if(root.right != null){
            validBST(root.right,max,val);
        }
        return true;
    }


    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null && left.val <= root.val) {
            boolean res = leftValid(left, root.val, left.val);
            if (!res) {
                return false;
            }
        }
        if (right != null && right.val <= root.val) {
            boolean res = rightValid(right, right.val, root.val);
            if (!res) {
                return false;
            }
        }
        return true;
    }


    boolean leftValid(TreeNode next, Integer max, int min) {
        if (next == null) {
            return true;
        }
        TreeNode left = next.left;
        TreeNode right = next.right;
        if (left != null && left.val > min) {
            return false;
        }
        if (right != null && (right.val < min || right.val > max)) {
            return false;
        }
        if (left != null) {
            leftValid(left, left.val, min);
        }
        if (right != null) {
            leftValid(right, max, right.val);
        }
        return true;
    }

    boolean rightValid(TreeNode next, Integer max, Integer min) {
        if (next == null) {
            return true;
        }
        TreeNode left = next.left;
        TreeNode right = next.right;
        if (left != null && (left.val < min || left.val > max)) {
            return false;
        }
        if (right != null && (right.val < max)) {
            return false;
        }
        if (left != null) {
            leftValid(left, left.val, min);

        }
        if (right != null) {
            leftValid(right, next.val, min);


        }
        return true;
    }
}
