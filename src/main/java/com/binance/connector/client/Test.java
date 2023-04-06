package com.binance.connector.client;

import com.binance.connector.client.impl.WebsocketApiClientImpl;
import com.binance.connector.client.impl.websocketapi.WebSocketApiAccount;
import com.binance.connector.client.utils.MockData;

public class Test {
    public static void main(String[] args) {
        WebsocketApiClientImpl client = new WebsocketApiClientImpl();
        client.connect(((event) -> {
            System.out.println(event);
        }));
        WebSocketApiAccount account = client.account(MockData.API_KEY, MockData.HMAC_SIGNATURE_GENERATOR);
        account.accountStatus(null);
    }
}
