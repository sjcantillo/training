import sys

def get_tests():
    cases = []
    with open(sys.argv[1], "r") as f:
        for i in f:
            cases.append(i.strip())
    return cases

def suma(lista):
    data = list(map(int,lista.split(',')))
    max = min(data)
    res = 0
    tam = len(data)
    for indx in range(tam):
        for indy in range(indx+1,tam):
            res = (sum(data[indx:indy]))
            if res > max:
                max = res
    print (max)

def main():
    tests = get_tests()
    for integer in tests:
        suma(integer)

main()
