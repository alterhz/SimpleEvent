package simple.event.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import simple.event.EventManager;
import simple.event.info.EventGameEnd;


public class Event {
	
	private static Map<String, List<Method>> listenMethods = new HashMap<>();
	
	static {
		initListen();
	}
	
	public static void initListen() {
		Method[] methods = EventManager.class.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(ListenEvent.class)) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				
				boolean rightMethod = false;
				
				if (parameterTypes.length == 1) {
					Class<?> parameterTypeEvent = parameterTypes[0];
					//if (parameterTypeEvent.getInterfaces()[0].equals(IEventInfo.class)) {
						String eventName = parameterTypeEvent.getName();
						listenMethods.putIfAbsent(eventName, new ArrayList<>());
						List<Method> allMethods = listenMethods.computeIfAbsent(eventName, k -> new ArrayList<>());
						allMethods.add(method);
						rightMethod = true;
					//}
				}
				
				if (!rightMethod) {
					System.out.println("ListenEvent监听函数[" + method + "]参数错误");
				}
			}
		}
	}
	
	public static <T> void fire(T eventInfo) {
		String eventName = eventInfo.getClass().getName();
		List<Method> allMethods = listenMethods.get(eventName);
		if (null != allMethods) {
			for (Method method : allMethods) {
				if (null != method) {
					try {
						method.invoke(null, eventInfo);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static <T> void fireEffectiveTest(T eventInfo) {
		
		EventGameEnd eventGameEnd = (EventGameEnd)eventInfo;
		
		try {
			Method method = EventManager.class.getDeclaredMethod("OnEventEnd1", EventGameEnd.class);
			
			Consumer<EventGameEnd> func1 = (Consumer<EventGameEnd>)EventManager::OnEventEnd3;
			
			int loop = 100000000;
			
			long t1 = System.currentTimeMillis();
			for (int i=0; i<loop; ++i) {
				method.invoke(null, eventGameEnd);
			}
			long t2 = System.currentTimeMillis();
			for (int i=0; i<loop; ++i) {
				EventManager.OnEventEnd2(eventGameEnd);
			}
			long t3 = System.currentTimeMillis();
			for (int i=0; i<loop; ++i) {
				func1.accept(eventGameEnd);
			}
			long t4 = System.currentTimeMillis();
			
			System.out.println("call refection invoke:" + (t2-t1));
			System.out.println("call function directly:" + (t3-t2));
			System.out.println("call function interface:" + (t4-t3));
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
