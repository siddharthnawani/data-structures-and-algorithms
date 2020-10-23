package src.com.sid.hashmapAndHeap.heap;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericPriorityQueue {

    public static class PriorityQueue<T>{
        ArrayList<T> data;
        Comparator comp;

        public PriorityQueue(){
            data=new ArrayList<>();
            comp=null;
        }

        public PriorityQueue(Comparator comp){
            data=new ArrayList<>();
            this.comp=comp;
        }

        private boolean isSmaller(int i,int j){
            if(comp==null){
                Comparable ith=(Comparable) data.get(i);
                Comparable jth=(Comparable) data.get(j);
                if(ith.compareTo(jth)<0)
                        return true;
                else
                    return false;
            }else{
                T ith=data.get(i);
                T jth=data.get(j);

                if(comp.compare(ith,jth) < 0)
                    return true;
                else
                    return false;
            }
        }

        public void add(T val){
            data.add(val);
            upheapify(data.size()-1);
        }

        public void upheapify(int i){
            if(i==0)
                return;
            int pi = (i-1) /2;
            if(isSmaller(i,pi)==true){
                swap(i,pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j) {
            T ith=data.get(i);
            T jth=data.get(j);
            data.set(i,jth);
            data.set(j,ith);
        }

        public T remove(){
            if(this.size()==0){
                System.out.println("Underflow");
                return null;
            }

            swap(0,data.size()-1);
            T val=data.remove(data.size()-1);
            downheapify(0);

            return val;
        }

        private void downheapify(int pi) {
            int min=pi;

            int li= 2* pi +1;
            if(li < data.size() && isSmaller(li,min)==true){
                min=li;
            }

            int ri= 2* pi +2;
            if(ri < data.size() && isSmaller(ri,min)==true){
                min=ri;
            }

            if(min !=pi){
                swap(pi,min);
                downheapify(min);
            }

        }

        private int size() {
            return data.size();
        }

        public T peek(){
            if(this.size()==0){
                System.out.println("Underflow");
                return null;
            }
            return data.get(0);
        }
    }

    static class Student implements Comparable<Student>{
        int rno;
        int ht;
        int wt;

        Student(int rno,int ht,int wt){
            this.rno=rno;
            this.ht=ht;
            this.wt=wt;
        }

        @Override
        public int compareTo(Student o) {
            return this.rno-o.rno;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "rno=" + rno +
                    ", ht=" + ht +
                    ", wt=" + wt +
                    '}';
        }
    }

    static class StudentWtComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.wt-o2.wt;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq=new PriorityQueue<>(new StudentWtComparator());

        pq.add(new Student(10,180,81));
        pq.add(new Student(2,185,85));
        pq.add(new Student(12,170,84));
        pq.add(new Student(18,179,88));
        pq.add(new Student(7,182,82));

        while(pq.size() > 0){
            System.out.println(pq.peek());
            pq.remove();
        }

    }

}
