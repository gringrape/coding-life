import pika
import json
import time


def main():
    connection = pika.BlockingConnection(
        pika.ConnectionParameters("localhost")
    )
    channel = connection.channel()

    channel.queue_declare(queue="hello")

    def handle_message(ch, method, properties, body):
        work = json.loads(body)

        time.sleep(1)

        print(f'{work["id"]} done')
        channel.basic_publish(
            exchange="", routing_key=work["destination"], body=body
        )

    channel.basic_consume(
        queue="hello",
        on_message_callback=handle_message
    )

    channel.start_consuming()


main()
