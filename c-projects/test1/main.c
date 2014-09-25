#include <stdio.h>
#include <string.h>
#include <malloc.h>
#include <assert.h>
#include <stdarg.h>
#include "include/header.h"

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
	free(s);
}

simp_str* simp_str_copy2(simp_str *in) {
	simp_str *ret = malloc(sizeof(simp_str));

	// I'm losing 14 bytes here and I don't know why..
	// size_t str_len = strlen(in->str)-2;

	// //ret->str = malloc((ret->len-1));
	// ret->str = malloc(sizeof(char)*(str_len+1));
	// strncpy(ret->str, in->str, str_len);
	// ret->str[str_len] = '\0';

	while(*in->str!='\0')    //2
    {
      ret->str=in->str;                               //3
      ret->str++;
      in->str++;                                   //4
    }
    ret->str='\0';

	ret->buf_len = in->buf_len;
	ret->len = ret->len;

	return ret;
}

int simp_str_format(simp_str *in, const char *fmt, ...) {
	
	free(*in->str);

	char dest[1024 * 16]; // this is ugly
	va_list argptr;
    va_start(argptr, fmt);
    vsprintf(dest, fmt, argptr);
    va_end(argptr);

    in->str = dest;

	return 0;
}

/***************
 * Do not edit 
 ***************/
simp_str* simp_str_copy(simp_str *in) {
	simp_str *ret = malloc(sizeof(simp_str));
	ret->len = in->len;
	ret->buf_len = in->buf_len;
	ret->str = malloc(ret->len);

	if (NULL == ret->str)
	{
	    return NULL;
	}
	strncpy(ret->str, in->str, ret->len);
	return ret;
}
/***************
 * Do not edit 
 ***************/

int is_big_endian(void)
{
   unsigned int i = 1;
   char *c = (char*)&i;
   return *c;   
}

int test_bit(unsigned int number, unsigned char position) {
	return (number>>(position)) & 1;
}

int main(int argc, char **argv)
{
	printf("big edian: %i\n\n", is_big_endian());
	
	simp_str *str1 = simp_str_init("my first string", 64);
	simp_str *str2 = simp_str_init("my other string", 128);
	simp_str *str3 = simp_str_init("my first strang", 64);

	simp_str *copied_str = simp_str_copy(str1);
	simp_str *copied_str2 = simp_str_copy2(str1);

	printf("created a string [%s] with len [%i] and buf_len [%i]\n\n", str1->str, str1->len, str1->buf_len);

	printf("str1 and str2 match result: %i\n\n", simp_str_equals(str1, str2));
	printf("str1 and str3 match result: %i\n\n", simp_str_equals(str1, str3));

	simp_str_format(str1, "string is %d", 5);
	printf("str1 is now [%s] with len [%i] and buf_len [%i]\n\n", str1->str, str1->len, str1->buf_len);

	printf("cleaning up\n\n");
	simp_str_destroy(str1);
	simp_str_destroy(str2);
	simp_str_destroy(str3);
	simp_str_destroy(copied_str);
	simp_str_destroy(copied_str2);

	unsigned int number_to_test = 113;
	int bit_to_test = 4;

	printf("test_bit %i of %i returns %i\n\n", bit_to_test, number_to_test, test_bit(number_to_test,bit_to_test));

	printf("press enter to exit.\n");

	getchar();
	return 0;
}
