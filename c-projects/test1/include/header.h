#ifndef SIMP_STR_H
#define SIMP_STR_H

typedef struct _simp_str {
 char *str;
 size_t len;
 size_t buf_len;
} simp_str;

simp_str* simp_str_init(const char* _string, size_t _size);
void simp_str_destroy(simp_str*); //assume input was created with simp_str_init
int simp_str_equals(simp_str *s1, simp_str *s2); // return 0 if equal, otherwise -1
int simp_str_format(simp_str *in, const char *fmt, ...); // sprintf style formatting INTO simp_str *in.
														 //returns 0 on success
simp_str* simp_str_copy(simp_str*);

#endif //SIMP_STR_H