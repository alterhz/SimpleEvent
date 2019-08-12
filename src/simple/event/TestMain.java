package simple.event;

import simple.event.core.Event;
import simple.event.info.EventGameEnd;
import simple.event.info.EventGameStart;
import simple.event.info.EventTest;

public class TestMain {
	public static void main(String[] args) {
		
		Event.listen();

		Event.fire(new EventGameStart());
		Event.fire(new EventGameEnd());
		Event.fire(new EventTest());
	}
	
	public void otherTest() {
		// 函数调用、函数式接口调用和反射Invoke调用效率对比
		Event.fireEffectiveTest(new EventGameEnd());
		
		EventManager.printCount();
	}
}
