package simple.event;

import simple.event.core.Listener;
import simple.event.core.ListenEvent;
import simple.event.info.EventGameEnd;
import simple.event.info.EventGameStart;

@Listener
public class EventManager {

	public static long count = 0;
	public static long count2 = 0;
	public static long count3 = 0;
	
	@ListenEvent
	public static void OnEventStarGame(EventGameStart eventInfo) {
		System.out.println("OnEventTest EventGameStart");
	}
	
	@ListenEvent
	public static void OnEventTest2(EventGameStart eventInfo) {
		System.out.println("OnEventTest2 EventGameStart");
	}
	
	@ListenEvent
	public static void OnEventEnd(EventGameEnd eventInfo) {
		System.out.println("OnEventEnd EventGameEnd");
	}
	
	@ListenEvent
	public static void OnEventEnd1(EventGameEnd eventInfo) {
		++count;
	}
	
	public static void OnEventEnd2(EventGameEnd eventInfo) {
		++count2;
	}
	
	public static void OnEventEnd3(EventGameEnd eventInfo) {
		++count3;
	}
	
	public static void printCount() {
		System.out.println("count:" + count);
		System.out.println("count2:" + count2);
		System.out.println("count3:" + count3);
	}
	
	@ListenEvent
	public static void OnEventTest3(EventGameStart eventInfo, int n) {
		System.out.println("OnEventTest2 EventGameStart");
	}
	
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
