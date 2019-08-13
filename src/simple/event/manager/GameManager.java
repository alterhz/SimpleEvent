package simple.event.manager;

import simple.event.core.ListenEvent;
import simple.event.info.EventGameStart;

public class GameManager {
	
	@ListenEvent
	public static void onEventStartGame(EventGameStart eventInfo) {
		System.out.println("GameManager.onEventStartGame");
	}
}
