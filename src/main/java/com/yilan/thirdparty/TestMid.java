package com.yilan.thirdparty;

import com.yilan.thirdparty.utils.BlowfishECB;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.nio.CharBuffer;
import java.util.zip.CRC32;

public class TestMid {
	public static void main(String args[]) throws Exception {
		Socket socket = new Socket("10.7.90.73", 9101);

		// �ͻ��˵������
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();

		PrintWriter pw = new PrintWriter(os);// ���������װ�ɴ�ӡ��+

		Reader reader = new InputStreamReader(is);
		CharBuffer charBuffer = CharBuffer.allocate(8192);
		int index = -1;

		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// ����Ϣд����,�������Ϣ���ݸ�������
		// os.write("0041|0044|6c6a5543|KDGATEWAY1.2||||||1|||301|Z|10500000316|97B43A2B6D2C2E3E|thinkive|".getBytes());
		String qdStr = "0033|0004||KDGATEWAY1.2||||||1|||100|";
		System.out.println("CLIENT:" + qdStr);
		pw.write(qdStr);
		// pw.println("0041|0044|cf5a13e3|KDGATEWAY1.2||||||1|||301|Z|10500000316|B74511CDE3AA29B7|thinkive|");
		// �ӷ������˽�����Ϣ
		pw.flush();
		// socket.shutdownOutput();

		// byte[] buffer = new byte[200];

		// int length = is.read(buffer);
		// String str = new String(buffer, 0, length);
		// System.out.println(str);

		String info = null;
		String str = null;
		/*
		 * while((info=br.readLine())!=null){ System.out.println(info); str =
		 * info; }
		 */
		// str=br.readLine();

		// while((index=reader.read(charBuffer))!=-1){
		reader.read(charBuffer);
		charBuffer.flip();

		// }
		str = charBuffer.toString();
		System.out.println("MID:" + str);

		String[] s = str.split("\\|");
		BlowfishECB bf = new BlowfishECB("SZKINGDOM");
		String dct = bf.decrypt(s[s.length - 1]);

		BlowfishECB pwbf = new BlowfishECB(dct);
		String password = pwbf.encrypt("123321  ");

		String logstr = "0041|0044|" + dct + "|KDGATEWAY1.2||||||1|||301|Z|10500000316|" + password + "|thinkive|";
		CRC32 crc32 = new CRC32();
		crc32.update(logstr.getBytes("UTF-8"));
		String crcStr = Long.toHexString(crc32.getValue());

		String logFinlStr = "0041|0044|" + crcStr + "|KDGATEWAY1.2||||||1|||301|Z|10500000316|" + password
				+ "|thinkive|";
		System.out.println("CLIENT:" + logFinlStr);

		pw.write(logFinlStr);
		pw.flush();

		// info=br.readLine();
		// System.out.println(info);
		/*
		 * while((info=br.readLine())!=null){ System.out.println(info); }
		 */
		index = -1;
		// while((index=reader.read(charBuffer))!=-1){
		reader.read(charBuffer);
		charBuffer.flip();
		System.out.println("MID:" + new String(charBuffer.toString().getBytes(),"GBK"));
		// }

		// �ر���Դ
		reader.close();
		pw.close();
		is.close();
		os.close();
		socket.close();
	}
}
