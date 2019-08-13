package simple.event;

import simple.event.core.Event;
import simple.event.info.EventGameEnd;
import simple.event.info.EventGameStart;
import simple.event.info.EventTest;

public class TestMain {
	public static void main(String[] args) {
		
		Event.listen("simple.event.info");
		Event.listen("simple.event.manager");

		Event.fire(new EventGameStart());
		Event.fire(new EventGameEnd());
		Event.fire(new EventTest());
	}
	
	public void otherTest() {
		
	}
	
	
}
