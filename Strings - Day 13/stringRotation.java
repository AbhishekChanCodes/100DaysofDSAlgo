/*

Given two strings s1 and s2, find if s2 is a rotation of s1.

Example 1:
s1 = "water" s2 = "terwa"
Ans: true

Example 2:
s1 = "water" s2 = "watre"
Ans: false

*/


/*

Approach: You can do it in brute-force method, by comparing the characters and comparing their order. However, we don't
          need so many computations.

          We concatenate s1 to itself. If s2 is a rotation of s1, it will be contained in s1 + s1. If yes, return true,
          else false.

          Eg: waterwater contains the string terwa so it is true.

*/


public boolean isRotation(String s1, String s2) {

  if(s1.length() != s2.length())
    return false;

  return (s1+s1).contains(s2);

}
