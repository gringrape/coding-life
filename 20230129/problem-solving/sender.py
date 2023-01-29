import pika
import json


def main():
    connection = pika.BlockingConnection(
        pika.ConnectionParameters("localhost")
    )
    channel = connection.channel()

    channel.queue_declare(queue="hello")

    works = [{"id": i, "destination": "problem-1"} for i in range(100)]

    for work in works:
        channel.basic_publish(
            exchange="", routing_key="hello", body=json.dumps(work)
        )
    print("[x] Sent 'Hello, World!'")

    connection.close()


main()
