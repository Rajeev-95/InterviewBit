/*Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
*
  Example
  Given the below binary tree and sum = 22,


              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

  return
[
   [5,4,11,2],
   [5,8,4,5]
]

*/
public class Solution {
    int B;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        if(A == null)                                                 //empty tree
            return new ArrayList<ArrayList<Integer>>();         
        this.B = B;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        help(A, res, item, 0);
        return res;
    }
     public void help(TreeNode A, ArrayList<ArrayList<Integer>> result, List<Integer> item, int added){
        added += A.val;
        item.add(A.val);
        if(A.left == null && A.right == null){          //this node is leaf node
            if(added == B){                       
                result.add(new ArrayList<Integer>(item));       //deep copy a new List
            }
        }
         else if(A.right == null){              //only have left child
            help(A.left, result, item, added); 
        }
        else if(A.left == null){               //only have right child
            help(A.right, result, item, added); 
        }else{                                        //both have left and right childs
            help(A.left, result, item, added); 
            
            help(A.right, result, item, added); 
        }                                              //backwards
        added -= A.val;
        item.remove(item.size() - 1);
     }
  }
  
