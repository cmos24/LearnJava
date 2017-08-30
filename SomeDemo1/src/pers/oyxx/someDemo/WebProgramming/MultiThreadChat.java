package pers.oyxx.someDemo.WebProgramming;

//多线程聊天
public class MultiThreadChat {
	/*步骤 1 : 同时收发消息
	在练习-服务端和客户端互聊 中，只能一人说一句，说了之后，必须等待另一个人的回复，才能说下一句。

	这是因为接受和发送都在主线程中，不能同时进行。 为了实现同时收发消息，基本设计思路是把收发分别放在不同的线程中进行

	1. SendThread 发送消息线程
	2. RecieveThread 接受消息线程
	3. Server一旦接受到连接，就启动收发两个线程
	4. Client 一旦建立了连接，就启动收发两个线程*/
}
