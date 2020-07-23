import java.util.*;

class Node{
    int row;
    int col;
    
    
    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}




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
