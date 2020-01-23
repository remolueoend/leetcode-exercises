/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

class BinTree {
    class Node {
        int index;
        int value;
        Node left;
        Node right;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    Node root;

    public void add(int index, int value) {
        if (this.root == null) {
            this.root = new Node(index, value);
        } else {
            this.insert(this.root, index, value);
        }
    }

    private void insert(Node node, int index, int value) {
        if (node.index == index) {
            return; // ignore duplicate indices
        }
        if (index < node.index) {
            if (node.left == null) {
                node.left = new Node(index, value);
            } else {
                this.insert(node.left, index, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(index, value);
            } else {
                this.insert(node.right, index, value);
            }
        }
    }

    public int get(int index) {
        return this.get(this.root, index);
    }

    private int get(Node node, int index) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if(node.index == index) {
            return node.value;
        } else if(node.index > index) {
            return this.get(node.left, index);
        } else {
            return this.get(node.right, index);
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        BinTree tracker = new BinTree();
        for (int i = 0; i < nums.length; i++) {
            int currVal = nums[i];
            int leftIndex = tracker.get(currVal);
            if(leftIndex != Integer.MIN_VALUE) {
                return new int[]{leftIndex, i}; 
            } else {
                tracker.add(target - nums[i], i);
            }
        }
        throw new RuntimeException("not found");
    }
}
// @lc code=end
