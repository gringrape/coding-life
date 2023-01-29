import pika
import json


def main():
    connection = pika.BlockingConnection(
        pika.ConnectionParameters("localhost")
    )
    channel = connection.channel()

    channel.queue_declare(queue="problem-1")

    completed_set = set()

    def handle_message(ch, method, properties, body):
        work = json.loads(body)
        completed_set.add(work["id"])
        print(f'{len(completed_set)} / 100 Done')

        if len(completed_set) == 100:
            channel.close(0)

    channel.basic_consume(
        queue="problem-1",
        on_message_callback=handle_message
    )

    channel.start_consuming()


main()
