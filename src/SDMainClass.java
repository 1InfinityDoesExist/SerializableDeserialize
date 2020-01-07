import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SDMainClass {
	public static void main(String[] args) {
		DemoObject demoObject = new DemoObject();
		demoObject.setAge(10);
		demoObject.setName("Eldorado");
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(demoObject);
			oos.flush();
			oos.close();
			bos.close();

			ByteArrayInputStream bias = new ByteArrayInputStream(bos.toByteArray());
			Object obj = new ObjectInputStream(bias).readObject();
			DemoObject obj1 = (DemoObject) obj;
			System.out.println(obj1.getAge());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generatecatch block
			e.printStackTrace();
		}

		System.out.println("Second Way");
		SDInJava javaObject = new SDInJava();
		javaObject.serializableAndDeserializable(demoObject);
	}
}

class SDInJava {
	public void serializableAndDeserializable(DemoObject demo) {

		String fileName = "fileName.txt";

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(demo);
			oos.flush();
			oos.close();
			fos.close();
			FileInputStream fis = new FileInputStream(fileName);
			Object obj = new ObjectInputStream(fis).readObject();
			DemoObject demoValue = (DemoObject) obj;
			System.out.println(demoValue.getAge());
		} catch (ClassNotFoundException | IOException ex) {

		}
	}
}

class DemoObject implements Serializable {
	private String name;
	private int age;

	public DemoObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemoObject(String name, int age) {
		super();
		this.name = name;
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
