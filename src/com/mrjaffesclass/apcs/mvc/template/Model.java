package com.mrjaffesclass.apcs.mvc.template;

import com.mrjaffesclass.apcs.messenger.*;

public class Model implements MessageHandler {

  // Messaging system for the MVC
  private final Messenger mvcMessaging;
  public Model(Messenger messages) {
    mvcMessaging = messages;
  }
  
  public void init() {
    mvcMessaging.subscribe("view:ageButton", this);
  }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("MSG: received by model: "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("MSG: received by model: "+messageName+" | No data sent");
    }  
        if(messageName.equals("view:ageButton"))
        {
            mvcMessaging.notify("model:getAges", calcAges(Integer.parseInt((String)messagePayload)));
        }
    }
    
  public int[] calcAges(int age)
    {
        int i[] = new int[2];
        i[0] = (int)Math.ceil((double)age/2+7);
        i[1] = (int)Math.ceil((double)age*2-14);
        return i;
    }
  
}
