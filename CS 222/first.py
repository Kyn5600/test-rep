import math

n =  int(input("enter an int > 1: "))
if n <= 1:
    print("Not a prime")
else:
    if n==2:
        print("prime")
    else:
        d = 2
        flag = True
        while d <= math.sqrt(n):
            if n%d == 0:
                print("not a prime")
                flag = False
                break
            d = d + 1
        if flag == True:
            print("Prime")