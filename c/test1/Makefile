CC=gcc
CFLAGS=-I./include -I/usr/include/sys -Wall
DEPS = simp_str.h
OBJ = main.o simp_str.o 

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

test1: $(OBJ)
	gcc -o $@ $^ $(CFLAGS)

.PHONY: clean

clean:
	rm -f *.o test1