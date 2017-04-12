package com.together;

import com.together.util.RSA_Encrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.websocket.server.ServerContainer;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerContainer.class)
public class ApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("\n");
		System.out.println(System.getProperty("user.dir"));
	}

	@Test
	public void testRSA() throws Exception{
//		RSA_Encrypt.generateKeyPair();
		System.out.println(RSA_Encrypt.getprivatekey());
		System.out.println(RSA_Encrypt.getpublickey());
		String source ="67650244";// 要加密的字符串
		String cryptograph = RSA_Encrypt.encrypt(source);// 生成的密文
		System.out.println(cryptograph);
		String target = RSA_Encrypt.decrypt(cryptograph);// 解密密文
		System.out.println("解密之后的明文是："+target);
		byte[]bytes =source.getBytes();
		// 产生签名
		String sign = RSA_Encrypt.sign(bytes, RSA_Encrypt.getprivatekey());
//		System.err.println("签名:" +sign);

		// 验证签名
		boolean status = RSA_Encrypt.verify(bytes, RSA_Encrypt.getpublickey(),sign);
		System.err.println("状态:" +status);

	}

	@Test
	public void soutFile(){
		try {
			FileInputStream input = new FileInputStream("publickey");
			byte[] bytes = new byte[1024];
			while (input.read(bytes)!=-1){
				System.out.println(new String(bytes));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
