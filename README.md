# CodeU_Assignment1
Please view branch "review" for reviewing my code

Assignment 1 has two questions:
## Q1
Problem: Given two strings, write a method to decide if one is a permutation of the other. 

If either of the strings are null, the program flags this as an invalid input and terminates right away.  
If the sizes of the two strings differ, then it returns false.  
Else, compute the character count for each character in s1 and populate a HashMap, then iterate over each character c in s2. If c is present in s1, decrement the character count of c in the HashMap. If the count becomes negative or if c does not occur in s1 at all, then the program returns false.

Test Cases:

"Listen", "Silent" => true  
"$b12", "12$b" => true  
"red", "zed" => false  
"red", "blue" => false  
"", "" => true  
"",	"34e" => false  
"hello world", "world hello" => true  
null, "sc" => Error statement: invalid input

## Q2 
Problem: Implement an algorithm to find the kth to last element of a singly linked list.

I have implemented a parameterized singly linked list class which contains a method to return the kth last element. From the main function one needs to call a helper function for a specific datatype of the linked list, that takes as input a linked list and an integer k, and returns kth last element of the linked list. In the test cases I have done this for Integer as well as String. The method within the Linked List class does the following:  
If k >= length of linked list, then it prints an error statement.  
If k < 0, then it also prints an error statement.  
Else, it maintains a window of length k where "right margin" of the window is pointed by a "current" pointer and "left margin" is pointed by a "follower" pointer. We start the window with "current" pointing to the k-th element from the head, and "follower" pointing to the head element of the linked list. Then slide the window to the right until "current" reaches the last element of the linked list. When this happens, "follower" points to kth to last element.

Test Cases:

1. Create a linked list and check with k = 0 and k = length(list)-1  
2. With an uninitialized linked list (=null), it would return an error message "NullPointerException: Linked List is not initialized"   
3. With an empty linked list (but initialized) and any k>=0, it would return an error message "k should be less than or equal to (length(list)-1)"  
4. Linked List: 1->2->3->4->5->6->7->8->9->10->null    k=1: 9,   k=0: 10,   k=9: 1
