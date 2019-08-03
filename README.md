# SimpleEvent
designed by java reflection.  a simple synchronized event.


SimpleEvent in 3 step.

1. Define event
	    
		public class EventGameStart {
			public EventGameStart() {
				
			}
		}

2. Prepare subscribe.
	
	    @ListenEvent
    	public static void OnEventStarGame(EventGameStart eventInfo) {
    		System.out.println("OnEventTest EventGameStart");
    	}

3. Post event.


    	Event.fire(new EventGameStart());