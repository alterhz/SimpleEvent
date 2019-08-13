package simple.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Consumer;

import simple.event.info.EventGameEnd;

public class EffectiveTest {

	public static void main(String[] args) {
		// 函数调用、函数式接口调用和反射Invoke调用效率对比
		fireEffectiveTest(new EventGameEnd());

		EventManager.printCount();
	}

	public static <T> void fireEffectiveTest(T eventInfo) {

		EventGameEnd eventGameEnd = (EventGameEnd) eventInfo;

		try {
			Method method = EventManager.class.getDeclaredMethod("onEventEnd1", EventGameEnd.class);

			Consumer<EventGameEnd> func1 = (Consumer<EventGameEnd>) EventManager::onEventEnd3;

			int loop = 100000000;

			long t1 = System.currentTimeMillis();
			for (int i = 0; i < loop; ++i) {
				method.invoke(null, eventGameEnd);
			}
			long t2 = System.currentTimeMillis();
			for (int i = 0; i < loop; ++i) {
				EventManager.onEventEnd2(eventGameEnd);
			}
			long t3 = System.currentTimeMillis();
			for (int i = 0; i < loop; ++i) {
				func1.accept(eventGameEnd);
			}
			long t4 = System.currentTimeMillis();

			System.out.println("call refection invoke:" + (t2 - t1));
			System.out.println("call function directly:" + (t3 - t2));
			System.out.println("call function interface:" + (t4 - t3));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
