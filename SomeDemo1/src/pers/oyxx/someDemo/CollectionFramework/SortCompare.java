package pers.oyxx.someDemo.CollectionFramework;


import java.util.Arrays;
import java.util.List;
 
//冒泡、选择、二叉树排序效率对比
public class SortCompare {
 
    public static void main(String[] args) {
        //初始化随机数
        int total = 40000;
        System.out.println("初始化一个长度是"+total+"的随机数字的数组");
        int[] originalNumbers = new int[total];
        for (int i = 0; i < originalNumbers.length; i++) {
            originalNumbers[i] = (int)(Math.random()*total);
        }
        System.out.println("初始化完毕");
        System.out.println("接下来分别用3种算法进行排序");
         
        //从初始化了的随机数组复制过来，以保证，每一种排序算法的目标数组，都是一样的
        int[] use4sort;
         
        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersBySelection= performance(new SelectionSort(use4sort),"选择法");
         
        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByBubbling=performance(new BubblingSort(use4sort),"冒泡法");
         
        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByTree=performance(new TreeSort(use4sort),"二叉树");
         
        System.out.println("查看排序结果，是否是不同的数组对象");
        System.out.println(sortedNumbersBySelection);
        System.out.println(sortedNumbersByBubbling);
        System.out.println(sortedNumbersByTree);
         
        System.out.println("查看排序结果，内容是否相同");
        System.out.println("比较 选择法 和 冒泡法  排序结果：");
        System.out.println(Arrays.equals(sortedNumbersBySelection, sortedNumbersByBubbling));
        System.out.println("比较 选择法 和 二叉树  排序结果：");
        System.out.println(Arrays.equals(sortedNumbersBySelection, sortedNumbersByTree));
         
    }
     
    interface Sort{
        void sort();
        int[] values();
    }
     
    static class SelectionSort implements Sort{
 
        int numbers[];
        SelectionSort(int [] numbers){
            this.numbers = numbers;
        }
         
        @Override
        public void sort() {
            for (int j = 0; j < numbers.length-1; j++) {
                for (int i = j+1; i < numbers.length; i++) {
                    if(numbers[i]<numbers[j]){   
                        int temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                    }
                }
            }
        }
 
        @Override
        public int[] values() {
            // TODO Auto-generated method stub
            return numbers;
        }
         
    }
     
    static class BubblingSort implements Sort{
        int numbers[];
        BubblingSort(int [] numbers){
            this.numbers = numbers;
        }
        @Override
        public void sort() {
            for (int j = 0; j < numbers.length; j++) {
                for (int i = 0; i < numbers.length-j-1; i++) {
                    if(numbers[i]>numbers[i+1]){   
                        int temp = numbers[i];
                        numbers[i] = numbers[i+1];
                        numbers[i+1] = temp;
                    }
                }
            }
        }
        @Override
        public int[] values() {
            // TODO Auto-generated method stub
            return numbers;
        }
         
    }
     
    static class TreeSort implements Sort{
        int numbers[];
        BinaryTree n;
         
        TreeSort(int [] numbers){
            n =new BinaryTree();
            this.numbers = numbers;
        }
        @Override
        public void sort() {
         
            for (int i : numbers) {
                n.add(i);
            }
        }
        @Override
        public int[] values() {
            List<Object> list = n.values();
            int sortedNumbers[] = new int[list.size()];
            for (int i = 0; i < sortedNumbers.length; i++) {
                sortedNumbers[i] = Integer.parseInt(list.get(i).toString());
            }
            return sortedNumbers;
        }
    }
 
    private static int[] performance(Sort algorithm, String type) {
        long start = System.currentTimeMillis();
        algorithm.sort();
        int sortedNumbers[] = algorithm.values();
        long end = System.currentTimeMillis();
        System.out.printf("%s排序，一共耗时 %d 毫秒%n",type,end-start);
        return sortedNumbers;
    }
}
