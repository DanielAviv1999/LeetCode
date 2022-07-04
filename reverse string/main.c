#include <stdio.h>
#include <string.h>
void swapChar(char* pa, char* pb);
void reverseString(char* str);
int main() {
   char str[] = "abcd";
   printf("Before: %s\n", str);   
   reverseString(str);
   printf("After: %s\n", str);   
   return 0;
}
void swapChar(char* pa, char* pb) {
   char tmp = *pa;
   *pa = *pb;
   *pb = tmp;
}
void reverseString(char* str) {
   int i = 0, j = strlen(str) - 1;
   while (i < j) {
      swapChar(&str[i], &str[j]);
      ++i;
      --j;     
   }
}