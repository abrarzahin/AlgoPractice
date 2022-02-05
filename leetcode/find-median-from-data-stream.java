class MedianFinder {
    /*
    time:O(logN)  At worst, there are three heap insertions and two heap deletions from the top. Each of these takes about O(\log n)O(logn) time.
    space:O(N) linear space to hold input in containers.
    two heap technique, take max and min queue
    */
    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;
    public MedianFinder() {
        maxQ=new PriorityQueue<>((a,b) -> b-a);
        minQ=new PriorityQueue<>();
    }
    public void addNum(int num) {
        // add to the max heap
        maxQ.offer(num);
        // add min values to the min heap
        minQ.offer(maxQ.poll());
        // balance
        if(maxQ.size()<minQ.size()) maxQ.offer(minQ.poll());
    }

    public double findMedian() {
        if(maxQ.size()==0) return 0;
            //only max can have one extra element based on our balanceing
            // if max larger then return its peek otherwise do division of it.
        return maxQ.size()>minQ.size()?maxQ.peek():(double)(maxQ.peek()+minQ.peek())/2;

    }
}