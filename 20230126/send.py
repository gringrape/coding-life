import pika
import time

connection = pika.BlockingConnection(
    pika.ConnectionParameters('localhost')
)

channel = connection.channel()

channel.queue_declare(queue="hello")

for i in range(100):
    message = f'Message {i}'
    channel.basic_publish(
        exchange="",
        routing_key="hello",
        body=message
    )

print("Message sent!")

channel.close()
