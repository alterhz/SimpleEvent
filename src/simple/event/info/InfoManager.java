package simple.event.info;

import simple.event.core.ListenEvent;

public class InfoManager {
	@ListenEvent
	public static void onEventStartGame(EventGameStart eventInfo) {
		System.out.println("InfoManager.onEventStartGame EventGameStart");
	}
	
	@ListenEvent
	public static void onEventTest2(EventGameStart eventInfo) {
		System.out.println("InfoManager.onEventTest2 EventGameStart");
	}
}
