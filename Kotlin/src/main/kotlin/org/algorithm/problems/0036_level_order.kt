// Problem Statement
// Given a binary tree, return the level order traversal of its nodes' values.
// (ie, from left to right, level by level).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
package org.algorithm.problems

import org.algorithm.shared.TreeNode
import java.util.ArrayDeque;

class `0036_level_order` {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result: MutableList<MutableList<Int>> = mutableListOf<MutableList<Int>>();

        if (root == null)
            return result;

        val bfs: ArrayDeque<TreeNode?> = ArrayDeque<TreeNode?>();
        bfs.add(root);

        while (bfs.isNotEmpty()) {
            val level: MutableList<Int> = mutableListOf<Int>();
            var tam: Int = bfs.size;
            while (tam > 0) {
                val node: TreeNode? = bfs.pollFirst();
                level.add(node!!.`val`);
                if (node.left != null)
                    bfs += node.left;
                if (node.right != null)
                    bfs += node.right;
                tam--;
            }
            result.add(level);
        }

        return result;
    }
}