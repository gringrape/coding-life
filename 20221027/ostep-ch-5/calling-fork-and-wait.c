#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
  printf("hello world (pid:%d)\n", (int)getpid());

  int returnCode = fork();

  if (returnCode < 0) {
    fprintf(stderr, "fork failed\n");
    exit(1);
  } else if (returnCode == 0) {
    printf("hello, I am child (pid:%d)\n", (int)getpid());
  } else {
    int returnCodeWait = wait(NULL);
    printf("hello, I am parent of %d (rc_wait:%d) pid:%d", returnCode,
           returnCodeWait, (int)getpid());
  }

  return 0;
}
