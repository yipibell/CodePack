package Quiz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrincipleQuiz {
    /*todo: make it add list of numbers until you get some target number*/
    public void numSeries(boolean printSteps, int tar) {
        boolean printsteps=false;
        int count=1;
        int sum=0;
        while(sum<tar){
            sum+=count;
            if (printsteps)System.out.println("in step "+count+", the sum was "+sum);
            count++;
        };
        System.out.println("the total number of steps is: "+(count-1)+" white a leftover of "+(sum-tar));
    }
    /*todo: Sum a list of ints in for,while,recurcion*/
    public int sumfor(ArrayList<Integer> x){
        Integer sum1=0;
        for (Integer i:x){
            sum1+=i;
        }
        return sum1;
    }
    public int sumwhile(ArrayList<Integer> x){
        int sum1=0;
        int i=x.size()-1;
        while (i>-1){
            sum1+=x.get(i);
            i--;
        }
        return sum1;
    }
    public int sumrec(ArrayList<Integer> x){
        int sum=0;
        if (x.size()==1){return x.get(0);}
        else {
            int last=x.get(x.size()-1);
            x.remove(x.size()-1);
            sum=sumrec(x)+last;
        }
        return sum;
    }
    /*todo: Make a list Combiner*/
    public void listCombineRun() {
        int[] intarrey = new int[]{1, 4, 5, 7, 9, -1, 12, 5557};
        String[] stringarrey = new String[]{"sup", "pup", "loop", "ass", "home"};
        List<Object> x = new LinkedList<>();
        List<Object> y = new LinkedList<>();

        for (Integer i : intarrey) x.add(i);
        for (String i : stringarrey) y.add(i);

        for (Object o :listcombine(x, y)) {
            System.out.printf(o + ",");
        }
    }
    public List<Object> listcombine(List<Object> a, List<Object> b){
            List<Object>lo=new LinkedList<>();
            if (a.size()>=b.size()){
                for (Object o:a){
                    lo.add((Object) o);
                    if (b.size()-1>=a.indexOf(o)){lo.add(b.get(a.indexOf(o)));}
                }
            }else {
                for (Object o:b){
                    lo.add((Object) o);
                    if (a.size()-1>=b.indexOf(o)){lo.add(a.get(b.indexOf(o)));}
                }
            }
            return lo;
    }
    /*todo: make a fibonachi number finder*/
    public void fiborun(){
            ArrayList<Long>inhencedFibo=new ArrayList<>();
            inhencedFibo.add(0, (long) 0);
            inhencedFibo.add(1, (long) 1);

            fibo(100,inhencedFibo);
            for (Long x:inhencedFibo){
                System.out.println("step "+(inhencedFibo.indexOf(x))+"\t\t has the value of "+x );
            }
    }
    public long fibo(int n,ArrayList<Long> x){
            if (n<=x.size()-1){
                return x.get(n);
            }
            else {
                x.add(n,(fibo(n-2,x)+fibo(n-1,x)));
                return x.get(n);
            }
    }
    /*todo: Make the biggest number of a number List*/
    public void bigNumberBuilderRun(){
        int[] intarrey = new int[]{1,13,5,17,7,22,49,9,7,4};
        List<Integer> x = new LinkedList<>();
        for (Integer i : intarrey) x.add(i);
        System.out.println(bigNumberBuilder(x));
    }
    public String bigNumberBuilder(List<Integer> x){
        boolean valid=true;
        for (int a:x){if (a<0){valid=false;}}
        if (valid){
            String number="";
            do {
                int index=-2;
                int Checked1st=-1;
                for (int a:x){
                    String s1=""+Checked1st;
                    String s2=""+a;
                    if (Integer.valueOf(s1.charAt(0))>Integer.valueOf(s2.charAt(0))){
                    }else if (Integer.valueOf(s1.charAt(0))==Integer.valueOf(s2.charAt(0))){
                        if (Integer.valueOf(s1+s2)>Integer.valueOf(s2+s1)){}
                        else {Checked1st=a;}
                    }else Checked1st=a;
                    if (Checked1st==a){index=x.indexOf(a);}
                }
                x.remove(index);
                number+=Checked1st;
            }while (x.size()>0);
            return number;
        }
        return "";
    }
    /*todo: Change the sign betwin =,-,and combining 2 nums to achive a number*/
    public static void OperetionGame(String[] args) {
        int cou=0;
        int tot=0;
        for (int op1=0;op1<=2;op1++){
            for (int op2=0;op2<=2;op2++){
                for (int op3=0;op3<=2;op3++){
                    for (int op4=0;op4<=2;op4++){
                        for (int op5=0;op5<=2;op5++){
                            for (int op6=0;op6<=2;op6++){
                                for (int op7=0;op7<=2;op7++){
                                    for (int op8=0;op8<=2;op8++){
                                        int sum=0;
                                        String a="1"+ operetion(op1)+"2"+ operetion(op2)+"3"+ operetion(op3)+"4"+ operetion(op4)+"5"+ operetion(op5)+"6"+ operetion(op6)+"7"+ operetion(op7)+"8"+ operetion(op8)+"9";
                                        String[] nums=a.split("#");
                                        for (String n:nums){
                                            sum+=Integer.valueOf(n);
                                        };

                                        if (sum==100){
                                            System.out.println(a.replace("#","")+"="+sum);
                                            cou++;
                                        }
                                        tot++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cou+" of "+tot);
    }
    public static String operetion(int op){
        switch (op){
            case 0:
                return "";
            case 1:
                return "#+";
            default:
                return "#-";
        }
    }
}



