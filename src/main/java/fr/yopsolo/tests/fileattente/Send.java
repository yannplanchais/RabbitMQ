package fr.yopsolo.tests.fileattente;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.util.concurrent.TimeoutException;

public class Send {

  private final static String QUEUE_NAME = "hello";


  public static void main(String[] argv)
      throws java.io.IOException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    factory.setPort(5672); // Port par défaut de RabbitMQ
    Connection connection = null;
    Channel channel = null;
    try {
      connection = factory.newConnection();
      channel = connection.createChannel();
      DeclareOk recepisse = channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      String message = "Hello World!";
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

      System.out.println(" [x] Sent '" + message + "'");


    } catch (TimeoutException e) {
      e.printStackTrace();
    } finally {
      assert channel != null;
      try {
        channel.close();
      } catch (TimeoutException e) {
        e.printStackTrace();
      }
      connection.close();
    }
  }
}
