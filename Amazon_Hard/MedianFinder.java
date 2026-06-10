package Amazon_Hard;

import java.util.PriorityQueue;

import javax.print.attribute.standard.Media;

import Amazon_Easy.missingNO;

public class MedianFinder{

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->b-a);
    }

    public  void addNum(int n){
        maxHeap.offer(n);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public  double findMedian(){
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        else{
            return (minHeap.peek()+maxHeap.peek())/2.0d;
        }
    }

    public static void main(String[] args){
         MedianFinder obj = new MedianFinder();
         obj.addNum(1);
         obj.addNum(2);
         System.out.println(obj.findMedian());
         obj.addNum(3);
         System.out.println(obj.findMedian());
    }
}