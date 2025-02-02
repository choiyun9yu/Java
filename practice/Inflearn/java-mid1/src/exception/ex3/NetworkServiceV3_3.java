package exception.ex3;

import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.NetworkClientExceptionV3;
import exception.ex3.exception.SendExceptionV3;

public class NetworkServiceV3_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV3 | SendExceptionV3 e) {
            System.out.println("[오류] 메시지:" + e.getMessage());
        } catch (NetworkClientExceptionV3 e) {
            throw new RuntimeException(e);
        } finally {
            client.disconnect();
        }
    }
}
