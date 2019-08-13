package simple.event.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import javax.management.RuntimeErrorException;

import simple.event.EventManager;
import simple.event.info.EventGameEnd;


public class Event {
	
	private static Map<String, List<Method>> listenMethods = new HashMap<>();
	
	public static void listen(String packagePath) {
		Set<Class<?>> eventClasses = ClassTools.getClasses(packagePath);
		
		for (Class<?> eventClass : eventClasses) {
			registClass(eventClass);
		}
	}
	
	public static void registClass(Class<?> c) {
		Method[] methods = c.getDeclaredMethods();
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
					throw new RuntimeException("ListenEvent监听函数[" + method + "]参数错误");
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
	
}
