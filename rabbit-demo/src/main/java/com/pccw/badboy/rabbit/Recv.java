package com.pccw.badboy.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

public class Recv {
	private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DeliverCallback deliverCallback = (consumerTag,delivery) -> {
        	String message = new String(delivery.getBody(),"UTF-8");
        	System.out.println(" [x] Received '" + message + "'");
        };
        
        channel.basicConsume(QUEUE_NAME, true, deliverCallback,consumerTag -> {});
        
        
        
//        // 定义队列的消费者
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//
//        // 监听队列
//        channel.basicConsume(QUEUE_NAME, true, consumer);
//
//        // 获取消息
//        while (true) {
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String message = new String(delivery.getBody());
//            System.out.println(" [x] Received '" + message + "'");
//        }
    }
}
