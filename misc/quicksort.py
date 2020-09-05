count=0
def partition(A,p,r):
    x = int(A[r])
    i = p-1
    global count
    for j in range(p,r):
        if int(A[j]) < i:
            i = i+1
            A[i],A[j] = A[j],A[i]
            count = count+1
        A[i+1],A[r] = A[r],A[i+1]
        count+=1
        return (i+1)

def quickSort(A,p,r):
    if p<r:
        q = partition(A,p,r)

        quickSort(A,p,q-1)
        quickSort(A,q+1,r)

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

l = list('25789') 
for p in permutation(l): 
    count = 0
    quickSort(p,0,4)
    print(count)

#count = 0
#a = [1,7,9]
#quickSort(a,0,2)
#print(count)
#count = 0
#b = [7,1,9]
#quickSort(b,0,2)
#print(count)
#count = 0
#c = [9,1,7]
#quickSort(c,0,2)
#print(count)
#count = 0
#d = [1,9,7]
#quickSort(d,0,2)
#print(count)
#count = 0
#e = [7,9,1]
#quickSort(e,0,2)
#print(count)
#count = 0
#f = [9,7,1]
#quickSort(f,0,2)
#print(count)
#count = 0
