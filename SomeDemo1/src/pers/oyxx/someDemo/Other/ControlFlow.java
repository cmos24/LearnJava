package pers.oyxx.someDemo.Other;

public class ControlFlow {//控制流程
	
	//得到1~20范围内两个数相除结果最接近黄金分割数0.618的两个数
	public void getGoldenSectionNum(int num1,int num2){
		int temp1,temp2,last1 = 0,last2 = 0;
		double shang,ca,minca = 20;
	
		for(temp1=num1;temp1<=num2;temp1++){
			for(temp2=num1;temp2<=num2;temp2++){
				if(0==temp1%2 && 0==temp2%2){continue;}//如果分子和分母同时为偶数则跳过
				System.out.println("temp1="+temp1+"/temp2="+temp2);
				shang=((double)temp1/(double)temp2);
				System.out.println("shang="+shang);
				if(shang>0.618){
					ca=shang-0.618;
				}else{
					ca=0.618-shang;
				}
				System.out.println("ca="+ca);
				if(ca<minca){//如果当前两个数的商更接近0.618则写入储存的变量
					last1=temp1;
					last2=temp2;
					minca=ca;
				}
				System.out.println("last1="+last1+"/last2="+last2);
				System.out.println();
			}
		}
		System.out.println("离黄金分割点最近的两个数是："+last1+"/"+last2);		
	}
	
	//得到水仙花数方法1
	public void getNarcissusNumber1(){
		boolean isNarcissusNumber;
		int bai,shi,ge;
		for(int i=100;i<999;i++){
			bai=i/100;
			shi=i/10-10*bai;
			ge=i%10;
			//System.out.println("bai+shi+ge="+bai+"-"+shi+"-"+ge);
			isNarcissusNumber=(   i==(Math.pow(bai,3)+Math.pow(shi, 3)+Math.pow(ge,3))   );
			if(isNarcissusNumber){
				System.out.println(i+"是水仙花数");
			}
		}
	}
	//得到水仙花数方法2（不用逐个位计算，每个位对应一个变量操作，更方便一些）
	public void getNarcissusNumber2(){
		for(int a=1;1<=a&a<10;a++){
	        for(int b=0;0<=b&b<10;b++){
	            for(int c=0;0<=c&c<10;c++){
	                int e=0;
	                int f=0;
	            e =(int)(Math.pow(a, 3)+Math.pow( b, 3)+Math.pow(c, 3));
	            f=(int)(100*a+10*b+c);
	                if(e!=f){
	                    continue;
	                }else if(e==f){
	                    System.out.println(e+"是水仙花数");
	                }
	                     
	            }
	        }
		}	 
	}
	
}
