package Buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.junit.Test;

/**
 * 测试buffer的四个特征：mark,position,limit,capacity,
 * @author davy0755
 *
 */
public class BufferDemo01 {

	/**
	 *limit：限制的buffer的大小，可以为0，但是是从1开始
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
		//buffer.put(3,'r'); 此处就会报错了
		//buffer.put(4, 's');
	}
	
	/**
	 * 测试position：下一个开始读取或者写入元素的索引
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
		buffer.put("我是中国人我在中华人民共和国");
		buffer.position(0);
		for (int i=0;i<buffer.limit();i++)
		{
			System.out.print(buffer.get());
		}//打印出来14个中国字后，会带有4个空格
		System.out.println();
		//主要是为了put()数据
		buffer.clear();
		buffer.put("我是美国人");
		//内部实现方法，将position赋值给limit，然后position=0，mark=-1，所以不会有空格出现。主要是为了get()数据
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