package simple.event;

import simple.event.core.ListenEvent;
import simple.event.info.EventGameEnd;
import simple.event.info.EventGameStart;

public class EventManager {

	public static long count = 0;
	public static long count2 = 0;
	public static long count3 = 0;
	
	@ListenEvent
	public static void onEventStartGame(EventGameStart eventInfo) {
		System.out.println("EventManager.onEventStartGame EventGameStart");
	}
	
	@ListenEvent
	public static void onEventTest2(EventGameStart eventInfo) {
		System.out.println("EventManager.onEventTest2 EventGameStart");
	}
	
	@ListenEvent
	public static void onEventEnd(EventGameEnd eventInfo) {
		System.out.println("EventManager.onEventEnd EventGameEnd");
	}
	
	@ListenEvent
	public static void onEventEnd1(EventGameEnd eventInfo) {
		++count;
	}
	
	public static void onEventEnd2(EventGameEnd eventInfo) {
		++count2;
	}
	
	public static void onEventEnd3(EventGameEnd eventInfo) {
		++count3;
	}
	
	public static void printCount() {
		System.out.println("count:" + count);
		System.out.println("count2:" + count2);
		System.out.println("count3:" + count3);
	}
	
//	@ListenEvent
//	public static void OnEventTest3(EventGameStart eventInfo, int n) {
//		System.out.println("OnEventTest2 EventGameStart");
//	}
	
//	@ListenEvent(EventGameStart.class)
//	public static void OnEventTest(EventGameStart eventInfo) {
//		
//	}
//	
//	@ListenEvent(EventGameStart.class)
//	public static void OnEventTest2(EventGameStart eventInfo) {
//		
//	}
//	
//	
//	@ListenEvent(EventGameEnd.class)
//	public static void OnEventTest2(EventGameEnd eventInfo) {
//		
//	}
	
}
