package me.minikuma.v1;

public class HelloClientRunner {
    public static void main(String[] args) throws InterruptedException {
        // Stub 팩토리를 통해 채널을 만든다.
        String host = "localhost";
        int port = 54321;
        HelloClientStubFactory factory = new HelloClientStubFactory(host, port);
        HelloClient helloClient = new HelloClient(factory.getBlockingStub());
        helloClient.sendBlockingStub("Hello");
        factory.shutdownChannel();
    }
}
