package com.binance.connector.client.utils;

import com.binance.connector.client.exceptions.BinanceConnectorException;
import com.binance.connector.client.impl.WebsocketApiClientImpl;
import com.binance.connector.client.impl.websocketapi.WebSocketApiAccount;
import com.binance.connector.client.utils.websocketapi.WebSocketApiRequestHandler;

public class Test {
    public static void main(String[] args) {
        WebsocketApiClientImpl client = new WebsocketApiClientImpl();
        client.connect(((event) -> {
            System.out.println(event);
        }));
//        WebSocketApiRequestHandler handler=new WebSocketApiRequestHandler(MockData.WS_CONNECTION, MockData.API_KEY, MockData.HMAC_SIGNATURE_GENERATOR);
        WebSocketApiAccount account = client.account(MockData.API_KEY, MockData.HMAC_SIGNATURE_GENERATOR);
        account.accountStatus(null);
    }
}
