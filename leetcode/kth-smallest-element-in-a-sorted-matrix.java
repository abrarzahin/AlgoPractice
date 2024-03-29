import java.util.*;
class Node{
    int row;
    int col;
    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
/*
Time Complexity: O(X+Klog(X)).  Well the heap construction takes O(X)time.
After that, we perform K iterations and each iteration has two operations. We extract the minimum element from a heap containing XXelements. Then we add a new element to this heap. Both the operations will takeO(log(X)) time.
Thus, the total time complexity for this algorithm comes down to be       O(X+Klog(X)) where X is min(K,N)

Space Complexity: O(X) which is occupied by the heap.
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1,n2)-> 
matrix[n1.row][n1.col]-matrix[n2.row][n2.col]);
        // add 1st element of each row to the minheap.
        // no need to put more then k element.
        for(int i =0; i < matrix.length && i < k; i++){
            minHeap.add(new Node(i, 0));
        }
        int count =0, result=0;
        while( !minHeap.isEmpty()){
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if(++count == k) break;
            node.col++;
            if(matrix[0].length > node.col){
                minHeap.add(node);
            }
        }
        return result;
    }
}
