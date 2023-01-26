import pika
import sys
import os
import time


def main():
    connection = pika.BlockingConnection(
        pika.ConnectionParameters('localhost')
    )

    channel = connection.channel()

    channel.queue_declare(queue="hello")

    def handle_message(ch, methos, properties, body):
        time.sleep(1)
        print("Done: %r" % body)

    channel.basic_consume(
        queue="hello",
        on_message_callback=handle_message,
        auto_ack=True
    )

    print('Waiting for messages')
    channel.start_consuming()


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)
