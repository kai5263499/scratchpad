#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include "include/simp_str.h"

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

	printf("str1 [%s] with len [%zu] and buf_len [%zu]\n\n", str1->str, str1->len, str1->buf_len);

	printf("copied_str2 [%s] with len [%zu] and buf_len [%zu]\n\n", copied_str2->str, copied_str2->len, copied_str2->buf_len);

	printf("str1 and str1 match result: %i\n\n", simp_str_equals(str1, str1));
	printf("str1 and str2 match result: %i\n\n", simp_str_equals(str1, str2));
	printf("str1 and str3 match result: %i\n\n", simp_str_equals(str1, str3));

	printf("str1 and copied_str match result: %i\n\n", simp_str_equals(str1, copied_str));
	printf("str1 and copied_str2 match result: %i\n\n", simp_str_equals(str1, copied_str2));

	simp_str_format(str1, "string is %d", 5);
	printf("str1 is now [%s] with len [%zu] and buf_len [%zu]\n\n", str1->str, str1->len, str1->buf_len);

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
