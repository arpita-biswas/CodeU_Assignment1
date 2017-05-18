# CodeU_Assignment1
Please view branch "review" for reviewing my code

Assignment 1 has two questions:
## Q1
Problem: Given two strings, write a method to decide if one is a permutation of the other. 

The two strings are expected to be provided as command line arguments, (args[0] and args[1]).
If either of the strings are null, the program flags this as an invalid input and terminates right away.
If the sizes of the two strings differ, then it returns false.
Else, I compute the character count for each character in args[0] and populate a HashMap, then I iterate over each character c in args[1]. If c is present in arg[0] we decrement the character count of c in the HashMap. If the count becomes negative or if c does not occur in args[0] at all, then the program returns false.
## Q2 
Problem: Implement an algorithm to find the kth to last element of a singly linked list.

I have implemented a singly linked list class which contains a method to return the kth last element. Also, from the main function I call another function that takes as input a linked list and an integer k, and returns kth last element of the linked list. 
If k >= length of linked list, then it prints an error statement.
If k < 0, then it also prints an error statement.
Else, it maintains a window of length k where "right margin" of the window is pointed by a "current" pointer and "left margin" is pointed by a "follower" pointer. We start the window with "current" pointing to the k-th element from the head, and "follower" pointing to the head element of the linked list. Then slide the window to the right until "current" reaches the last element of the linked list. When this happens, "follower" points to kth to last element.
