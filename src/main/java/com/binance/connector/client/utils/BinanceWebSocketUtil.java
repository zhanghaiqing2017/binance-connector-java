package com.binance.connector.client.utils;

import com.binance.connector.client.impl.WebsocketApiClientImpl;
import com.binance.connector.client.impl.websocketapi.WebSocketApiAccount;
import com.binance.connector.client.impl.websocketapi.WebSocketApiGeneral;
import org.json.JSONObject;

import java.time.Clock;
import java.time.ZoneId;
import java.util.*;
import java.util.logging.Logger;


public class BinanceWebSocketUtil {
  public static  WebsocketApiClientImpl client ;

  public  static Map<String,Class> requestMap=new HashMap<>();

  private static String pingId;

  static {
    new Thread(new Runnable() {
      @Override
      public void run() {
        client=new WebsocketApiClientImpl();
        conntent();
        while (true){
          try {
            Thread.sleep(1000*10);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          if(pingId!=null){

            try {
//              client.close();
              client = new WebsocketApiClientImpl();
              Thread.sleep(1000*10);


            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }


            conntent();
            pingId=null;

          }
          WebSocketApiGeneral general = client.general(MockData.API_KEY, MockData.HMAC_SIGNATURE_GENERATOR);

          Object ping = general.ping(null);
          System.out.println(new Date().toString());
          pingId=ping.toString();
          System.out.println("ping:{}"+ping.toString());
        }
      }
    }).start();

  }

  public BinanceWebSocketUtil(){
  }
  private static void conntent(){
    client.connect(((event) -> {
      System.out.println(new Date().toString());
      System.out.println("response:{}"+event);
      JSONObject jsonObject = new JSONObject(event);
      if(pingId!=null&&pingId.equalsIgnoreCase(jsonObject.getString("id"))){
        pingId=null;
      }
//        Class id = requestMap.get();

    }));

  }

  public static String  getAccount(String apiKey,String secret_key){

    WebSocketApiAccount account = client.account(apiKey,  new HmacSignatureGenerator(secret_key));
//        new
    Object o = account.accountStatus(null);

    System.out.println(o.toString());
    return o.toString();
  }
  public static String getOrder(String apiKey,String secret_key,long startOrderid,String symbol){
    WebSocketApiAccount account = client.account(apiKey,  new HmacSignatureGenerator(secret_key));
    org.json.JSONObject jsonObject=new org.json.JSONObject();
    jsonObject.put("fromId",startOrderid);
    Object o = account.accountTradeHistory(symbol,jsonObject);
    System.out.println(o.toString());
    return o.toString();
  }

  public static void main(String[] args) throws InterruptedException {
//    Thread.sleep(1000*3l);
//    BinanceWebSocketUtil util=new BinanceWebSocketUtil();
//    String account = util.getAccount("66dLHliynTUBTTPymeoZkUXQQMJWMT2mZ4hc4jeEg7hksgPjEC6NLGshrlrRfqZG",
//      "9b32ni7aI2qTGK32g51hvLK1vkekGZAKrVET1vOZvHWJ3JwyDqQDOmJq0UStZdOl");
//
//    String trxusdt = util.getOrder("66dLHliynTUBTTPymeoZkUXQQMJWMT2mZ4hc4jeEg7hksgPjEC6NLGshrlrRfqZG",
//      "9b32ni7aI2qTGK32g51hvLK1vkekGZAKrVET1vOZvHWJ3JwyDqQDOmJq0UStZdOl", 1, "TRXUSDT");
//    System.out.println(trxusdt);



//    while (true){
//      Thread.sleep(1000*60*3l);
//      util.getOrder("66dLHliynTUBTTPymeoZkUXQQMJWMT2mZ4hc4jeEg7hksgPjEC6NLGshrlrRfqZG",
//        "9b32ni7aI2qTGK32g51hvLK1vkekGZAKrVET1vOZvHWJ3JwyDqQDOmJq0UStZdOl", 1, "TRXUSDT");
//
//    }


  }

}
