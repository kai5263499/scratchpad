#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <malloc.h>
#include <assert.h>
#include <stdarg.h>
#include "include/simp_str.h"

simp_str* simp_str_init(const char* _string, size_t _size) {
	simp_str *mystr = malloc(sizeof(simp_str));

	mystr->buf_len = _size;
	mystr->str = (char *)_string;
	mystr->len = strlen(_string);

	return mystr;
}

int simp_str_equals(simp_str *s1, simp_str *s2) {
	int s1_len = strlen(s1->str);
	if(s1->len != s2->len || s1->buf_len != s2->buf_len || s1_len != strlen(s2->str)) return -1;

	int i;
	for(i=0;i<s1_len;i++) {
		if(s1->str[i] != s2->str[i]) return -1;
	}

	return 1;
}

void simp_str_destroy(simp_str* s) {
	assert(s != NULL);
	free(s);
}

simp_str* simp_str_copy2(simp_str *in) {
	simp_str *ret = simp_str_init(in->str, in->buf_len);
	return ret;
}

int simp_str_format(simp_str *in, const char *fmt, ...) {
	
	// free(in->str);

	char dest[1024 * 16]; // this is ugly
	va_list argptr;
    va_start(argptr, fmt);
    vsprintf(dest, fmt, argptr);
    va_end(argptr);

    in->str = dest;

	return 0;
}