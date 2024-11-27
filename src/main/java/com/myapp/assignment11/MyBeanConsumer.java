package com.myapp.assignment11;

public class MyBeanConsumer {
  public MyBeanConsumer(MyBean myBean) {
		System.out.println("MyBeanConsumer created");
		System.out.println("myBean hashcode = " + myBean.hashCode());
	}
  public void greet(){
    System.out.println("MyBeanConsumer says Good Soy.");
  }
}
