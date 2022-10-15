# LinkedList-Info 
[Singly-LinkedList-Basic-Ops](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/SinglyLinkedList.java) \
[Reverse-Singly-LinkedList](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/ReverseSinglyLinkedList.java) \
[Loop-Detection-Deletion-In-Singly-LinkedList](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/LoopDetectionandDeletion.java) \
[Remove-Duplicates](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/RemoveDuplicatesinLinkedList.java) \
[Add-1-to-List](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/Add1ToList.java) \
[Add 2 LinkedList](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/Add2List.java) \
[Intersection of 2 LinkedList](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/IntersectionOf2List.java) \
[Palindrome](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/Palindrome.java) \
[Merge-Sort](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/MergeSort.java) \
[Doubly-Linked-List-Basic-Ops](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/DoublyLinkedList.java) \
[Pair with a given sum in DLL](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/PairWithGivenSumInDLL.java) \
[Triplet with a given sum in DLL](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/TripletWithGivenSum.java) \
[Reverse DLL](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/ReverseDoublyLinkedList.java) \
[sort 0s, 1s and 2s](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/Sort_0_1_2.java) \
[Merge K sorted List](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/MergeKSortedList.java) \
[Reverse Node In Even Length](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/ReverseNodeInEvenLength.java) \
[Node cloning](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/NodeCloning.java) \
[DeleteNodeHavingGreaterValueOnRight](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/DeleteNodeHavingGreaterValueOnRight.java) \
[NthNodeFromEndOfList](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/NthNodeFromEndOfList.java) \
[Flattening a Linked List](https://github.com/mkeshav218/DSA/blob/master/src/linkedList/FlatteningLinkedList.java) \

//QuickSort
//sort a K sorted DLL

Q) Can we reverse a linked list in less than O(n) ?
Ans :- No, It is not possible to reverse a singly-linked-list in less than O(n). But, In case of doubly-linked-list, if we swap the head & tail pointer, & consider nextPointer as prevPointer & vice-versa then only it is possible.

Q) Why Quicksort is preferred for. Arrays and Merge Sort for LinkedLists ?
Ans :- Quick Sort is an in-place sort (i.e. it doesn’t require any extra storage) whereas merge sort requires O(N) extra storage, N denoting the array size. Allocating and de-allocating the extra space used for merge sort increases the running time of the algorithm.

In linked lists, we can insert items in the middle in O(1) extra space and O(1) time if we are given a reference/pointer to the previous node. Therefore, we can implement the merge operation in the merge sort without using extra space.
Quick Sort requires a lot of access to different memory locations. To access ith index in a linked list, we have to travel each and every node from the head to ith node as we don’t have a continuous block of memory. Therefore, the overhead increases for quick sort. On the other hand, merge sort accesses data sequentially and the need for random access is low.