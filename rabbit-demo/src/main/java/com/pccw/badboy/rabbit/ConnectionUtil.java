package com.pccw.badboy.rabbit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {

	public static Connection getConnection() throws Exception {
		// 定义连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		// 设置服务地址
		factory.setHost("localhost");
		// 端口
		factory.setPort(5672);
		// 设置账号信息，用户名、密码、vhost
		factory.setVirtualHost("testhost");
		factory.setUsername("admin");
		factory.setPassword("admin");
		// 通过工程获取连接
		Connection connection = factory.newConnection();
		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(System.getProperty("java.class.path"));
		
		
		Class<?> x = Class.forName("[B");
		System.out.println(x);

		x = ClassLoader.getSystemClassLoader().loadClass("[I");
		System.out.println(x);
		
		

		ClassLoader loader = ConnectionUtil.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader);
			loader = loader.getParent(); // 获得父类加载器的引用 } System.out.println(loader);
		}

		ClassLoader classLoader1 = new ClassLoader() {
			@Override
			public Class<?> loadClass(String s) throws ClassNotFoundException {
				try {
					if (s.equals("com.mythsman.test.Hello")) {
						byte[] classBytes = Files.readAllBytes(Paths.get("/home/myths/Desktop/test/Hello.class.1"));
						return defineClass(s, classBytes, 0, classBytes.length);
					} else {
						return super.loadClass(s);
					}
				} catch (IOException e) {
					throw new ClassNotFoundException(s);
				}
			}
		};

	}

}
