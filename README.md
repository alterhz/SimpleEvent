# SimpleEvent
designed by java reflection.  a simple synchronized event.


SimpleEvent in 3 step.

1. Define event.
    
```
	public class EventGameStart {
		public EventGameStart() {
				
		}
	}
```

2. Listen event.
	
```
	@ListenEvent
	public static void OnEventStarGame(EventGameStart eventInfo) {
		System.out.println("OnEventTest EventGameStart");
	}
```    

3. Post event.

```
Event.fire(new EventGameStart());
```

4. You also need to call.

```
	Event.listen();


	public static void main(String[] args) {
		
		Event.listen();

		Event.fire(new EventGameStart());
		Event.fire(new EventGameEnd());
		Event.fire(new EventTest());
	}
```