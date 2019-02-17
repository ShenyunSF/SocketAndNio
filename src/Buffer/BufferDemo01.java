package Buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.junit.Test;

/**
 * ����buffer���ĸ�������mark,position,limit,capacity,
 * @author davy0755
 *
 */
public class BufferDemo01 {

	/**
	 *limit�����Ƶ�buffer�Ĵ�С������Ϊ0�������Ǵ�1��ʼ
	 */
	@Test
	public void limitTest() {
		char[] charArray=new char[]{'a','b','c','d','e'};
		CharBuffer buffer = CharBuffer.wrap(charArray);
		System.out.println("A:"+buffer.toString()+" ,A capacity()= "+buffer.capacity()+" limit="+buffer.limit());
		buffer.limit(0);
		System.out.println();
		System.out.println("B:"+buffer.toString()+" ,B capacity()= "+buffer.capacity()+" limit="+buffer.limit());
		buffer.put(0,'o');
		buffer.put(1, 'p');
		buffer.put(2, 'q');
		//buffer.put(3,'r'); �˴��ͻᱨ����
		//buffer.put(4, 's');
	}
	
	/**
	 * ����position����һ����ʼ��ȡ����д��Ԫ�ص�����
	 */
	@Test
	public void positionTest() {
		char[] charArray=new char[]{'a','b','c','d','e'};
		CharBuffer buffer = CharBuffer.wrap(charArray);
		System.out.println("A:"+buffer.toString()+" ,A capacity()= "+buffer.capacity()+" limit="+buffer.limit()
		+" ");
		buffer.limit(0);
		System.out.println();
		System.out.println("B:"+buffer.toString()+" ,B capacity()= "+buffer.capacity()+" limit="+buffer.limit());
	}
	
	@Test
	public void testFilp()
	{
		CharBuffer buffer = CharBuffer.allocate(20);
		buffer.put("�����й��������л����񹲺͹�");
		buffer.position(0);
		for (int i=0;i<buffer.limit();i++)
		{
			System.out.print(buffer.get());
		}//��ӡ����14���й��ֺ󣬻����4���ո�
		System.out.println();
		//��Ҫ��Ϊ��put()����
		buffer.clear();
		buffer.put("����������");
		//�ڲ�ʵ�ַ�������position��ֵ��limit��Ȼ��position=0��mark=-1�����Բ����пո���֡���Ҫ��Ϊ��get()����
		buffer.flip();
		for (int i=0;i<buffer.limit();i++)
		{
			System.out.print(buffer.get());
		}
	}
	
	@Test
	public void testRemiaining()
	{
		byte[] byteArray= {1,2,3,4,5,6,7,8,9};
		ByteBuffer buffer = ByteBuffer.wrap(byteArray);
		System.out.println("position:"+buffer.position()+"   limit:"+buffer.limit());
		System.out.println(buffer.remaining());
	}
}