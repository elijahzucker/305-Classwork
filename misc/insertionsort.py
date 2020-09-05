def insertionSort(A):
    count = 0
    for i in range(1,len(A)):
        key = A[i]
        j = i-1
        while j>=0 and key<A[j]:
            A[j+1] = A[j]
            j -=1
            count+=1
        A[j+1] = key
    print(count)
    
def permutation(lst): 
    if len(lst) == 0: 
        return [] 
    if len(lst) == 1: 
        return [lst] 
    l = []
    for i in range(len(lst)): 
       m = lst[i] 
       remLst = lst[:i] + lst[i+1:] 
       for p in permutation(remLst): 
           l.append([m] + p) 
    return l 

#l = list('25789') 
#for p in permutation(l): 
#    insertionSort(p) 
a = [99, 98, 97, 96, 95, 94, 93, 92, 91, 90,89, 88, 87, 86, 85, 84, 83, 82, 81, 80,79, 78, 77, 76, 75, 74, 73, 72, 71, 70,69, 68, 67, 66, 65, 64, 63, 62, 61, 60,59, 58, 57, 56, 55, 54, 53, 52, 51, 50,49, 48, 47, 46, 45, 44, 43, 42, 41, 40,39, 38, 37, 36, 35, 34, 33, 32, 31, 30,29, 28, 27, 26, 25, 24, 23, 22, 21, 20,19, 18, 17, 16, 15, 14, 13, 12, 11, 10,9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
insertionSort(a)
#b = [7,1,9]
#insertionSort(b)
#c = [9,1,7]
#insertionSort(c)
#d = [1,9,7]
#insertionSort(d)
#e = [7,9,1]
#insertionSort(e)
#f = [9,7,1]
#insertionSort(f)
