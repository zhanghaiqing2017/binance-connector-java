package com.binance.connector.client.utils;

import okhttp3.Request;

import java.util.LinkedHashMap;

public final class MockData {
    private static final int intValue2 = 2;
    public static final int HTTP_STATUS_OK = 200;
    public static final int HTTP_STATUS_CLIENT_ERROR = 400;
    public static final int HTTP_STATUS_SERVER_ERROR = 502;
    public static final String PREFIX = "/";
    public static final String MOCK_RESPONSE = "{\"key_1\": \"value_1\", \"key_2\": \"value_2\"}";
    public static final String API_KEY = "66dLHliynTUBTTPymeoZkUXQQMJWMT2mZ4hc4jeEg7hksgPjEC6NLGshrlrRfqZG";
    public static final String SECRET_KEY = "9b32ni7aI2qTGK32g51hvLK1vkekGZAKrVET1vOZvHWJ3JwyDqQDOmJq0UStZdOl";
    public static final LinkedHashMap<String, Object> MOCK_PARAMETERS = new LinkedHashMap<String, Object>() {{
            put("key1", "value1");
            put("key2", intValue2);
        }};
    public static final HmacSignatureGenerator HMAC_SIGNATURE_GENERATOR = new HmacSignatureGenerator(SECRET_KEY);
    public static final WebSocketCallback noopCallback = msg -> { };
    public static final String WS_BASE_URL = "wss://testnet.binance.vision/ws-api/v3";
    public static final Request WS_REQUEST = RequestBuilder.buildWebsocketRequest(WS_BASE_URL);
    public static final WebSocketConnection WS_CONNECTION = new WebSocketConnection(noopCallback, noopCallback, noopCallback, noopCallback, WS_REQUEST, null);
    public static final String WS_ID = "websocketId";
    private MockData() {
    }
}
