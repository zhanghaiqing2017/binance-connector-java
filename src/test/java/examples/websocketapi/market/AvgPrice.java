package examples.websocketapi.market;

import com.binance.connector.client.impl.WebsocketApiClientImpl;

public final class AvgPrice {

    private AvgPrice() {
    }

    private static final int waitTime = 3000;

    public static void main(String[] args) throws InterruptedException {
        WebsocketApiClientImpl client = new WebsocketApiClientImpl();
        client.connect(((event) -> {
            System.out.println(event);
        }));

        client.market().avgPrice("BTCUSDT", null);

        Thread.sleep(waitTime);
        client.close();

    }
}
