package com.jiang.zheng.yan.goldscissorslibrary;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * "金剪刀"注解工具
 * 
 * @author jiang_yan
 * 
 */
public class GoldenScissors {

	public static void cut(final Activity activity) {

		bindLayout(activity);
		bindFields(activity);
		bindMethod(activity);

	}

	/**
	 * 绑定布局
	 * 
	 * @param activity
	 *            所在对象
	 */
	private static void bindLayout(Activity activity) {
		final Class<? extends Context> clazz = activity.getClass();

		LayoutViewCut layoutViewCut = clazz.getAnnotation(LayoutViewCut.class);
		if (layoutViewCut != null) {
			int layoutResId = layoutViewCut.value();
			try {
				Method method = clazz.getMethod("setContentView",
						new Class[] { Integer.TYPE });
				method.invoke(activity, layoutResId);
			} catch (Throwable th) {
				throw new InjectException(new Throwable(th.getMessage() + " : "
						+ th));
			}
		}
	}

	/**
	 * 绑定方法,即点击事件
	 * 
	 * @param activity
	 *            所在对象
	 */
	private static void bindMethod(final Activity activity) {
		final Class<? extends Context> clazz = activity.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (final Method method : methods) {
			OnClickCut injectMetheds = method.getAnnotation(OnClickCut.class);
			method.setAccessible(true);
			if (injectMetheds != null) {
				int[] resIds = injectMetheds.value();
				for (int i = 0; i < resIds.length; i++) {
					final View view = activity.findViewById(resIds[i]);
					view.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							try {
								method.invoke(activity, view);
							} catch (Throwable th) {
								throw new InjectException(
										new Throwable(
												"Inject method failed,please checked you methed inject names"));
							}

						}
					});
				}

			}

		}
	}

	/**
	 * 绑定多个成员变量
	 * 
	 * @param activity
	 *            所在对象
	 */
	private static void bindFields(Activity activity) {

		final Class<? extends Context> clazz = activity.getClass();
		Field[] declaredFields = clazz.getDeclaredFields();

		ArrayList<Integer> filedResIdList = new ArrayList<Integer>();
		ArrayList<String> filedNameList = new ArrayList<String>();
		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			ViewCut injectFiled = field.getAnnotation(ViewCut.class);
			if (injectFiled != null) {

				String filedName = field.getName();
				if (!filedNameList.contains(filedName)) {
					filedNameList.add(filedName);
				}
				int[] resIds = injectFiled.value();

				for (int x = 0; x < resIds.length; x++) {
					int k = resIds[x];
					if (!filedResIdList.contains(k)) {
						filedResIdList.add(k);
					}
				}
			}
		}

		int declaredFieldsLength = filedNameList.size();
		int resIdsLength = filedResIdList.size();

		if (declaredFieldsLength > resIdsLength) {
			throw new InjectException(
					new Throwable(
							"DeclaredFileds' counts  cannot be more than inject ResIds'  counts"));
		} else if (declaredFieldsLength < resIdsLength) {
			throw new InjectException(
					new Throwable(
							"Inject ResIds' counts  cannot be more than DeclaredFileds' counts"));
		}

		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			ViewCut injectFiled = field.getAnnotation(ViewCut.class);
			if (injectFiled != null) {

				int resId = filedResIdList.get(i);
				View view = activity.findViewById(resId);
				field.setAccessible(true);
				try {
					field.set(activity, view);
				} catch (Throwable th) {
					throw new InjectException(
							new Throwable(
									"Inject failed ,maybe your context is null or recorrect"));
				}

			}
		}
	}
}
