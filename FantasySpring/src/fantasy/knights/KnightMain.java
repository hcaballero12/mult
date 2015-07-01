package fantasy.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("Knights.xml");
		Knight knight = (Knight)context.getBean("knight");
		knight.embarkOnQuest();
	
	}

}
