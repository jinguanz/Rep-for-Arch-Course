/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and others contributors as indicated 
 * by the @authors tag. All rights reserved. 
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors. 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 * 
 * (C) 2005-2006,
 * @author JBoss Inc.
 */


import java.util.ArrayList;
import java.util.HashMap;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

public class OrderRequestAction extends AbstractActionLifecycle
{
   protected ConfigTree _config;

   public OrderRequestAction(ConfigTree config)
   {
      _config = config;
   }

   public Message noOperation(Message message)
   {
      return message;
   }
   
   /*
    * Convert the message into a webservice request map.
    */
   public Message option1(Message message) throws Exception
   {
      logHeader();
      System.out.println("Webservice Option 1 Request Action\n");
      String msgBody = (String) message.getBody().get();
      HashMap requestMap = new HashMap();
      Order order = new Order();
      order.setId((long)1);
      order.setShipTo("Address1");
      
      Bike bike1 = new Bike();
      bike1.setId((long)1);
      bike1.setModelName("Model1");
      bike1.setPrice((float)1000.00);
      bike1.setBrand("Brand1");
      
      Bike bike2 = new Bike();
      bike1.setId((long)2);
      bike1.setModelName("Model2");
      bike1.setPrice((float)1500.00);
      bike1.setBrand("Brand2");
      
      ArrayList bikeList = new ArrayList();
      bikeList.add(bike1);
      bikeList.add(bike2);
      
      order.setLineItems(bikeList);
      
      ProcessOrderRequest requestObject = new ProcessOrderRequest();
      requestObject.setOrder(order);
      requestMap.put("processOrder", requestObject);
      //requestMap.put("order", order);
      
      message.getBody().add(requestMap);
      System.out.println("Request map is: " + requestMap.toString());

      logFooter();
      return message;
   }
   
   /*
    * Convert the message into a webservice request map.
    */
   @SuppressWarnings("unchecked")
public Message option2(Message message) throws Exception
   {
      logHeader();
      System.out.println("BikeOrderService Option 2 Request Action\n");
      String msgBody = (String) message.getBody().get();
      HashMap requestMap = new HashMap();
          
      // add paramaters to the web service request map
      requestMap.put("processOrder.order.id", "1");
      requestMap.put("processOrder.order.shipTo", "Address1");
      
      requestMap.put("processOrder.order.lineItems[0].id", "1");      
      requestMap.put("processOrder.order.lineItems[0].name", "Model1");
      requestMap.put("processOrder.order.lineItems[0].price", "1000.00");
      requestMap.put("processOrder.order.lineItems[0].brand", "Brand1");
      
      requestMap.put("processOrder.order.lineItems[0].id", "2");      
      requestMap.put("processOrder.order.lineItems[0].name", "Model2");
      requestMap.put("processOrder.order.lineItems[0].price", "1500.00");
      requestMap.put("processOrder.order.lineItems[0].brand", "Brand2");
      
      // The "paramsLocation" property was set in jboss-esb.xml to
      message.getBody().add(requestMap);
      System.out.println("Request map is: " + requestMap.toString());

      logFooter();
      return message;
   }
   
    public void exceptionHandler(Message message, Throwable exception)
   {
      logHeader();
      exception.printStackTrace();
      System.out.println("!ERROR!");
      System.out.println(exception.getMessage());
      System.out.println("For Message: ");
      System.out.println(message.getBody().get());
      logFooter();
   }

   // This makes it easier to read on the console
   private void logHeader()
   {
      System.out.println("Order Action started..");
   }

   private void logFooter()
   {
      System.out.println("Order Action completed..");
   }

}